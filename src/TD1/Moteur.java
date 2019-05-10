package TD1;

public class Moteur {

    private char carburant;
    private int puissance;

    private static final char DIESEL = 'D';
    private static final char ESSENCE = 'E';
    private static final int PUISSANCE_MIN = 600;

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
        if (puissance < PUISSANCE_MIN) {
            this.carburant = carburant;
        }
    }

    // constructeur par copie
    public Moteur(Moteur premierMoteur) {
        this.carburant = premierMoteur.carburant;
        this.puissance = premierMoteur.puissance;
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

        // appelle le constructeur par défaut et renvoie une erreur
        // Moteur m6 = new Moteur(null);

        System.out.println(voitureBanale);
        System.out.println(ferrari);
        System.out.println(ferrari2);
        System.out.println(peugot);
    }
}
