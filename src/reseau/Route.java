package reseau;

public class Route {
    /**
     * point de départ
     */
    private Point origine;
    /**
     * point d'arrivée
     */
    private Point destination;

    /**
     * distance qui sépare les deux points
     */
    private double distance;

    /**
     * constructeur par données
     */
    public Route(Point origine, Point destination) {
        this.origine = origine;
        this.destination = destination;
        this.distance = Math.sqrt(Math.pow(destination.getAbscisse() - origine.getAbscisse(),2)+Math.pow(destination.getOrdonnee() - origine.getOrdonnee(),2));
    }

    /**
     * getters
     */
    public Point getOrigine() {
        return origine;
    }

    public Point getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }

    /**
     * setters
     */
    public void setOrigine(Point origine) {
        this.origine = origine;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "origine=" + origine +
                ", destination=" + destination +
                ", distance=" + distance +
                '}';
    }

    public static void main(String[] args) {
        Point p1 = new Point(1,3);
        Point p2 = new Point(3,5);
        Point p3 = new Point(6, 2);
        Point p4 = new Point(12, 10);

        Route r1 = new Route(p1,p2);
        Route r2 = new Route(p2,p4);
        Route r3 = new Route(p4,p1);
        Route r4 = new Route(p1,p3);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
    }
}
