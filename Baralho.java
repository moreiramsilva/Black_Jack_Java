
import java.util.Random;

public class Baralho {

    private Cartas[] deck;
    private int contador;
    private static final int NUMERODECARTAS = 52;//Total de Cartas
    private static final Random rand = new Random();

    public Baralho() {
        String[] faces = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"}; //Faces das Cartas
        deck = new Cartas[NUMERODECARTAS];//Tamanho do Baralho
        contador = 0;

        for (int i = 0; i < deck.length; i++) { //Nomear as cartas
            deck[i] = new Cartas(faces[i % 13]);
        }

    }//fim constructor

    public void shuffle() {//Embaralhando
        contador = 0;

        for (int i = 0; i < deck.length; i++) {
            int random = rand.nextInt(NUMERODECARTAS);
            Cartas t = deck[i];
            deck[i] = deck[random];
            deck[random] = t;
        }
    }

    public String dealCard() {

        if (contador < deck.length) {
            return deck[contador++].toString();
        } else {
            return null;
        }
    }

}//fim Class Baralho
