package modele;
//Changer Package pour main

import javax.swing.*;

public class ProjetS2 {

    public static void main(String[] args) {
        // Toujours lancer l'interface graphique dans le thread de l'EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 600);
            
            JButton button = new JButton("Clique-moi !");
            button.addActionListener(e -> button.setText("Bravo 🎉"));
            
            frame.getContentPane().add(button);
            frame.setLocationRelativeTo(null); // Centrer la fenêtre
            frame.setVisible(true);
        });
    }
}