/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TD3.reseau;

import java.util.*;

/**
 * Cette classe de test permet de tester l'association entre des points
 * avec une classe d'association : Route
 * En fonction de la structure de donnees utilisee dans la classe Point,
 * il faut verifier que le bon nombre de routes ait ete ajoute,
 * et que le calcul de la moyenne des distances de tournees
 * se fasse dans un temps raisonnable.
 *
 * @author Maxime Ogier
 */
public class TestAssociationPoints {
    public static void main(String[] args) {
        int nbPoints = 2000;
        int nbTournees = 1000;
        System.out.println("Il y a "+nbPoints+" points");
        List<Point> points = genererPointsAlea(nbPoints);
        ajouterRoutes(points);
        nbRoutesPremierPoint(points);
        calculDistanceTournees(points, nbTournees);
    }

    /**
     * Affiche la moyenne des distances des tournees qui passent par tous les 
     * points de la liste
     * nbTournees sont generees pour calculer la moyenne
     * @param points liste de points
     * @param nbTournees le nombre de tournees a generer
     */
    private static void calculDistanceTournees(List<Point> points, int nbTournees) {
        long time = System.currentTimeMillis();
        double distance = 0;
        Random rand = new Random(0);
        for(int i=0; i<nbTournees; i++) {
            distance += calculDistanceTourneeAlea(points, rand);
        }
        long deltaTime = System.currentTimeMillis() - time;
        System.out.println("Calcul de la moyenne des distances pour "+nbTournees+ " tournees");
        System.out.println("La moyenne vaut : "+distance/nbTournees);
        System.out.println("La moyenne est calculee en "+deltaTime+" ms");
    }

    /**
     * Calcul la distance d'une tournee qui passe par tous les points de la liste
     * Au prealable la liste est melangee aleatoirement
     * @param points la liste de points a visiter dans la tournee
     * @param rand generateur de nombres aleatoires
     * @return la distance de la tournee
     */
    private static double calculDistanceTourneeAlea(List<Point> points, Random rand) {
        double distance = 0;
        Collections.shuffle(points, rand);
        Point courant = points.get(0);
        Point suivant;
        for(int i=1; i<points.size(); i++) {
            suivant = points.get(i);
            distance += courant.getDistance(suivant);
            courant = suivant;
        }
        suivant = points.get(0);
        distance += courant.getDistance(suivant);
        return distance;
    }

    /**
     * Affiche le nombre de routes qui partent du premier point de la liste
     * @param points liste de points
     */
    private static void nbRoutesPremierPoint(List<Point> points) {
        if(points == null || points.isEmpty()) {
            System.out.println("Aucun point dans l'ensemble des points ...");
            return;
        }
        Iterator<Point> iter = points.iterator();
        Point p1 = iter.next();
        System.out.println("Il y a "+p1.getNbRoutes()+" routes qui partent du point p1");
    }

    /**
     * Cette methode ajoute pour chaque point les routes vers chaque autre point.
     * L'ajout est repete trois fois afin de verifier que la methode d'ajout des
     * routes est correcte !
     * Une seule route doit etre ajoutee et non trois !
     * @param points la liste de points pour lesquels on ajoute des routes
     */
    private static void ajouterRoutes(List<Point> points) {
        long time = System.currentTimeMillis();
        Set<Point> ensPoints = new HashSet<>(points);
        for(Point p : points) {
            p.ajouterRoutes(ensPoints);
            // Supposons que l'on essaye d'ajouter plusieurs fois les memes destinations ...
            p.ajouterRoutes(ensPoints);
            p.ajouterRoutes(ensPoints);
        }
        long deltaTime = System.currentTimeMillis() - time;
        System.out.println("Les routes sont ajoutées en "+deltaTime+" ms");
    }

    /**
     * Cette methode utilise un generateur de nombre aleatoires
     * afin de renvoyer une liste de points avec des coordooonees aleatoires
     * @param nbPoints le nombre de points a generer
     * @return une liste de nbPoints points
     */
    private static List<Point> genererPointsAlea(int nbPoints) {
        /*List<Point> points = new ArrayList<>();
        Random rand = new Random(0);
        for(int i=0; i<nbPoints; i++) {
            Point p = new Point(rand.nextDouble(), rand.nextDouble());
            points.add(p);
        }
        return points;*/
        return null;
    }
}