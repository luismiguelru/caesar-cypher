package cc.codegym.java;

import java.io.*;

public class EncryptMode extends CaesarCypherIO{

    private int cypherkey;
    public EncryptMode(int cypherKey) {
        super(cypherKey);
        cypherkey = cypherKey;
    }

    CaesarCypherIO cypher = new CaesarCypherIO(cypherkey);

    public void Encryption (String text, int cypherkey) {


        try {

            File f = new File(text);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String userHomeFolder = System.getProperty("user.home");
            File textFile = new File(userHomeFolder, "cyphered.txt");
            FileWriter fw = new FileWriter(textFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);

            for (String line; (line = b.readLine()) != null; ) {
                line = cypher.cypher(line, cypherkey);
               // fw.write(line);
                bufferedWriter.write(line);
                bufferedWriter.newLine();


            }
            //fw.flush();
           // fw.close();
            bufferedWriter.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
