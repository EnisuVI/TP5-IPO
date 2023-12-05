package exceptions;

public class ExceptionQuantite extends Exception{
    private int quantite;

    public ExceptionQuantite(int quantite) {
        super("Quantité trop basse");
        this.quantite = quantite;
    }

    public ExceptionQuantite(int quantite, String message) {
        super(message);
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    @Override
    public String toString() {
        return "ExceptionQuantite{" +
                "quantite=" + quantite +
                '}';
    }

}
