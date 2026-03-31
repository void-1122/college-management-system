import javax.swing.*;

public class QuizPanel extends JPanel {

    public QuizPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel q = new JLabel(DataStore.questions.get(0));
        String[] opts = DataStore.options.get(0);

        JRadioButton a = new JRadioButton(opts[0]);
        JRadioButton b = new JRadioButton(opts[1]);
        JRadioButton c = new JRadioButton(opts[2]);
        JRadioButton d = new JRadioButton(opts[3]);

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
