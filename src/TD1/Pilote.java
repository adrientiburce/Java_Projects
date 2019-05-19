package TD1;

public class Pilote extends Personne {

    private int numPrix;

    private int numAbandon;

    public int getNumPrix() {
        return numPrix;
    }

    public int getNumAbandon() {
        return numAbandon;
    }

    public Pilote() {
        super();
        initializePriceAndRetire(0, 0);
    }

    public Pilote(int numPrix, int numAbandon) {
        initializePriceAndRetire(numPrix, numAbandon);
    }

    public Pilote(String firstName, String lastName, String address, int numPrix, int numAbandon) {
        super(firstName, lastName, address);
        initializePriceAndRetire(numPrix, numAbandon);
    }

    private void initializePriceAndRetire(int numPrix, int numAbandon) {
        if (numPrix > 0) {
            this.numPrix = numPrix;
        }
        if (numAbandon > 0) {
            this.numAbandon = numAbandon;
        }
    }

    public void gagnerPrix() {
        this.numPrix += 1;
    }

    public boolean retirerPrix() {
        if (numPrix > 0) {
            numPrix -= 1;
            return true;
        }
        return false;
    }

    @Override
    public boolean estCompatible(Voiture v) {
        if(v instanceof Formule1){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() +
                " => Pilot{" +
                "numPrix='" + numPrix + '\'' +
                "numAbandon='" + numAbandon + '\'' +
                '}';
    }


    public static void main(String[] args) {
        Personne hamilton = new Pilote("Lewis", "Hamilton", "London", 10, 0);
        System.out.println(hamilton);

        Voiture v = new Formule1();
        Voiture ferrari = new Formule1();
        Voiture c = new Camion();
        System.out.println("compatible " + hamilton.estCompatible(v));
        System.out.println("Affecter c " + hamilton.affecter(c));

        System.out.println("Affecter v " + hamilton.affecter(v));
        System.out.println("Retirer v " + hamilton.retirerVoiture());

        System.out.println( "Affecter ferrari " + hamilton.affecter(ferrari));

    }
}
