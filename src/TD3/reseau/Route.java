package TD3.reseau;

import java.util.Objects;
import java.util.Set;

public class Route {

    private double distance;
    private Point origine;
    private Point destination;

    /**
     * Main constructor
     * @param origine Point origine
     * @param destination Point destination
     */
    public Route(Point origine, Point destination) {
        this.origine = origine;
        this.destination = destination;

        double deltaX = origine.getAbscisse() - destination.getAbscisse();
        double deltaY = origine.getOrdonne() - destination.getOrdonne();
        this.distance = Math.sqrt(deltaX*deltaX + deltaY*deltaY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return origine.equals(route.origine) &&
                destination.equals(route.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origine, destination);
    }

    public Point getOrigine() {
        return origine;
    }

    public Point getDestination() {
        return destination;
    }

    /**
     * @return distance up to 2 decimals
     */
    public double getDistance() {
        return Math.round(distance * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Route{" +
                "distance=" + distance +
                ", origine=" + origine +
                ", destination=" + destination +
                '}';
    }

    public static void main(String[] args) {
        Point origine = new Point(10, 9.5);
        Point dest = new Point(2, -6);

        Route route1 = new Route(origine, dest);
        Route route2 = new Route(origine, dest);
        //System.out.println(route.getDistance());
        System.out.println(route1.equals(route2));


    }
}

