package TD3.reseau;

import java.util.*;

public abstract class Point {

    private int id;
    private double abscisse;
    private double ordonne;
    private static int lastId = 0;
    /**
     * prend en compte l'asso, ensembles des routes
     */
    private Map<Point, Route> mesRoutes = new HashMap<>();

    public Point() {
        this.id = lastId;
        lastId++;
        this.abscisse = 0;
        this.abscisse = 0;
    }

    public Point(double abscisse, double ordonne) {
        this();
        this.abscisse = abscisse;
        this.ordonne = ordonne;
    }

    public double getAbscisse() {
        return abscisse;
    }

    public double getOrdonne() {
        return ordonne;
    }

    /**
     * ajoute une route à la Map mesRoutes
     *
     * @param mesDestinations ensemble des points joignables
     */
    public void ajouterRoutes(Set<Client> mesDestinations) {
        for (Point pointDestination : mesDestinations) {
            Route maRoute = new Route(this, pointDestination);
            this.mesRoutes.put(pointDestination, maRoute);  // avec HashMap<> vérifie l'unicité
        }
    }

    /**
     * get distance from current point to point p and check point existence
     *
     * @param p destination
     * @return get
     */
    public double getDistance(Point p) {
        if (p == null) return Double.POSITIVE_INFINITY;
        Route isRoute = this.mesRoutes.get(p);
        if (isRoute != null) {
            return isRoute.getDistance();
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
        return "id=" + id +
                        ", Nombre de routes=" + this.mesRoutes.size() +
                        ", abscisse=" + abscisse +
                        ", ordonne=" + ordonne;
    }

    public static void main(String[] args) {
        /*Point pnt0 = new Point(12.5, 22);
        Point pnt0bis = new Point(12.5, 22);
        System.out.println(pnt0);
        System.out.println(pnt0.equals(pnt0bis));
        System.out.println(pnt0.hashCode());
        System.out.println(pnt0bis.hashCode());*/
    }
}
