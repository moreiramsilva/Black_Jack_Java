
import java.util.ArrayList;

public class RegrasBJ {

    private boolean estourou = false;
    private int TotaldeCartas = 0;

    private ArrayList<String> Cartas;
    private ArrayList<String> As;

    public RegrasBJ(String c1, String c2) {
        TotaldeCartas = 0;
        Cartas = new ArrayList();
        As = new ArrayList();

        if (c1 == "As") {
            As.add(c1);
        } else {
            Cartas.add(c1);
        }

        if (c2 == "As") {
            As.add(c2);
        } else {
            Cartas.add(c2);
        }

        SetTotal();

    }//Fim do construtor

    public int GetCardTotal() {
        return TotaldeCartas;
    }

    public void setCardTotal() {
        TotaldeCartas = 0;
    }

    public void CardHit(String ca) {

        if (ca == "As") {
            As.add("As");
        } else {
            Cartas.add(ca);
        }

        if (As.size() != 0) {
            SetTotal();
        } else if (ca == "Jack" || ca == "Queen" || ca == "King") {

            TotaldeCartas += 10;
        } else {
            TotaldeCartas += Integer.parseInt(ca);
        }

        CheckBust();

    }

    private void SetTotal() {

        TotaldeCartas = 0;
        for (String c : Cartas) {
            if (c == "Jack" || c == "Queen" || c == "King") {
                TotaldeCartas += 10;
            } else {
                TotaldeCartas += Integer.parseInt(c);
            }

        }

        for (String a : As) {

            TotaldeCartas += 1;

        }
    }//fim ace total

    public boolean CheckBust() {
        if (TotaldeCartas > 21) {
            estourou = true;
        } else {
            estourou = false;
        }

        return estourou;
    }

}
