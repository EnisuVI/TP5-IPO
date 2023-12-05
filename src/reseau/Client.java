package reseau;

import exceptions.ExceptionQuantite;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Desnyder Rémi
 * Date: 07/11/2023
 */

public class Client extends Point{

    private int nbCaisseDeBiereALivrer;

    public Client(double abscisse, double ordonnee, int nbCaisseDeBiereALivrer) throws ExceptionQuantite {
        super(abscisse, ordonnee);

        if (nbCaisseDeBiereALivrer > 0) {
            this.nbCaisseDeBiereALivrer = nbCaisseDeBiereALivrer;
        } else {
            //this.nbCaisseDeBiereALivrer = 0;
            ExceptionQuantite exQuantite = new ExceptionQuantite(nbCaisseDeBiereALivrer, "\nLa quantité est trop basse. Quantité : ");
            throw exQuantite;
        }
    }

    public int getNbCaisseDeBiereALivrer() {
        return nbCaisseDeBiereALivrer;
    }

    @Override
    public String toString() {
        return "Client{" +
                super.toString() +
                //"idClient=" + this.getIdClient() +
                //", abscisse=" + this.getAbscisse() +
                //", ordonnee=" + this.getOrdonnee() +
                ", nbCaisseDeBiereALivrer=" + nbCaisseDeBiereALivrer +
                '}';
    }

    public static void main(String[] args) { //méthode principale: psvm
        /*Client c1 = new Client(1, 2, 3);
        Client c2 = new Client(3, 4, 5);
        Client c3 = new Client(-5, 6, 7);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);*/

        try{
            Client c1 = new Client(5, 5, 10);
            System.out.println("Creation ok");
            Client c2 = new Client(5, -5, 0);
            System.out.println("Creation ok");
        }
        catch (ExceptionQuantite ex) {
            System.out.println(ex.getMessage() + ex.getQuantite());
            if(ex.getQuantite() < 0){
                System.exit(-1);
            }
        }
        System.out.println("Test");
    }
}
