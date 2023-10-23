
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {

    int count = 0;

    JFrame frame;
    JLabel p1PointsLabel;
    JLabel p2PointsLabel;
    JPanel panel;

    public GUI() {
        // This constructs the frame
        frame = new JFrame();

        // This creates the button, and the button text.
        JButton button = new JButton("Click me!");

        // This creates the label with the start text.
        p1PointsLabel = new JLabel("player 1 points: 0");
        p2PointsLabel = new JLabel("Player 2 points: 0");

        // This constructs the panel
        panel = new JPanel();

        // This is the event listener, for the button.
        button.addActionListener(this);

        // We give the panel some prameters
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button, panel, 0);
        panel.add(p1PointsLabel, panel, 1);
        panel.add(p2PointsLabel, panel, 2);

        // We add the panel to the frame, and give the frame more prameters
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Dice Game");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();

    }

    // this is the action preformed function, that "activates from the button click"
    public void actionPerformed(ActionEvent e) {
        count++;
        p1PointsLabel.setText("Player 1 points: " + count);
    }
}
