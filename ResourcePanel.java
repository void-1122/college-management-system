import javax.swing.*;
import java.awt.*;

public class ResourcePanel extends JPanel {

    public ResourcePanel() {

        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Resources Section");
        heading.setHorizontalAlignment(JLabel.CENTER);

        JTextField search = new JTextField("Search...");
        JButton upload = new JButton("Upload File");

        // Dummy data
        String data[][] = {
                {"Java Notes", "OOP"},
                {"DBMS Notes", "Database"}
        };

        String col[] = {"Title", "Subject"};

        JTable table = new JTable(data, col);

        add(heading, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.add(search);
        bottom.add(upload);

        add(bottom, BorderLayout.SOUTH);
    }
}
