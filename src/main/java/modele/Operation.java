package modele;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benjamin
 */
public class Operation {
    private String ref;
    private String des;
    private float duree;
    private Equipement equipement;

    public Operation(String ref, String des, float duree, Equipement equipement) {
        this.ref = ref;
        this.des = des;
        this.duree = duree;
        this.equipement = equipement;
    }

    public String getRef() {
        return ref;
    }

    public String getDes() {
        return des;
    }

    public float getDuree() {
        return duree;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }
    
    
    
    
}
