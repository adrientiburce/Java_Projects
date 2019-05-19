package TD1;

public class Technicien extends Personne {

    private String specialite;

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Technicien() {
        super();
        this.specialite = "DEFAULT";
    }

    public Technicien(String specialite) {
        super();
        this.specialite = specialite;
    }

    public Technicien(String firstName, String lastName, String address, String specialite) {
        super(firstName, lastName, address);
        this.specialite = specialite;
    }

    @Override
    public boolean estCompatible(Voiture v) {
        if(v instanceof Camion){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return super.toString() +
                " => Technicien{" +
                "specialite='" + specialite + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Technicien tech = new Technicien();
        System.out.println(tech);

        Voiture v = new Camion();
        System.out.println(tech.estCompatible(v));

    }
}
