package TD3.planning;

import TD3.reseau.Client;
import TD3.reseau.Depot;
import TD3.reseau.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Tournee {

    private Depot depot;
    private int quantiteLivre;
    private double distance;
    private int capaciteMax;

    /**
     * ArrayList pour accéder facilement aux clients
     */
    private ArrayList<Client> mesClients = new ArrayList<>();

    public Tournee(Depot depot, int capacite) {
        this.depot = depot;
        this.capaciteMax = capacite;
        this.quantiteLivre = 0;
    }

    public Depot getDepot() {
        return depot;
    }

    public int getQuantiteLivre() {
        return quantiteLivre;
    }

    public double getDistance() {
        return distance;
    }

    /**
     * ajoute un client a la tourné en mettant a jour la quantité livré et la distance
     *
     * @param client
     * @return boolean : si le client peur etre ajoute
     */
    public boolean ajouterClient(Client client) {
        System.out.println(client);
        int isNewQuantiteLivre = this.quantiteLivre + client.getQuantite();
        if (this.capaciteMax < isNewQuantiteLivre) {
            return false;
        } else {
            this.quantiteLivre = isNewQuantiteLivre;
            this.mesClients.add(client);
            // maj de la distance
            // un seul client
            if (mesClients.size() == 1) {
                this.distance = 2 * client.getDistance(depot);
            } else {
                this.distance -= this.mesClients.get(mesClients.size() - 2).getDistance(depot);
                this.distance += client.getDistance(depot);
            }

        }
        return true;
    }

    public boolean ajouterClient(Set<Client> ensembleClient) {
        for (Client client : ensembleClient) {
            if(!this.ajouterClient(client)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tournee{" +
                "depot=" + depot +
                ", quantiteLivre=" + quantiteLivre +
                ", distance=" + distance +
                ", capaciteMax=" + capaciteMax +
                ", mesClients=" + mesClients +
                '}';
    }

    public static void main(String[] args) {
        /*Depot d1 = new Depot(0, 0);
        Client c1 = new Client(5, 5, 10);
        Client c2 = new Client(-5, 5, 10);
        Client c3 = new Client(-5, -5, 10);
        Client c4 = new Client(5, -5, 10);
        Set<Point> ensPoint = new HashSet<>();
        ensPoint.add(c1);
        ensPoint.add(c2);
        ensPoint.add(c3);
        ensPoint.add(c4);
        d1.ajouterRoutes(ensPoint);  // ajout de tous les routes au depot
        ensPoint.add(d1);
        c1.ajouterRoutes(ensPoint);
        c2.ajouterRoutes(ensPoint);
        c3.ajouterRoutes(ensPoint);
        c4.ajouterRoutes(ensPoint);
        Set<Client> ensClient = new HashSet<>();
        ensClient.add(c1);
        ensClient.add(c2);
        ensClient.add(c3);
        ensClient.add(c4);

        Tournee t = new Tournee(d1, 50);
        System.out.println("Ajout de tous les clients : " + t.ajouterClient(ensClient));
        System.out.println(t);*/
    }
}
