package TD1;

abstract class Voiture {

    private static int numVoiture = 0;

    protected int IdPlaque;
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
        this.IdPlaque = numVoiture;
        this.marque = "DEFAULT";
        this.driver = null;
        numVoiture++;
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

    }
}
