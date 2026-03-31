import javax.swing.*;

public class DashboardFrame extends JFrame {

    DashboardFrame() {
        setTitle("Dashboard");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel title = new JLabel("Welcome to College Management System");
        title.setBounds(100, 50, 300, 30);
        add(title);

        JButton btnQuiz = new JButton("Open Quiz");
        btnQuiz.setBounds(150, 120, 200, 40);
        add(btnQuiz);

        JButton btnResource = new JButton("Resources");
        btnResource.setBounds(150, 180, 200, 40);
        add(btnResource);

        // Connect existing panels
        btnQuiz.addActionListener(e -> new QuizPanel());
        btnResource.addActionListener(e -> new ResourcePanel());

        setVisible(true);
    }
}
