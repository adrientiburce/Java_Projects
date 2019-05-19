package TD1;

public class Camion extends Voiture {

    private int tonnage = 500;

    public int getTonnage() {
        return tonnage;
    }

    public Camion() {
        super();
        initializeTonnage(0);
    }

    public Camion(int tonnage) {
        initializeTonnage(0);
    }

    private void initializeTonnage(int tonnage) {
        if (tonnage >= 0) {
            this.tonnage = tonnage;
        } else {
            this.tonnage = 0;
        }
    }

    public Camion(Voiture v, int tonnage) {
        super(v);
        initializeTonnage(tonnage);
    }

    public Camion(String marque, int puissance, char carburant, int tonnage) {
        super(marque, puissance, carburant);
        initializeTonnage(tonnage);
    }

    @Override
    public String toString() {
        String S = super.toString();
        return S +
                "=> Camion{" +
                "tonnage=" + this.tonnage +
                '}';
    }

    public static void main(String[] args) {
        /*Voiture v1 = new Voiture();
        Moteur m2 = new Moteur(1000, 'E');

        Voiture v2 = new Voiture("Renault", m2);

        Camion cam1 = new Camion(v1, 300);
        Camion cam2 = new Camion(v2, 200);

        System.out.println(cam1);
        System.out.println(cam2);*/
    }
}
