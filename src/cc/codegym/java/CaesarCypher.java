package cc.codegym.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaesarCypher {

    private final int cypherKey;
    //Regex Alphabetic Character
    private static final String PATTERN = "^[.,!¡¿?-a-zA-Z]*$";
    //RegexDoubleQuotationMarks
    private static final String PATTERNTWO = "[^\"]*\"|\\w*";
    //RegexWhitespace
    private static final String PATTERNTHREE = "\\p{Zs}";




    public CaesarCypher(int cypherKey) {
        this.cypherKey = cypherKey;
    }

    public   String cypher(String text){


        StringBuilder cypheredMessage = new StringBuilder();
        for (int i =0 ; i < text.length() ; i++){
            char c = (char)(text.charAt(i)+ cypherKey);

            cypheredMessage.append(c);
        }

        return cypheredMessage.toString();
    }
    public   String decypher(String text){
        StringBuilder cypheredMessage = new StringBuilder();
        for (int i =0 ; i < text.length() ; i++){
            char c = (char)(text.charAt(i) - cypherKey);
            cypheredMessage.append(c);
        }

        return cypheredMessage.toString();
    }

    public String cypherTwo (String text){
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
}
