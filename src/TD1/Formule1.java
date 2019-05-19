package TD1;

public class Formule1 extends Voiture {

    private String sponsor;

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        if (sponsor != null) {
            this.sponsor = sponsor;
        }
    }

    public Formule1() {
        super();
        this.sponsor = "DEFAULT";
    }

    /**
     * constructeur par sponsor
     *
     * @param sponsor
     */
    public Formule1(String sponsor) {
        super();
        initializeSponsor(sponsor);
    }

    private void initializeSponsor(String sponsor) {
        if (sponsor == null) {
            this.sponsor = "?";
        } else {
            this.sponsor = sponsor;
        }
    }

    public Formule1(String marque, Moteur moteur, String sponsor){
        super(marque, moteur);
        initializeSponsor(sponsor);
    }
    /**
     * constructeur avec ts les paramètres
     *
     * @param marque
     * @param puissance
     * @param carburant
     * @param sponsor
     */
    public Formule1(String marque, int puissance, char carburant, String sponsor) {
        super(marque, puissance, carburant);
        initializeSponsor(sponsor);
    }

    @Override
    public String toString() {
        String S = super.toString();
        return S +
                "=> Formule1 {" +
                ", sponsor='" + sponsor + '\'' +
                '}';
    }


    public static void main(String[] args) {
        Moteur m2 = new Moteur(8000, 'E');
        Voiture v2 = new Formule1("Ferrari", m2, "RedBull");

        Formule1 ferrari = new Formule1("Coca");

        System.out.println("pas de moteur : " + ferrari);
        System.out.println("ma Ferrari : " + v2);
    }
}
