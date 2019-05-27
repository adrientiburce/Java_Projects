package TD2;

/**
 * The type Tache.
 */
public class Tache {

    private static int lastId;
    private int id;
    private int duree;
    private int dateLimite = 0;
    private double penalite;
    // a definir par nous
    private int dateDebut;

    private static final int DATE_INITIAL = 0;
    private static final int DUREE_MIN = 50;


    /**
     * Instantiates a new Tache.
     */
    public Tache() {
        setId();
        this.duree = DUREE_MIN;
        this.dateDebut = DATE_INITIAL - 1;
        this.dateLimite = Integer.MAX_VALUE;
        this.penalite = 0;
    }

    /**
     * Instantiates a new Tache.
     *
     * @param duree the duree
     */
    public Tache(int duree) {
        this();
        setDuree(duree);
    }

    /**
     * Instantiates a new Tache.
     *
     * @param dure       the dure
     * @param dateLimite the date limite
     * @param penalite   the penalite
     */
    public Tache(int dure, int dateLimite, double penalite) {
        this(dure);
        setDateLimite(dateLimite);
        setPenalite(penalite);
    }

    public int getDuree() {
        return duree;
    }

    public int getDateDebut() {
        return dateDebut;
    }

    public int getDateLimite() {
        return dateLimite;
    }

    public double getPenalite() {
        return penalite;
    }

    private void setId() {
        this.id = lastId;
        lastId++;
    }

    public void setDateDebut(int dateDebut) {
        if (dateDebut >= DATE_INITIAL && !this.isAffected()) {
            this.dateDebut = dateDebut;
        }
    }

    private void setDuree(int duree) {
        if (duree > DUREE_MIN) {
            this.duree = duree;
        }
    }

    private void setDateLimite(int dateLimite) {
        if (dateLimite > 2 * this.duree) {
            this.dateLimite = dateLimite;
        }
    }

    private void setPenalite(double penalite) {
        if (penalite > 0) {
            this.penalite = penalite;
        }
    }

    public boolean isAffected() {
        return (this.dateDebut > -1);
    }

    public int getDatefin() {
        return this.dateDebut + this.duree;
    }

    public double getCoutPenalite() {
        if (!this.isAffected()) return 0;
        int retard = Math.max(this.getDatefin() - this.dateLimite, 0);
        return retard * this.penalite;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "id=" + id +
                ", duree=" + duree +
                ", dateDebut=" + dateDebut +
                ", dateLimite=" + dateLimite +
                ", penalite=" + penalite +
                '}';
    }

    public static void main(String[] args) {
        Tache tache = new Tache();
        Tache tache3 = new Tache(60, 120, 20);

        Tache tacheFalse = new Tache(10);
        System.out.println(tache);
        System.out.println("temps trop court : " + tacheFalse);
        System.out.println("Tache 3 : " + tache3);
    }
}
