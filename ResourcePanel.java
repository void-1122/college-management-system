import javax.swing.*;
import java.awt.*;

public class ResourcePanel extends JPanel {

    public ResourcePanel() {

        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Resources Section");
        heading.setHorizontalAlignment(JLabel.CENTER);

        String[][] data = DataStore.resources.toArray(new String[0][]);
        String col[] = {"Title", "Subject"};

        JTable table = new JTable(data, col);

        add(heading, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
