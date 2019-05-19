package TD1;

import java.util.Arrays;

public class Ecurie {

    private static final int MAX_PERSONNE = 5;

    private static final int MAX_VOITURE = 5;

    private String nom;

    private Personne[] equipe = new Personne[MAX_PERSONNE];

    private Voiture[] flotte = new Voiture[MAX_VOITURE];

    public Ecurie(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int getNumPersonne() {
        return equipe.length;
    }


    public int getNumVoiture() {
        return flotte.length;
    }

    public boolean estPresent(Personne p) {
        for (int i = 0; i < getNumPersonne(); i++) {
            if (equipe[i].getId() == p.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param v la voiture présente ?
     * @return
     */
    public boolean estPresent(Voiture v) {
        for (int i = 0; i < getNumVoiture(); i++) {
            if (flotte[i].getIdPlaque() == v.getIdPlaque()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param p la personne a embauché
     * @return
     */
    public boolean embaucher(Personne p) {
        boolean isEmbaucher = false;
        int i = 0;
        while (!isEmbaucher) {
            if (equipe[i] != null) {
                if (equipe[i].getId() == p.getId()) {
                    return false;
                }
            } else {
                equipe[i] = p;
                isEmbaucher = true;
            }
            i++;
        }
        return isEmbaucher;
    }

    /**
     * permet d'acheter une voiture
     *
     * @param v la voiture
     * @return résultat de l'achat
     */
    public boolean acheter(Voiture v) {
        boolean hasCar = false;
        for (int i = 0; i < flotte.length; i++) {
            if (flotte[i] != null) {
                if (flotte[i].getIdPlaque() == v.getIdPlaque()) {
                    return false;
                }
            } else {
                flotte[i] = v;
                return true;
            }
        }
        return false;
    }

    private Personne localiserPersonne(int id) {
        for (int i = 0; i < getNumPersonne(); i++) {
            if (equipe[i] != null) {
                if (equipe[i].getId() == id) {
                    return equipe[i];
                }
            }
        }
        return null;
    }

    private Voiture localiserVoiture(int idPlaque) {
        for (int i = 0; i < getNumVoiture(); i++) {
            if (flotte[i] != null) {
                if (flotte[i].getIdPlaque() == idPlaque) {
                    return flotte[i];
                }
            }
        }
        return null;
    }

    public boolean affecter(int id, int immat) {
        Personne isDriver = localiserPersonne(id);
        Voiture isCar = localiserVoiture(immat);
        if (isDriver == null) {
            return false;
        }
        if (isCar == null) {
            return false;
        } else {
            isDriver.affecter(isCar);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Ecurie{" +
                "nom='" + nom + '\'' +
                ", equipe=" + Arrays.toString(equipe) +
                ", flotte=" + Arrays.toString(flotte) +
                '}';
    }

    public static void main(String[] args) {
        Ecurie mercedes = new Ecurie("Mercedes");
        System.out.println(mercedes);

        Personne hamilton = new Pilote("Lewis", "Hamilton", "London", 10, 0);
        Personne alonzo = new Pilote("Fernando", "Alonzo", "London", 5, 0);
        System.out.println(mercedes.embaucher(hamilton));
        System.out.println(mercedes.embaucher(alonzo));
        //System.out.println(mercedes.localiserPersonne(0));

        System.out.println("===========");
        Formule1 form = new Formule1();
        Formule1 form1 = new Formule1();
        Formule1 form2 = new Formule1();
        System.out.println(mercedes.acheter(form));
        System.out.println(mercedes.acheter(form1));
        System.out.println(mercedes.acheter(form2));
        //System.out.println(mercedes.acheter(form));

        System.out.println("===========");
        System.out.println(mercedes.affecter(0, 1));
        System.out.println(alonzo.getImmatriculationVoiture());
        System.out.println(hamilton.getImmatriculationVoiture());
    }
}
