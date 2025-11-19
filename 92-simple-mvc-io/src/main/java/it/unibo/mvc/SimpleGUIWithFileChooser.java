package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "My first java graphical interface";
    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame(TITLE);
    private final Controller control = new Controller();

    /**
     * Creates a SimpleGUIWithFileChooser.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        //Text area
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        // Button save
        final JButton buttonSave = new JButton("Save");
        buttonSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent event) {
                try {
                    // We want to save what's in the text area
                    control.writeTheString(textArea.getText());
                } catch (final IOException e) {
                    JOptionPane.showMessageDialog(
                        frame, // On the centre of the frame
                        "There's a problem when it comes to save what you've done ",
                        e.getMessage(),
                        JOptionPane.ERROR_MESSAGE
                        );
                }
            }
        });
        canvas.add(buttonSave, BorderLayout.SOUTH);

        // Text field and button of the upper part
        final JPanel upperCanva = new JPanel();
        upperCanva.setLayout(new BorderLayout());

        final JTextField upperTextField = new JTextField(control.getPath());
        // We do not use setEnabled(false); because the text field
        // will appear different than the given one
        upperTextField.setEditable(false);
        upperCanva.add(upperTextField, BorderLayout.CENTER);

        // Button Browse
        final JButton buttonBrowse = new JButton("Browse...");
        buttonBrowse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                final int result = chooser.showSaveDialog(null);

                switch (result) {
                    case JFileChooser.APPROVE_OPTION:
                        final File selectedFile = chooser.getSelectedFile();
                        control.setFile(selectedFile);
                        upperTextField.setText(control.getPath());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        // The program should do nothing
                        break;
                    default:
                        JOptionPane.showMessageDialog(
                            null,
                            "An error has occurred in your selection "
                            );
                }
            }
        });
        upperCanva.add(buttonBrowse, BorderLayout.EAST);

        canvas.add(upperCanva, BorderLayout.NORTH);

        frame.setContentPane(canvas);
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
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String... args) {
       new SimpleGUIWithFileChooser().display();
    }

}
