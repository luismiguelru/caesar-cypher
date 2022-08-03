package cc.codegym.java;

public class Application {
    public static void main(String[] args) {
        CaesarCypher cypher = new CaesarCypher(3);
        String originalMessage = " Java";
        String cypheredMessage = cypher.cypher(originalMessage);
        String finalMessage = cypher.decypher(cypheredMessage);

        String cypheredMessageTwo = cypher.cypherTwo(originalMessage);

        System.out.println(originalMessage);
        System.out.println(cypheredMessage);
        System.out.println(finalMessage);
        System.out.println(originalMessage.equals(finalMessage));
        System.out.println();
        System.out.println(cypheredMessageTwo);


    }

}
