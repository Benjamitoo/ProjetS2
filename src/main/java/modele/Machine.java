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
public class Machine extends Equipement {
    
    
    
    private String ref;
    private String des;
    private String type;
    private float cout;
    
    private float x;
    private float y;

    public Machine(String ref, String des, String type, float cout, float x, float y) {
        this.ref = ref;
        this.des = des;
        this.type = type;
        this.cout = cout;
        this.x = x;
        this.y = y;
    }
    
    
    
    
    
    

    
    
    
    
    public String getRef() {
        return ref;
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

    public void setRef(String ref) {
        this.ref = ref;
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
    
}
