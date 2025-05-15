package modele;

import controleurs.Operateur;


//Définir type des attributs date & heure
//Conservation attribut machine ???

public class Evenement {
    
    private date;
    private heure;
    //private Machine machine; ????
    private Operateur operateur;
    private String cause;
    
    public Evenement() {
        this.date=d;
        this.heure=h;
        //this.machine=m; ???
        this.operateur=o;
        this.cause=c;
    }
    
    
    public getDate() {
        return this.date;
    }
    
    public getHeure() {
        return this.heure;
    }
    
    public Machine getMachine() {
        return this.Machine;
    }
    
    public Operateur getOperateur() {
        return this.operateur;
    }
    
    public String getCause() {
        return this.cause;
    }
    
    
    public void setDate(d) {
        this.date=d;
    }
    
    public void setHeure(h) {
        return this.date=d;
    }
    
    public void setMachine(Machine m) {
        return this.machine=m;
    }
    
    public void setOperateur(Operateur o) {
        this.operateur=o;
    }
    
    public void setCause(String c) {
        this.cause=c;
    }
    
    
    
}
