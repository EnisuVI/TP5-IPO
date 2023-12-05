package planification;

import exceptions.ExceptionQuantite;
import planning.Planning;
import reseau.Client;
import reseau.Depot;
import reseau.Point;
import reseau.Route;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Routage {
    private Depot depot;
    private Set<Client> mesClients;
    private Planning planning;
    private int capaciteVehicule;

    public Routage(int capaciteVehicule) {
        if (capaciteVehicule>0) {
            this.capaciteVehicule = capaciteVehicule;
        }
        else {
            this.capaciteVehicule = 0;
        }
        this.depot = new Depot(0,0);
        this.mesClients = new HashSet<>();
        this.planning = new Planning(this.capaciteVehicule);
    }

    public Routage(Depot depot, int capaciteVehicule) {
        this(capaciteVehicule);
        if (depot != null){
            this.depot = new Depot(depot.getAbscisse(), depot.getOrdonnee());
        }
        else {
            this.depot = new Depot(0,0);
        }
    }

    private void intialiserRoutes(){
        Set<Point> mesPoints = new HashSet<>();
        mesPoints.add(this.depot);
        for(Client client : this.mesClients){
            mesPoints.add(client);
        }
        for(Point point : mesPoints){
            point.ajouterRoutes(mesPoints);
        }

    }

    public void ecriturePlanning(String fichier){
        //Quand on précise rien, c'est forcément public void
        PrintWriter writer;
        try{
            writer = new PrintWriter(fichier);
            writer.println(this.planning);
            writer.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("Erreur à la création du fichier");
        }
    }

    public void traitementLigne(String ligne){
        System.out.println(ligne);
    }

    public void lectureClient(String fichierEntree){
        FileReader reader;
        BufferedReader lineReader;
        try{
            reader = new FileReader(fichierEntree);
            lineReader = new BufferedReader(reader);
            String ligne = lineReader.readLine();

            while(ligne != null) {
                traitementLigne(ligne);
                ligne = lineReader.readLine();
            }
            lineReader.close();
            reader.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("Erreur : fichier introuvable");
        }
        catch (IOException ex){
            System.out.println("Erreur en entrée/sortie");
        }
    }

    public void planificationBasique(){
        this.planning.planificationBasique(this.depot, this.mesClients);
    }

    private void creationClientsTest1() {
        try {
            Client c0 = new Client(-99.7497, 12.7171, 4);
            Client c1 = new Client(61.7481, 17.0019, 10);
            Client c2 = new Client(-29.9417, 79.1925, 17);
            Client c3 = new Client(49.321, -65.1784, 18);
            Client c4 = new Client(42.1003, 2.70699, 7);
            Client c5 = new Client(-97.0031, -81.7194, 8);
            Client c6 = new Client(-70.5374, -66.8203, 20);
            Client c7 = new Client(-10.8615, -76.1834, 1);
            Client c8 = new Client(-98.2177, -24.424, 11);
            Client c9 = new Client(14.2369, 20.3528, 13);
            mesClients.clear();
            mesClients.add(c0);
            mesClients.add(c1);
            mesClients.add(c2);
            mesClients.add(c3);
            mesClients.add(c4);
            mesClients.add(c5);
            mesClients.add(c6);
            mesClients.add(c7);
            mesClients.add(c8);
            mesClients.add(c9);
        }
        catch(ExceptionQuantite e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Routage{" +
                "depot=" + depot +
                ", mesClients=" + mesClients +
                ", planning=" + planning +
                ", capaciteVehicule=" + capaciteVehicule +
                '}';
    }

    public static void test(){
        Routage routage = new Routage(50);
        routage.creationClientsTest1();
        routage.intialiserRoutes();
        routage.planificationBasique();
        routage.ecriturePlanning("listeClients.txt");
        routage.lectureClient("nom.txt");
        //System.out.println(routage);
    }
    public static void main(String[] args) {
        test();
    }

}

