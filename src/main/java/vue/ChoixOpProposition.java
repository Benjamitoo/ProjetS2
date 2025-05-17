package vue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import modele.Atelier;
import modele.Operation;

public class ChoixOpProposition extends JFrame implements ActionListener {    
    
    public Operation choix;
    public boolean choix_fait = false;
    private Atelier atelier;
    private ArrayList<JButton> options = new ArrayList<>();

    public ChoixOpProposition(Atelier atelier) {
        this.atelier = atelier;

        // Configuration de la fenêtre
        setTitle("Choisissez une opération");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrer la fenêtre
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Création du panneau principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Création d’un bouton par opération
        for (Operation op : atelier.getListeOperations()) {
            JButton bouton = new JButton(op.getRef());
            bouton.addActionListener(this);
            bouton.setActionCommand(op.getRef()); // Action command pour identification
            options.add(bouton);
            panel.add(bouton);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomChoisi = e.getActionCommand();

        // On recherche l'opération correspondant au nom
        for (Operation op : atelier.getListeOperations()) {
            if (op.getRef().equals(nomChoisi)) {
                choix = op;
                choix_fait = true;
                break;
            }
        }

        // On ferme la fenêtre après le choix
        dispose();
    }
}