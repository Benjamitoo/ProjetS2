package modele;


import java.util.*;




public class Machine extends Equipement {
    
    
    
    private String des;
    private String type;
    private float cout;
    private ArrayList<Evenement> listeEvenement;
    
    private float x;
    private float y;

    public Machine(String id, String ref, String des, String type, float cout, float x, float y) {
        super(id, ref);
        this.des = des;
        this.type = type;
        this.cout = cout;
        this.x = x;
        this.y = y;
        this.listeEvenement = new ArrayList<Evenement>();
    }
    
    
    
    //ajouter méthode getters/seter sur arraylist evenement
    
    

    
    
    
    
    public String getId() {
        return super.getId();
    }
    
    public String getRef() {
        return super.getRef();
    }

    public String getDes() {
        return des;
    }

    public String getType() {
        return type;
    }

    public float getCout() {
        return cout;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void addEvenement(Evenement e) {
        listeEvenement.add(e);
    }
    
    
    
    public void setId(String  id) {
        super.setId(id);
    }
    
    public void setRef(String ref) {
        super.setRef(ref);
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    
    //Calcul de la fiabilité
    public double getFiabilite() {
        int totalDureePannes = 0;
        for (Evenement e : listeEvenement) {
            totalDureePannes += e.getDuree();
        }
        double dureeFonctionnement = 840.0; // à adapter si nécessaire
        return 1.0 - (totalDureePannes / dureeFonctionnement);
    }


     
     //Obtenir les evenements de la machine
    public List<Evenement> getEvenements() {
        return listeEvenement;
    }
    
}
