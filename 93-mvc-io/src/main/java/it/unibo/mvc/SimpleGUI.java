package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame();
    private final SimpleController controller = new SimpleController();

    /**
     * Constructor.
     */
    public SimpleGUI() {
        final JPanel canva = new JPanel();
        canva.setLayout(new BorderLayout());

        final JTextField textField = new JTextField("Hello there, you can edit me");
        canva.add(textField, BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea("You can't edit me :(");
        textArea.setEditable(false);
        canva.add(textArea, BorderLayout.CENTER);

        final JPanel orderButton = new JPanel();
        orderButton.setLayout(new FlowLayout());
        final JButton print = new JButton("Print");
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setNextString(textField.getText());
                controller.printCurrentString();
            }

        });
        orderButton.add(print);

        final JButton history = new JButton("Show history");
        history.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                textArea.setText("History " + controller.getHistory().toString());
            }

        });
        orderButton.add(history);
        canva.add(orderButton, BorderLayout.SOUTH);

        frame.add(canva);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Run the application.
     * 
     * @param args are ignored
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
