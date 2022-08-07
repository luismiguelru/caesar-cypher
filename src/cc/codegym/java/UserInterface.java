package cc.codegym.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UserInterface implements ActionListener {

    EncryptMode encryptMode = new EncryptMode();
    static JFrame jframe;
    public void start() {
        jframe = new JFrame("Cypher Tool");   //create JFrame object

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(500, 300);         //set size of GUI screen
        jframe.setLayout(null);

        JButton pressButton = new JButton("Encrypt");  //create JButton object
        JButton secondButton = new JButton("Decrypt");

        pressButton.setBounds(100, 10, 100, 30);
        secondButton.setBounds(300, 10, 100, 30);

        jframe.add(pressButton);
        pressButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //show jdialog when button is clicked
                JOptionPane.showMessageDialog(pressButton,"please provide a path");
                selectFile();

            }
        });

        jframe.add(secondButton);
        secondButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String[] choices = { "Decryption with Brute Force", "Decryption with statistic mode"};
                String input = (String) JOptionPane.showInputDialog(null, "Please selection an option",
                        "CryptoTool", JOptionPane.QUESTION_MESSAGE, null,
                        choices,
                        choices[0]);
                System.out.println(input);

            }
        });
        jframe.setLocationRelativeTo(null);

        jframe.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void selectFile() {
        JFileChooser chooser = new JFileChooser();
        // optionally set chooser options ...
        String userHomeFolder = System.getProperty("user.home");

        if (chooser.showOpenDialog(jframe) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            encryptMode.Encryption(f.toString());
            JOptionPane.showMessageDialog(jframe,"Your file is in your " + userHomeFolder);
        } else {
            // user changed their mind
        }
    }
}
