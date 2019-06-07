package TD3.planification;

import TD3.planning.Planning;
import TD3.reseau.Client;
import TD3.reseau.Depot;
import TD3.reseau.Point;

import java.util.Set;

public class Routage {
    private Depot depot;
    private Set<Client> mesClients;
    private Planning planning;
    private int capacite;

    public Routage(int capacite) {
        this.capacite = capacite;
        this.depot = new Depot(0, 0);
    }

    public Routage(Depot depot, int capacite) {
        this.depot = depot;
        this.capacite = capacite;
    }

    private void initialiserRoutes(){
        // ajoute toutes les routes au depot (du depot à l'ensemble des clients)
        depot.ajouterRoutes(mesClients);
    }

    public void planificationBasique(){
        this.planning.planificationBasique(depot, mesClients);
    }

    public static void test(){

    }

    private void creationClientsTest1() {
        Client c0 = new Client(99.7497, 12.7171, 4);
        Client c1 = new Client(61.7481, 17.0019, 10);
        Client c2 = new Client(29.9417, 79.1925, 17);
        Client c3 = new Client(49.321, 65.1784, 18);
        Client c4 = new Client(42.1003, 2.70699, 7);
        Client c5 = new Client(97.0031, 81.7194, 8);
        Client c6 = new Client(70.5374, 66.8203, 20);
        Client c7 = new Client(10.8615, 76.1834, 1);
        Client c8 = new Client(98.2177, 24.424, 11);
        Client c9 = new Client(14.2369, 20.3528, 13);
        mesClients.clear();
        mesClients.add(c0);
        mesClients.add(c1);
        mesClients.add(c2);
        mesClients.add(c3);
        mesClients.add(c4);
        mesClients.add(c5);
        mesClients.add(c6);
        mesClients.add(c7);
        mesClients.add(c8);
        mesClients.add(c9);
    }
}
