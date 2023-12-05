package planning;

import java.util.HashSet;

public class Planning {
    private HashSet<Tournee> listeTournee;
    private int distanceTotale;
    private int nombreDeCaissesDeBiere;
    private int capaciteCamion;

    public Planning(int capaciteCamion) {
        this.capaciteCamion = capaciteCamion;
    }

    public HashSet<Tournee> getListeTournee() {
        return listeTournee;
    }

    public int getDistanceTotale() {
        return distanceTotale;
    }

    public int getNombreDeCaissesDeBiere() {
        return nombreDeCaissesDeBiere;
    }

    public int getCapaciteCamion() {
        return capaciteCamion;
    }

    private boolean ajouterTournee(Tournee t){

    }
}
