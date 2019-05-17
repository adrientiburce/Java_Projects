package TD1;

import java.security.PublicKey;

public class Moteur {

    private char carburant;
    private int puissance;

    private static final char DIESEL = 'D';
    private static final char ESSENCE = 'E';
    private static final int PUISSANCE_MIN = 600;

    public char getCarburant() {
        return carburant;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        if(puissance > PUISSANCE_MIN){
            this.puissance = puissance;
        }
    }

    // constructeur par défaut
    public Moteur() {
        this.carburant = ESSENCE;
        this.puissance = PUISSANCE_MIN;
    }

    // constructeur par données
    public Moteur(int puissance, char carburant) {
        this();
        if (carburant == DIESEL) {
            this.carburant = carburant;
        }
        if (puissance > PUISSANCE_MIN) {
            this.puissance = puissance;
        }
    }

    // constructeur par copie

    /**
     * constructeur par copie
     * @param m moteur to copy
     */
    public Moteur(Moteur m) {
        this();
        if (m != null) {
            this.carburant = m.carburant;
            this.puissance = m.puissance;
        }
    }

    @Override
    public String toString() {
        return "Moteur{" +
                "carburant='" + carburant + '\'' +
                ", puissance=" + puissance +
                '}';
    }

    public static void main(String[] args) {
        Moteur voitureBanale = new Moteur();
        Moteur ferrari = new Moteur(400, ESSENCE);
        Moteur ferrari2 = new Moteur(ferrari);
        Moteur peugot = new Moteur(1200, Moteur.DIESEL);
        System.out.println(peugot);

        peugot.setPuissance(400);
        // appelle le constructeur par défaut et renvoie une erreur
        // Moteur m6 = new Moteur(null);

        System.out.println("voitureBanale" + voitureBanale);
        System.out.println("Ferrari" + ferrari);
        System.out.println("Copie de Ferrari" + ferrari2);
        System.out.println("Peugor" + peugot);
    }
}
