package TD2.atelier;

import TD2.Machine;
import TD2.Tache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Atelier {

    private int totalTime;
    private double penaliteTotale;
    private ArrayList<Machine> machines;

    /**
     * Constructeur principale
     *
     * @param numberMachines nombre de machines dans l'atelier
     */
    public Atelier(int numberMachines) {
        if (numberMachines > 0) {
            this.machines = new ArrayList<>(numberMachines);
            for (int i = 0; i < numberMachines; i++) {
                this.machines.add(new Machine());
            }
            this.totalTime = 0;
            this.penaliteTotale = 0;
        } else {
            System.out.println("Nombre de machine insuffisant");
        }
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public double getPenaliteTotale() {
        return penaliteTotale;
    }

    public void setPenaliteTotale(double penaliteTotale) {
        this.penaliteTotale = penaliteTotale;
    }

    public ArrayList<Machine> getMachines() {
        return machines;
    }

    public void setMachines(ArrayList<Machine> machines) {
        this.machines = machines;
    }

    public void miseAJourCriteres() {
        Iterator<Machine> iter = machines.iterator();
        int maxDispo = 0;
        while (iter.hasNext()) {
            Machine elem = iter.next();
            int dispoMachine = elem.getDateDisponibilite();
            if (dispoMachine > maxDispo) maxDispo = dispoMachine;
            this.penaliteTotale += elem.getPenaliteTotale();
        }
        this.totalTime = maxDispo;
    }

    private Machine getMachine(int posMachine) {
        return machines.get(posMachine);
    }

    private boolean addTache(Tache t, int posMachine) {
        Machine machine = getMachine(posMachine);
        return machine.addTache(t);
    }

    /**
     * @return index de la premiere machine libre
     */
    private int getPremiereMachineLibre() {
        int minDispo = Integer.MAX_VALUE;
        int indexMachineLibre = 0;
        int i = 0;
        for (Machine elem : machines) {
            int mDispo = elem.getDateDisponibilite();
            if (mDispo < minDispo) {
                minDispo = mDispo;
                indexMachineLibre = i;
            }
            i++;
        }
        return indexMachineLibre;
    }

    /**
     * @param taches listes de toutes les taches
     */
    public void ordonnancerTaches(List<Tache> taches) {
        for (Tache tache : taches) {
            this.addTache(tache, this.getPremiereMachineLibre());
        }
        miseAJourCriteres();
    }

    @Override
    public String toString() {
        return "Atelier{" +
                "totalTime=" + totalTime +
                ", penaliteTotale=" + penaliteTotale +
                ", machines=" + machines +
                '}';
    }

    public static void main(String[] args) {
        Tache t1 = new Tache(150, 300, 2.5);
        Tache t2 = new Tache(140, 400, 1.5);
        Tache t3 = new Tache(50, 200, 2.5);
        Tache t4 = new Tache(85, 200, 1.0);
        Tache t5 = new Tache(75, 160, 0.5);
        Tache t6 = new Tache(80, 500, 1.5);

        LinkedList<Tache> mesTaches = new LinkedList<>();
        mesTaches.add(t1);
        mesTaches.add(t2);
        mesTaches.add(t3);
        mesTaches.add(t4);
        mesTaches.add(t5);
        mesTaches.add(t6);

        Atelier atelier = new Atelier(2);
        atelier.ordonnancerTaches(mesTaches);
        System.out.println("==========");
        System.out.println(atelier);
    }
}
