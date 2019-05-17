package TD1;

public class Personne {

    private static int lastId = 0;
    private int Id;
    private String firstName;
    private String lastName;
    private String address;

    /**
     * La voiture de la personne, par défaut null
     */
    private Voiture voiture = null;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null) {
            this.address = address;
        }
    }

    public Voiture getVoiture() {
        return new Voiture(voiture);
    }

    /**
     * constructeur par défaut
     */
    public Personne() {
        this.Id = lastId;
        this.firstName = "John";
        this.lastName = "Doe";
        this.address = "SomeWhere";
        lastId++;
    }

    /**
     * @param firstName
     * @param lastName
     * @param address
     */
    public Personne(String firstName, String lastName, String address) {
        this();
        setName(firstName);
        setLastName(lastName);
        setAddress(address);
    }

    private void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    private void setName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    public boolean estPieton() {
        return (this.voiture == null);
    }

    /**
     * @param v la voiture a conduire
     * @return affectation ou non de la voiture
     */
    public boolean affecter(Voiture v) {
        if (v != null && this.estPieton() && v.estDisponible()) {
            this.voiture = v;
            v.setConducteur(this);
            return true;
        }
        return false;
    }

    /**
     * Restituer une voiture
     */
    public boolean retirerVoiture() {
        if (!this.estPieton()) {
            this.voiture = null;
            return true;
        }
        return false;
    }

    public int getImmatriculationVoiture(){
        if(this.voiture != null){
            return voiture.getIdPlaque();
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", voiture=" + voiture +
                '}';
    }

    public static void main(String[] args) {
        Personne p1 = new Personne("Adrien", "Tiburce", "22 rue des cotes");
        Voiture vNull = null;
        Voiture v1 = new Voiture();
        Voiture v2 = new Voiture();
        System.out.println(p1.estPieton());
        System.out.printf("=========\n");
        System.out.println(v1);
        System.out.println(p1.affecter(v1));
        System.out.println(p1.retirerVoiture());
        System.out.println(p1.affecter(v2));

    }
}
