package TD2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Machine {

    private List<Tache> taches;
    private int dateDisponibilite;
    private double penaliteTotale;

    public Machine() {
        this.dateDisponibilite = 0;
        this.penaliteTotale = 0;
        this.taches = new LinkedList<>();
    }

    public int getDateDisponibilite() {
        return dateDisponibilite;
    }

    public double getPenaliteTotale() {
        return penaliteTotale;
    }

    public boolean addTache(Tache t){
        if(t != null && !(t.isAffected())){
            this.taches.add(t);
            // update properties
            t.setDateDebut(this.dateDisponibilite);
            this.dateDisponibilite = t.getDatefin();
            this.penaliteTotale += t.getCoutPenalite();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "taches=" + taches +
                ", dateDisponibilite=" + dateDisponibilite +
                ", penaliteTotale=" + penaliteTotale +
                '}';
    }

    public static void main(String[] args) {
        Tache t1 = new Tache(150, 300, 2.5);
        Tache t2 = new Tache(140, 400, 1.5);
        Tache t3 = new Tache(50, 200, 2.5);
        Tache t4 = new Tache(85, 200, 1.0);
        Tache t5 = new Tache(75, 160, 0.5);
        Tache t6 = new Tache(80, 500, 1.5);

        Machine machine = new Machine();
        System.out.println(machine);

        System.out.println(machine.addTache(t1));
        System.out.println(machine.addTache(t2));
        System.out.println(machine.addTache(t3));
        System.out.println(machine.addTache(t4));
        System.out.println(machine.addTache(t5));
        System.out.println(machine.addTache(t6));

        System.out.println("==========");
        System.out.println(machine);

        // Tache 5 : dateDebut=500,
    }
}
