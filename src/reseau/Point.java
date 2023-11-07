package reseau;

public class Point {
    /**
     * représente l'identifiant unique du client
     */
    private int idClient;
    /**
     * abscisse à laquelle se situe le client
     */
    private float abscisse;
    /**
     * ordonnée à laquelle se situe le client
     */
    private float ordonnee;

    private static int dernierId = 0;

    public Point(float abscisse, float ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
        this.idClient = dernierId;
        dernierId++;
    }

    /**
     * getters
     */
    public float getAbscisse() {
        return abscisse;
    }

    public float getOrdonnee() {
        return ordonnee;
    }

    /**
     * setters
     */
    public void setAbscisse(float abscisse) {
        this.abscisse = abscisse;
    }

    public void setOrdonnee(float ordonnee) {
        this.ordonnee = ordonnee;
    }

    /**
     * méthode toString
     */
    @Override
    public String toString() {
        return "Point{" +
                "idClient=" + idClient +
                ", abscisse=" + abscisse +
                ", ordonnee=" + ordonnee +
                '}';
    }

    public static void main(String[] args) {
        Point p1 = new Point(1,3);
        Point p2 = new Point(3,5);
        Point p3 = new Point(6, 2);
        Point p4 = new Point(12, 10);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }
}
