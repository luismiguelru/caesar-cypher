package cc.codegym.java;

import java.io.*;

public class Decryption {

    CaesarCypherIO cypher = new CaesarCypherIO(3);

    public void Decryption (String text) {


        try {

            File f = new File(text);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String userHomeFolder = System.getProperty("user.home");
            File textFile = new File(userHomeFolder, "decyphered.txt");
            FileWriter fw = new FileWriter(textFile);

            for (String line; (line = b.readLine()) != null; ) {
                line = cypher.decypher(line);
                fw.write(line);

            }
            fw.flush();
            fw.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
