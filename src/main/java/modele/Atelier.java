package modele;

import controleurs.ChefAtelier;
import modele.Produit;
import java.util.*;




public class Atelier {
    
    private String nom;
    private ChefAtelier CA;
    private ArrayList<Equipement> listeEquipement;
    private ArrayList<Produit> listeProduit;
    
    
    public Atelier(String nom, ChefAtelier CA){
        this.nom = nom;
        this.CA = CA;
        this.listeEquipement = new ArrayList<>();
        this.listeProduit = new ArrayList<>();
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
       
    
}
