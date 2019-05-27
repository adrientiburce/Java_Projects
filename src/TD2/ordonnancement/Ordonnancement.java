package TD2.ordonnancement;

import TD2.Tache;
import TD2.atelier.Atelier;

import java.util.List;

public class Ordonnancement {

    private List<Tache> ensTaches;
    private int nmbMachines;
    private Atelier atelier;

    public Ordonnancement(List<Tache> ensTaches, int nmbMachines) {
        this.ensTaches = ensTaches;
        this.nmbMachines = nmbMachines;
    }


    private void resetAtelier(){
        this.atelier = new Atelier(this.nmbMachines);
    }
}
