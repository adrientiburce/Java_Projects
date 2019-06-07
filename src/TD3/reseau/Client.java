package TD3.reseau;

import TD3.mesExceptions.ErrQuantite;

import java.util.HashSet;
import java.util.Set;

public class Client extends Point {

    private int quantite;

    public Client() {
        super();
        this.quantite = 0;
    }

    public Client(double abscisse, double ordonne, int quantite)throws ErrQuantite {
        super(abscisse, ordonne);
        if (this.quantite >= 0) {
            this.quantite = quantite;
        } else {
            throw new ErrQuantite();
        }
    }

    public int getQuantite() {
        return quantite;
    }

    @Override
    public String toString() {
        return "Client={" +
                super.toString() +
                ", quantite=" + quantite +
                "} ";
    }

    public static void main(String[] args) {
        try {
            Client c1 = new Client(5, 5, 10);
            System.out.println("Creation ok");
            Client c2 = new Client(5, -5, 0); System.out.println("Creation ok");
        } catch (ErrQuantite ex) {
            System.out.println("Erreur: quantité negative");
            System.exit(-1);

        }
    }
}
