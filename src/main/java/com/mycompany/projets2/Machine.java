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
    
    private String refMachine;
    private String dMachine;
    private String type;
    private float cout;
    private float x;
    private float y;

    public String getRefMachine() {
        return refMachine;
    }

    public String getdMachine() {
        return dMachine;
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

    public void setRefMachine(String refMchine) {
        this.refMachine = refMachine;
    }

    public void setdMachine(String dMachine) {
        this.dMachine = dMachine;
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
