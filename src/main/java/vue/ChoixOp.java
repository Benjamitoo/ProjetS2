package vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.*;


public class ChoixOp extends JFrame implements ActionListener {
    public modele.Operation choix;
    public boolean choix_fait = false;
    private modele.Atelier atelier;
    
    ArrayList<JButton> options = new ArrayList<JButton>();
    for(int k = 0; k < atelier.getListeOperations().size(); k++){
        
        
    }
    
    
}
