package TD1;

public abstract class Personne {

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

    public int getId() {
        return Id;
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

    private void setAddress(String address) {
        if (address != null) {
            this.address = address;
        }
    }

    public boolean estPieton() {
        return (this.voiture == null);
    }

    /**
     * @param v la voiture a conduire
     * @return affectation ou non de la voiture en fonction de la personne (pieton et fonction) et de la dispo
     */
    public boolean affecter(Voiture v) {
        if (v != null && this.estPieton() && v.estDisponible() && this.estCompatible(v)) {
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

    /**
     * @return si la personne peut conduire la voiture
     */
    abstract public boolean estCompatible(Voiture v);

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

}
