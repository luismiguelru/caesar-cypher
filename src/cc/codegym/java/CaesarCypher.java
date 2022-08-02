package cc.codegym.java;

public class CaesarCypher {

    private final int cypherKey;

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
}
