package TD3.reseau;

import java.util.HashSet;
import java.util.Set;

public class Depot extends Point {

    public Depot() {
        super();
    }

    public Depot(double abscisse, double ordonne) {
        super(abscisse, ordonne);
    }

    @Override
    public String toString() {
        return "Depot{" + super.toString() + "}";
    }

    public static void main(String[] args) {
        Depot d = new Depot(0, 0);
        Client c1 = new Client(5, 5, 10);
        Client c2 = new Client(-5, 5, 10);
        Client c3 = new Client(-5,-5, 10);
        Client c4 = new Client(5,-5, 10);
        Set<Point> mesClients = new HashSet<>();
        mesClients.add(c1);
        mesClients.add(c2);
        mesClients.add(c3);
        mesClients.add(c4);
        d.ajouterRoutes(mesClients);
        System.out.println(d);
    }
}
