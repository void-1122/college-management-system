import javax.swing.*;
import java.awt.*;

public class MainUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("College System");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Buttons
        JButton btn1 = new JButton("Resources");
        JButton btn2 = new JButton("Quiz");

        JPanel top = new JPanel();
        top.add(btn1);
        top.add(btn2);

        // Panel switching
        CardLayout cl = new CardLayout();
        JPanel mainPanel = new JPanel(cl);

        ResourcePanel rPanel = new ResourcePanel();
        QuizPanel qPanel = new QuizPanel();

        mainPanel.add(rPanel, "r");
        mainPanel.add(qPanel, "q");

        // Button actions
        btn1.addActionListener(e -> cl.show(mainPanel, "r"));
        btn2.addActionListener(e -> cl.show(mainPanel, "q"));

        frame.add(top, BorderLayout.NORTH);
        frame.add(mainPanel);

        frame.setVisible(true);
    }
}
