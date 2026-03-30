import javax.swing.*;
import java.awt.*;

public class QuizPanel extends JPanel {

    public QuizPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel q = new JLabel("Q1: What is Java?");

        JRadioButton a = new JRadioButton("Language");
        JRadioButton b = new JRadioButton("Database");
        JRadioButton c = new JRadioButton("OS");
        JRadioButton d = new JRadioButton("Browser");

        ButtonGroup bg = new ButtonGroup();
        bg.add(a);
        bg.add(b);
        bg.add(c);
        bg.add(d);

        JButton next = new JButton("Next");

        add(q);
        add(a);
        add(b);
        add(c);
        add(d);
        add(next);
    }
}
