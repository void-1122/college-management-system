import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.*;
import java.sql.*;

public class Server {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(9090), 0);

        // LOGIN
        server.createContext("/login", exchange -> {
            if (exchange.getRequestMethod().equals("POST")) {

                BufferedReader br = new BufferedReader(
                        new InputStreamReader(exchange.getRequestBody()));
                String[] data = br.readLine().split(",");

                String user = data[0];
                String pass = data[1];

                PreparedStatement ps = DB.con.prepareStatement(
                        "SELECT * FROM users WHERE username=? AND password=?");
                ps.setString(1, user);
                ps.setString(2, pass);

                ResultSet rs = ps.executeQuery();
                String response = rs.next() ? "SUCCESS" : "FAIL";

                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.close();
            }
        });

        // ADD RESOURCE
        server.createContext("/add", exchange -> {
            if (exchange.getRequestMethod().equals("POST")) {

                Headers h = exchange.getRequestHeaders();
                String title = h.getFirst("title");
                String subject = h.getFirst("subject");
                String sem = h.getFirst("semester");

                byte[] fileData = exchange.getRequestBody().readAllBytes();
                String fileName = "file_" + System.currentTimeMillis() + ".pdf";
                Files.write(Paths.get(fileName), fileData);

                PreparedStatement ps = DB.con.prepareStatement(
                        "INSERT INTO resources(title,subject,semester,filename) VALUES(?,?,?,?)");
                ps.setString(1, title);
                ps.setString(2, subject);
                ps.setString(3, sem);
                ps.setString(4, fileName);
                ps.executeUpdate();

                String response = "Uploaded";
                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.close();
            }
        });

        // GET ALL
        server.createContext("/get", exchange -> {
            StringBuilder res = new StringBuilder();

            Statement st = DB.con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM resources");

            while(rs.next()) {
                res.append(rs.getString("title"))
                   .append(" | ")
                   .append(rs.getString("subject"))
                   .append(" | ")
                   .append(rs.getString("semester"))
                   .append(" | Download: http://localhost:9090/download?file=")
                   .append(rs.getString("filename"))
                   .append("\n");
            }

            exchange.sendResponseHeaders(200, res.length());
            exchange.getResponseBody().write(res.toString().getBytes());
            exchange.close();
        });

        // SEARCH
        server.createContext("/search", exchange -> {
            String key = exchange.getRequestURI().getQuery().split("=")[1];

            StringBuilder res = new StringBuilder();

            PreparedStatement ps = DB.con.prepareStatement(
                "SELECT * FROM resources WHERE title LIKE ? OR subject LIKE ? OR semester LIKE ?");

            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ps.setString(3, "%" + key + "%");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                res.append(rs.getString("title"))
                   .append(" | ")
                   .append(rs.getString("subject"))
                   .append(" | ")
                   .append(rs.getString("semester"))
                   .append(" | Download: http://localhost:9090/download?file=")
                   .append(rs.getString("filename"))
                   .append("\n");
            }

            exchange.sendResponseHeaders(200, res.length());
            exchange.getResponseBody().write(res.toString().getBytes());
            exchange.close();
        });

        // DOWNLOAD
        server.createContext("/download", exchange -> {
            String file = exchange.getRequestURI().getQuery().split("=")[1];
            byte[] data = Files.readAllBytes(Paths.get(file));

            exchange.getResponseHeaders().add(
                "Content-Disposition","attachment; filename=" + file);

            exchange.sendResponseHeaders(200, data.length);
            exchange.getResponseBody().write(data);
            exchange.close();
        });

        server.start();
        System.out.println("Server running on http://localhost:9090");
    }
}