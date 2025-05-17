package modele;

import controleurs.ChefAtelier;
import modele.Produit;
import java.util.*;



public class Atelier {
    
    private String nom;
    private ChefAtelier CA;
    private ArrayList<Equipement> listeEquipement;
    private ArrayList<Produit> listeProduit;
    static private ArrayList<Operation> listeOperations;

    public Atelier(String nom, ChefAtelier CA) {
        this.nom = nom;
        this.CA = CA;
        this.listeEquipement = new ArrayList<Equipement>();
        this.listeProduit = new ArrayList<Produit>();
        this.listeOperations = new ArrayList<Operation>();
    }

    static public ArrayList<Operation> getListeOperations() {
        return listeOperations;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setListeOperations(ArrayList<Operation> listeOperations) {
        this.listeOperations = listeOperations;
    }
    
    
    
    
    
    
    
    
    public String getNom() {
        return nom;
    }

    public ChefAtelier getCA() {
        return CA;
    }

    public ArrayList<Equipement> getListeEquipement() {
        return listeEquipement;
    }
    
    public ArrayList<Produit> getListeProduit() {
        return listeProduit;
    }

    
    
    public void setnom(String nom) {
        this.nom = nom;
    }

    public void setCA(ChefAtelier CA) {
        this.CA = CA;
    }

    public void setListeEquipement(ArrayList<Equipement> listeEquipement) {
        this.listeEquipement = listeEquipement;
    }
    
    public void setListeProduit(ArrayList<Produit> listeProduit) {
        this.listeProduit = listeProduit;
    }
    
    
    public void addEquipement(Equipement e){
        listeEquipement.add(e);
    }
    
    public void removeEquipement(){}
    
    public void addProduit(Produit p) {
        listeProduit.add(p);
    }
    
    public void removeProduit(){
        
    }
       
    
    
    
    //POUR FIABILITÉ
    public ArrayList<Machine> getMachines() {
        ArrayList<Machine> machines = new ArrayList<>();
        for (Equipement e : listeEquipement) {
            if (e instanceof Machine) {
                machines.add((Machine) e);
            } else if (e instanceof Poste) {
                machines.addAll(((Poste) e).getListeMachines());
            }
        }
         return machines;
    }
    
    public Machine getMachineParNom(String nom) {
        for (Machine m : getMachines()) {
            if (m.getDes().equals(nom)) {  // ou getRef() ou getId(), selon le champ utilisé comme nom
                return m;
            }
        }
        return null;
    }
    
    
    public List<Machine> getMachinesTrieesParFiabilite() {
        List<Machine> machines = getMachines(); // récupère toutes les machines
        machines.sort(Comparator.comparingDouble(Machine::getFiabilite).reversed());
        return machines;
    }
    
    
    
}
