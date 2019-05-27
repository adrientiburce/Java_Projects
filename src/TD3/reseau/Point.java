package TD3.reseau;

import TD1.Personne;

import java.util.*;

public class Point {

    private int id;
    private double abscisse;
    private double ordonne;
    private static int lastId = 0;
    /**
     * prend en compte l'asso, ensembles des routes
     */
    private Set<Route> mesRoutes = new HashSet<>();

    public Point(double abscisse, double ordonne) {
        this.abscisse = abscisse;
        this.ordonne = ordonne;
        this.id = lastId;
        lastId++;
    }

    public double getAbscisse() {
        return abscisse;
    }

    public double getOrdonne() {
        return ordonne;
    }

    /**
     * ajoute une route
     *
     * @param mesDestinations ensemble des points joignables
     */
    public void ajouterRoutes(Set<Point> mesDestinations) {
        for (Point pointDestination : mesDestinations) {
            Route maRoute = new Route(this, pointDestination);
            this.mesRoutes.add(maRoute);  // avec Set<> vérifie l'unicité
        }
    }

    /**
     * get distance from current point to point p and check point existence
     * @param p destination
     * @return get
     */
    public double getDistance(Point p) {
        if (p == null) return Double.POSITIVE_INFINITY;
        for (Route route : mesRoutes) {
            if (route.getDestination().equals(p)) {
                return route.getDistance();
            }
        }
        return Double.POSITIVE_INFINITY;
    }

    public int getNbRoutes() {
        return this.mesRoutes.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return id == point.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", abscisse=" + abscisse +
                ", ordonne=" + ordonne +
                '}';
    }

    public static void main(String[] args) {
        Point pnt0 = new Point(12.5, 22);
        Point pnt0bis = new Point(12.5, 22);


        System.out.println(pnt0);
        System.out.println(pnt0.equals(pnt0bis));
        System.out.println(pnt0.hashCode());
        System.out.println(pnt0bis.hashCode());
    }
}
