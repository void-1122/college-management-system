import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {

    JTextField username;
    JPasswordField password;
    JButton loginBtn;

    LoginFrame() {
        setTitle("Login");
        setSize(350, 220);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 100, 25);
        add(userLabel);

        username = new JTextField();
        username.setBounds(130, 30, 150, 25);
        add(username);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 100, 25);
        add(passLabel);

        password = new JPasswordField();
        password.setBounds(130, 70, 150, 25);
        add(password);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(110, 120, 100, 30);
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            String user = username.getText();
            String pass = new String(password.getPassword());

            if (user.equals("void") && pass.equals("void1122")) {
                new DashboardFrame();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login");
            }
        });

        setVisible(true);
    }
}
