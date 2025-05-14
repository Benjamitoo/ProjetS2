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
import com.mycompany.projets2.Equipement;
import java.util.*;

public class Poste extends Equipement {
    
    private String ref;
    private String des;
    private ArrayList<Machine> listeMachines;   

    public Poste(String ref, String des, ArrayList<Machine> listeMachines) {
        this.ref = ref;
        this.des = des;
        this.listeMachines = listeMachines;
    }
    
    

    
    
    public String getRef() {
        return ref;
    }

    public String getDes() {
        return des;
    }

    public ArrayList<Machine> getListeMachines() {
        return listeMachines;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setListeMachines(ArrayList<Machine> listeMachines) {
        this.listeMachines = listeMachines;
    }
    
    
    
}
