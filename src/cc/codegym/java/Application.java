package cc.codegym.java;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //CaesarCypherIO cypher = new CaesarCypherIO(3);
        //EncryptMode encryptMode = new EncryptMode();
        //Decryption decryption = new Decryption();
        BruteForce bruteForce = new BruteForce();

        UserInterface userInterface = new UserInterface();
        userInterface.start();


       //bruteForce.caesar_cipher_brute_force_attack("C:\\Users\\Usuario\\test.txt");

     //  String operation;

       // operation = JOptionPane.showInputDialog("What you would like to do, Encrypt or decryption, type E or D ");

//Code to show up the dialog boxes

        /* if (operation.equalsIgnoreCase("e")){
            String input = JOptionPane.showInputDialog("Please provide a path ");
            String data  = input;
            String inputKey = JOptionPane.showInputDialog("Please provide a key ");
            int key = Integer.parseInt(inputKey);
            CaesarCypherIO cypher = new CaesarCypherIO(key);
            encryptMode.Encryption(data);
            JOptionPane.showMessageDialog(null, "The cyphered code is within your Destopk");
        } else if (operation.equalsIgnoreCase("d")) {
            String input = JOptionPane.showInputDialog("Please provide a path ");
            String data  = input;
            String inputKey = JOptionPane.showInputDialog("Please provide a key ");
            int key = Integer.parseInt(inputKey);
            CaesarCypherIO cypher = new CaesarCypherIO(key);
            decryption.Decryption(data);
            JOptionPane.showMessageDialog(null, "The decyphered code is within your Destopk");
        }*/



       // String originalMessage = " Java";
       // String cypheredMessage = cypher.cypher(originalMessage);
       // String finalMessage = cypher.decypher(cypheredMessage);

       // String cypheredMessageTwo = cypher.cypherTwo(originalMessage);

      /*  System.out.println(originalMessage);
        System.out.println(cypheredMessage);
        System.out.println(finalMessage);
        System.out.println(originalMessage.equals(finalMessage));
        System.out.println();
        System.out.println(cypheredMessageTwo);*/

     /*   Scanner scanner = new Scanner(System.in);
        System.out.println("You would like to encrypt or decrypt, select E for Encrypt or D for decrypt");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("e")){
            System.out.println("Please enter a path");
            String data  = scanner.nextLine();
            encryptMode.Encryption(data);
        } else if (response.equalsIgnoreCase("d")) {
            System.out.println("Please enter a path");
            String data  = scanner.nextLine();
            decryption.Decryption(data);
        }*/




    }



}


