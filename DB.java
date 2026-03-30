import java.sql.*;

class DB {
    static Connection con;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "password" 
            );
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
