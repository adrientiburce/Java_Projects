package TD1;

public class Voiture {

    private static int NUM_VOITURE = 0;

    private int IdPlaque;
    private String marque;
    private Moteur moteur;

    private Personne driver = null;

    public int getIdPlaque() {
        return IdPlaque;
    }

    public String getMarque() {
        return marque;
    }

    public Moteur getCopieMoteur() {
        // problématique car on retourne l'adresse mémoire du motuer -> changement motuer
        //return moteur;
        return new Moteur(moteur);
    }

    public void setMoteur(Moteur moteur) {
        if( moteur != null ){
            this.moteur = moteur;
        }
    }

    public Personne getDriver() {
        return driver;
    }

    /**
     * constructeur par défaut : gestion de l'immatriculation unique
     */
    public Voiture() {
        this.IdPlaque = NUM_VOITURE;
        this.marque = "DEFAULT";
        this.driver = null;
        NUM_VOITURE++;
    }

    public Voiture(String marque) {
        this();
        if (marque != null) {
            this.marque = marque;
        }
    }

    public Voiture(String marque, int puissance, char carburant) {
        // this();
        // this.marque = marque;
        this(marque); // appel du constructeur par marque
        this.moteur = new Moteur(puissance, carburant);
    }

    public Voiture(String marque, Moteur moteur) {
        this(marque);
        this.moteur = new Moteur(moteur);
    }

    public Voiture(Voiture v) {
        this.moteur  = v.moteur;
        this.marque = v.marque;
    }

    public boolean setConducteur(Personne p) {
        if(p == null){
            return false;
        }
        if(!this.estDisponible()){
            return false;
        }
        if(p.getImmatriculationVoiture() != this.IdPlaque){
            return false;
        }
        this.driver = p;
        return true;
    }

    public boolean estDisponible(){
        return (this.driver == null);
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "IdPlaque=" + IdPlaque +
                ", marque='" + marque + '\'' +
                ", moteur=" + moteur +
                ", driver=" + driver +
                '}';
    }

    public static void main(String[] args) {
        Moteur m1 = new Moteur(null);
        Moteur m2 = new Moteur(1000, 'E');
        Voiture v1 = new Voiture(null, m1);
        Voiture v2 = new Voiture("Ferrari", m2);
        Voiture v3 = new Voiture("Ferrari", m2);
        System.out.println("v1 : " + v1);
        System.out.println("v2 : " + v2);
        System.out.println("v3 : " + v3);
        m2.setPuissance(1200);
        System.out.println("v2 : " + v2);
        System.out.println("v3 : " + v3);
    }
}
