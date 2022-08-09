package cc.codegym.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class UserInterface implements ActionListener {

    EncryptMode encryptMode;
    Decryption decryption;
    BruteForce bruteForce;
    private static String input;
    static JFrame jframe;

    public void start() {

        jframe = new JFrame("Cypher Tool");//create JFrame object
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(500, 300);         //set size of GUI screen
        jframe.setLayout(null);

        JButton encryptDecryptButton = new JButton("Encrypt & Decrypt with a key");  //create JButton object
        JButton secondButton = new JButton("Cryptoanalysis");

        encryptDecryptButton.setBounds(50, 20, 199, 70);
        secondButton.setBounds(300, 20, 160, 70);

        jframe.getContentPane().add(encryptDecryptButton);
        encryptDecryptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //show jdialog when button is clicked
                String encrypt ="Encrypt with a key";
                String decrypt = "Decryption with a key";



                String[] choices = { encrypt,decrypt};
                String option = (String) JOptionPane.showInputDialog(null, "Please selection an option",
                        "CryptoTool", JOptionPane.QUESTION_MESSAGE, null,
                        choices,
                        choices[0]);

                    try {

                   if (option.equals(encrypt)) {
                       input = (String) JOptionPane.showInputDialog(null, "Please provide a key number",
                               "CryptoTool", JOptionPane.QUESTION_MESSAGE);

                       JOptionPane.showMessageDialog(encryptDecryptButton, "Please provide a path");
                       selectFileEncrypt();
                   } else {
                       input = (String) JOptionPane.showInputDialog(null, "Please provide a key number",
                               "CryptoTool", JOptionPane.QUESTION_MESSAGE);

                       JOptionPane.showMessageDialog(encryptDecryptButton, "Please provide a path");
                       selectFileDecrypt();
                   } } catch (NullPointerException nullPointerException){
                        JOptionPane.showConfirmDialog(encryptDecryptButton, "Are you sure to close this tab");
                    }


                }



        });


        jframe.getContentPane().add(secondButton);
        secondButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String optionFirst="Decryption with Brute Force";
                String optionTwo="Decryption with statistic mode";
                String[] choices = { optionFirst,optionTwo};
                String option = (String) JOptionPane.showInputDialog(null, "Please selection an option",
                        "CryptoTool", JOptionPane.QUESTION_MESSAGE, null,
                        choices,
                        choices[0]);



                if(option.equals(optionFirst)){

                    JOptionPane.showMessageDialog(secondButton,"Please provide a path");
                    selectFileDecryptBruteForce();

                } else if (option.equals(optionTwo)) {
                    JOptionPane.showMessageDialog(secondButton,"Please provide a path");
                    try {
                        selectFileDecryptStatisticMode();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }


            }
        });
        jframe.setLocationRelativeTo(null);

        jframe.setVisible(true);




    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void selectFileEncrypt() {
        JFileChooser chooser = new JFileChooser();

        String userHomeFolder = System.getProperty("user.home");

        if (chooser.showOpenDialog(jframe) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            encryptMode = new EncryptMode(Integer.parseInt(input));
            encryptMode.Encryption(f.toString(),Integer.parseInt(input));
            JOptionPane.showMessageDialog(jframe,"Your file is in your " + userHomeFolder);
        } else {

        }
    }

    public void selectFileDecrypt() {
        JFileChooser chooser = new JFileChooser();
        // optionally set chooser options ...
        String userHomeFolder = System.getProperty("user.home");

        if (chooser.showOpenDialog(jframe) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            decryption = new Decryption(Integer.parseInt(input));
            decryption.Decryption(f.toString(),Integer.parseInt(input));
            JOptionPane.showMessageDialog(jframe,"Your file is in your " + userHomeFolder);
        } else {
            // user changed their mind
        }
    }

    public void selectFileDecryptBruteForce() {
        JFileChooser chooser = new JFileChooser();
        String userHomeFolder = System.getProperty("user.home");

        if (chooser.showOpenDialog(jframe) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            bruteForce = new BruteForce();
           bruteForce.caesar_cipher_brute_force_attack(f.toString());
            JOptionPane.showMessageDialog(jframe,"Your file is in your " + userHomeFolder);
        } else {
            // user changed their mind
        }
    }

    public void selectFileDecryptStatisticMode() throws IOException {
        JFileChooser chooser = new JFileChooser();
        String userHomeFolder = System.getProperty("user.home");
        CaesarCypherStatisticMode statisticMode = new CaesarCypherStatisticMode();
        int key=0;

        if (chooser.showOpenDialog(jframe) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();

            File file = new File(f.toURI());
            BufferedReader b = new BufferedReader(new FileReader(file));
            File textFile = new File(userHomeFolder, "decypheredStatisticMode.txt");
            FileWriter fw = new FileWriter(textFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);

            for (String line; (line = b.readLine()) != null; ) {
                key = statisticMode.breakCipher(line);
                CaesarCypherIO cypherIO = new CaesarCypherIO(key);
                bufferedWriter.write(cypherIO.decypher(line,key));
                bufferedWriter.newLine();

            }
            bufferedWriter.close();

            JOptionPane.showMessageDialog(jframe,"Your file is in your " + userHomeFolder);
        } else {
            JOptionPane.showConfirmDialog(jframe,"Are you sure?");
        }
    }
}

