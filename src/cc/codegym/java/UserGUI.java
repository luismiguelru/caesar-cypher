package cc.codegym.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Scanner;

public class UserGUI {

    EncryptMode encryptMode;
    Decryption decryption;
    BruteForce bruteForce;
    private static String input;
    static JFrame jframe;

    private static final String PATTERN_NUMBERS = "[0-9]";
    private static JButton encryptDecryptButton;
    private static JButton decryptButton;


    public void start() {

        jframe = new JFrame("Cypher Tool");//create JFrame object

       addQuestionExitButton();

        jframe.setSize(500, 300);         //set size of GUI screen
        jframe.setLayout(null);

        encryptDecryptButton = new JButton("Encrypt & Decrypt with a key");  //create JButton object
        decryptButton = new JButton("Cryptoanalysis");

        encryptDecryptButton.setBounds(50, 20, 199, 70);
        decryptButton.setBounds(300, 20, 160, 70);

        jframe.getContentPane().add(encryptDecryptButton);
        encryptDecryptButtonAction();
        jframe.getContentPane().add(decryptButton);
       decryptButtonAction();
        jframe.setLocationRelativeTo(null);

        jframe.setVisible(true);
        JOptionPane.showMessageDialog(jframe,"Please bear in mind our tool only work with the English Alphabet");


    }

    public void addQuestionExitButton(){
        jframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                int resp = JOptionPane.showConfirmDialog(jframe, "Are you sure you want to exit?",
                        "Exit?", JOptionPane.YES_NO_OPTION);

                if (resp == JOptionPane.YES_OPTION) {
                    jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                } else {
                    jframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }

        });
    }

    public void encryptDecryptButtonAction(){

        jframe.getContentPane().add(encryptDecryptButton);

        encryptDecryptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String encrypt ="Encrypt with a key";
                String decrypt = "Decryption with a key";

                String[] choices = { encrypt,decrypt};
                String option = (String) JOptionPane.showInputDialog(null, "Please selection an option",
                        "CryptoTool", JOptionPane.QUESTION_MESSAGE, null,
                        choices,
                        choices[0]);

                try {

                    if (option.equals(encrypt)) {
                        try {
                            input = JOptionPane.showInputDialog(null, "Please provide a key number",
                                    "CryptoTool", JOptionPane.QUESTION_MESSAGE);

                            while (input.isEmpty() || !(input.matches(PATTERN_NUMBERS))){
                                input = JOptionPane.showInputDialog(null, "Please provide a key number",
                                        "CryptoTool", JOptionPane.QUESTION_MESSAGE);
                                if(input.matches(PATTERN_NUMBERS)) break;
                            }

                        }catch (NumberFormatException numberFormatException){
                            JOptionPane.showConfirmDialog(encryptDecryptButton, "Are you sure to close this tab","Exit?",
                                    JOptionPane.YES_NO_OPTION);

                        }



                        JOptionPane.showMessageDialog(encryptDecryptButton, "Please provide a path");
                        selectFileEncrypt();
                    } else {
                        input = (String) JOptionPane.showInputDialog(null, "Please provide a key number",
                                "CryptoTool", JOptionPane.QUESTION_MESSAGE);

                        if (input.isBlank()){
                            System.out.println("hey");
                        }

                        JOptionPane.showMessageDialog(encryptDecryptButton, "Please provide a path");
                        selectFileDecrypt();
                    } } catch (NullPointerException nullPointerException){
                    JOptionPane.showConfirmDialog(encryptDecryptButton, "Are you sure to close this tab","Exit?",
                            JOptionPane.YES_NO_OPTION);
                }


            }



        });


    }

    public void decryptButtonAction(){
        decryptButton.addActionListener(new ActionListener()
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


                try {
                    if(option.equals(optionFirst)){

                        JOptionPane.showMessageDialog(decryptButton,"Please provide a path");
                        selectFileDecryptBruteForce();

                    } else if (option.equals(optionTwo)) {
                        JOptionPane.showMessageDialog(decryptButton,"Please provide a path");
                        try {
                            selectFileDecryptStatisticMode();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                    } } catch (NullPointerException nullPointerException){
                    JOptionPane.showConfirmDialog(decryptButton, "Are you sure to close this tab","Exit?",
                            JOptionPane.YES_NO_OPTION);



                }


            }
        });
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
        String userHomeFolder = System.getProperty("user.home");

        if (chooser.showOpenDialog(jframe) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            decryption = new Decryption(Integer.parseInt(input));
            decryption.Decryption(f.toString(),Integer.parseInt(input));
            JOptionPane.showMessageDialog(jframe,"Your file is in your " + userHomeFolder);
        } else {

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

        }
    }



}

