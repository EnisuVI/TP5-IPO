package planning;

import exceptions.ExceptionQuantite;
import reseau.Client;
import reseau.Depot;
import reseau.Point;

import java.util.*;

public class Tournee {
    private Depot depot;
    private LinkedList<Client> listeClients;
    private int capaciteCamion;
    private int nombreCaissesLivrees;
    private double distanceParcourue;
    public Tournee(Depot ptDepart, int capaciteCamion) {
        this.depot = ptDepart;
        this.capaciteCamion = capaciteCamion;
        this.nombreCaissesLivrees = 0;
        this.distanceParcourue = 0;
        this.listeClients = new LinkedList<>();
    }

    public Depot getDepot() {
        return depot;
    }

    public List<Client> getListeClients() {
        return listeClients;
    }

    public int getCapaciteCamion() {
        return capaciteCamion;
    }

    public int getNombreCaissesLivrees() {
        return nombreCaissesLivrees;
    }

    public double getDistanceParcourue() {
        return distanceParcourue;
    }

    public boolean ajouterClient(Client client){
        if(client == null){
            return false;
        }
        if(capaciteCamion < (nombreCaissesLivrees + client.getNbCaisseDeBiereALivrer())){
            return false;
        }
        if(this.listeClients.isEmpty()){
            distanceParcourue = 2 * client.getDistance(depot);
        }
        else{
            Client dernierClient = this.listeClients.getLast();
            distanceParcourue -= dernierClient.getDistance(depot);
            distanceParcourue += client.getDistance(dernierClient);
            distanceParcourue += client.getDistance(depot);
        }
        nombreCaissesLivrees += client.getNbCaisseDeBiereALivrer();
        this.listeClients.add(client);
        return true;
    }

    public boolean ajouterClient(List<Client> clients){
        if(clients == null){
            return false;
        }
        for(Client client : clients){
            if(!this.ajouterClient(client)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tournee{" +
                "depot=" + depot +
                ", listeClients=" + listeClients +
                ", capaciteCamion=" + capaciteCamion +
                ", nombreCaissesLivrees=" + nombreCaissesLivrees +
                ", distanceParcourue=" + distanceParcourue +
                '}';
    }

    public static void main(String[] args) {
        try{
            Depot d1 = new Depot(0, 0);
            Client c1 = new Client(5, 5, 10);
            Client c2 = new Client(-5, 5, 10);
            Client c3 = new Client(-5, -5, 10);
            Client c4 = new Client(5, -5, 10);
            Set<Point> ensPoint = new HashSet<>();
            ensPoint.add(c1);
            ensPoint.add(c2);
            ensPoint.add(c3);
            ensPoint.add(c4);
            d1.ajouterRoutes(ensPoint);
            ensPoint.add(d1);
            c1.ajouterRoutes(ensPoint);
            c2.ajouterRoutes(ensPoint);
            c3.ajouterRoutes(ensPoint);
            c4.ajouterRoutes(ensPoint);
            List<Client> clients = new ArrayList<>();
            clients.add(c1);
            clients.add(c2);
            clients.add(c3);
            clients.add(c4);
            Tournee t = new Tournee(d1, 50);
            t.ajouterClient(clients);
            System.out.println(t);

        }
        catch(ExceptionQuantite ex){
            System.out.println(ex.getMessage() + ex.getQuantite());
        }
    }
}
