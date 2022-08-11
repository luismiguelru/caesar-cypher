package cc.codegym.java;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CaesarCypherIO {
    private final int cypherKey;
    //Regex Alphabetic Character
    private static final String PATTERN = "^[.,!¡¿?-a-zA-Z]*$";
    //RegexDoubleQuotationMarks
    private static final String PATTERNTWO = "[^\"]*\"|\\w*";
    //RegexWhitespace
    private static final String PATTERNTHREE = "\\p{Zs}";

    public CaesarCypherIO(int cypherKey) {
        this.cypherKey = cypherKey;
    }

    public String cypher (String text, int cypherKey){
        StringBuilder cypheredMessage = new StringBuilder();
        String copy = text;
        char[] copyChar =  copy.toCharArray();
        Character[] charArrBoxed = new String(copyChar).chars()
                .mapToObj(c ->(char)c)
                .toArray(Character[]::new);


        for (int i = 0; i < charArrBoxed.length ; i++){
            if ( charArrBoxed[i].toString().matches(PATTERN) || charArrBoxed[i].toString().matches(PATTERNTWO)
                    || charArrBoxed[i].toString().matches(PATTERNTHREE))
            {
                char ca = (char)(text.charAt(i)+ cypherKey);
                cypheredMessage.append(ca);
            }

        }

        return cypheredMessage.toString();
    }
    public String decypher (String text, int cypherKey){
        StringBuilder cypheredMessage = new StringBuilder();
        String copy = text;
        char[] copyChar =  copy.toCharArray();
        Character[] charArrBoxed = new String(copyChar).chars()
                .mapToObj(c ->(char)c)
                .toArray(Character[]::new);


        for (int i = 0; i < charArrBoxed.length ; i++){
                char ca = (char)(text.charAt(i) - cypherKey);
                cypheredMessage.append(ca);
        }

        return cypheredMessage.toString();
    }



}
