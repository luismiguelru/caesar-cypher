package cc.codegym.java;

import java.io.*;
import java.util.HashSet;

public class BruteForce {

    public void caesar_cipher_brute_force_attack(String message)
    {

        /*
          Here we will try all possible keys in the range [1-255]
          and if there are some special symbols other than some commonly used symbols
          in a conversation.
         */
        HashSet<Character> special_symbols=new HashSet<Character>();
        special_symbols.add('<');  special_symbols.add('>'); special_symbols.add('?');
        special_symbols.add('/');  special_symbols.add(':'); special_symbols.add(';');
        special_symbols.add('[');  special_symbols.add('{'); special_symbols.add(']');
        special_symbols.add('\"');  special_symbols.add('\''); special_symbols.add(';');
        special_symbols.add('}');  special_symbols.add('|'); special_symbols.add('\\');
        special_symbols.add('+');  special_symbols.add('='); special_symbols.add('-');
        special_symbols.add('_');  special_symbols.add(')'); special_symbols.add('(');
        special_symbols.add('!');  special_symbols.add('@'); special_symbols.add('#');
        special_symbols.add('$');  special_symbols.add('%'); special_symbols.add('^');
        special_symbols.add('&');  special_symbols.add('*'); special_symbols.add('~');
        special_symbols.add('`');  special_symbols.add(' ');

        try {

            File f = new File(message);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String userHomeFolder = System.getProperty("user.home");
            File textFile = new File(userHomeFolder, "decypheredBruteForce.txt");
            FileWriter fw = new FileWriter(textFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);

            for (String line; (line = b.readLine()) != null; ) {
                for(int key=1;key<=255;key++)
                {
                    String out="";
                    int n=line.length();
                    boolean print=true;
                    for(int i=0;i<n;i++)
                    {
                        int val=line.charAt(i)-key;
                        if(val<0)
                            val=256+val;
                        char ch=(char) (val%256);

                if((ch>=97 && ch<=122) || (ch>=65 && ch<=90) ||(ch>=48 && ch<=57)|| special_symbols.contains(ch))
                    out+=ch;
                else
                {
                    print=false;
                    break;
                }

            }
            if(print == true)
            {
                bufferedWriter.write(key + " " + out);
                bufferedWriter.newLine();
            }

        }

            }


            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }


    }


}

