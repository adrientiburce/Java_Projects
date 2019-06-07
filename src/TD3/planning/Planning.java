package TD3.planning;

import TD3.reseau.Client;
import TD3.reseau.Depot;

import java.util.HashSet;
import java.util.Set;

public class Planning {

    /**
     * on utitlise un set : les tournes sont uniques
     */
    private Set<Tournee> lesTournees;
    private int distanceTotale;
    private int quantiteTotale;
    /**
     * capacites des camions : la meme pour tous
     */
    private static int capacite;

    public Planning(int capacite) {
        this.capacite = capacite;
        this.lesTournees = new HashSet<>();
        this.distanceTotale = 0;
        this.quantiteTotale = 0;
    }

    private boolean ajouterTournee(Tournee t) {
        boolean isAdded = this.lesTournees.add(t);
        if (isAdded) {
            this.distanceTotale += t.getDistance();
            this.quantiteTotale += t.getQuantiteLivre();
        }
        return isAdded;
    }

    @Override
    public String toString() {
        return "Planning{" +
                "nombre de Tournees=" + lesTournees.size() +
                ", distanceTotale=" + distanceTotale +
                ", quantiteTotale=" + quantiteTotale +
                '}';
    }

    public void planificationBasique(Depot depot, Set<Client> clients) {
        Tournee tourneeCourante = new Tournee(depot, capacite);
        for (Client client : clients) {
            // si on ne peut plus ajouter de clients
            boolean isClientAdded = tourneeCourante.ajouterClient(client);
            if (!isClientAdded) {
                // on ajoute la tournee courante au planning
                this.ajouterTournee(tourneeCourante);
                // on crée une nouvelle tournée
                tourneeCourante = new Tournee(depot, capacite);
                tourneeCourante.ajouterClient(client);
            }
            System.out.println("distance tournee : "+ tourneeCourante.getDistance());
        }
        this.ajouterTournee(tourneeCourante);
    }
}
