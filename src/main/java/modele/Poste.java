package modele;

import java.util.*;





public class Poste extends Equipement {
    
    private ArrayList<Machine> listeMachines;   

    public Poste(String id, String ref) {
        super(id, ref);
        this.listeMachines = new ArrayList<Machine>();
    }
    
    

    
    
    public String getId() {
        return super.getId();
    }

    public String getRef() {
        return super.getRef();
    }

    public ArrayList<Machine> getListeMachines() {
        return listeMachines;
    }

    public void setId(String id) {
        super.setId(id);
    }

    public void setDes(String ref) {
        super.setRef(ref);
    }

    public void setListeMachines(ArrayList<Machine> listeMachines) {
        this.listeMachines = listeMachines;
    }
    
    
    
}
