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


public class ModGamWin extends JFrame  implements ActionListener {
		//fenêtre de réponse du mode Lettres d'un joueur
		
		
		private JButton ajoutPrem = new JButton("Ajouter au début");
                private JButton ajoutDer = new JButton("Ajouter à la fin");
                private JButton supp = new JButton("Supprimer");
                private JLabel titre = new JLabel();
                private JLabel affiche = new JLabel();

		
		
		public ModGamWin(modele.Gamme gamme){             
                    this.setTitle(gamme.getRef());
		    this.setSize(600, 300);
		    this.setLocation(900, 200); 
                    
                    this.titre.setText("Gamme " + gamme.getRef());
                    this.affiche.setText(gamme.affiche());
		    
	
		    
		    Font police = new Font("Tahoma", Font.BOLD, 16);
			
						
		    JPanel pan = new JPanel();
		    
		    pan.setBackground(Color.WHITE);
		    pan.setLayout(new BorderLayout());
		    pan.add(titre, BorderLayout.NORTH);
                    pan.add(affiche, BorderLayout.NORTH);
		    		  		    		    		    
		    JPanel south = new JPanel();
 
		    pan.add(south, BorderLayout.SOUTH);
                    south.add(ajoutPrem);ajoutPrem.addActionListener(this);
                    south.add(ajoutDer);ajoutDer.addActionListener(this);
                    south.add(supp);supp.addActionListener(this);
                    
                    
		   
		    		    		    		    		   		    
		    this.setContentPane(pan);               
		    this.setVisible(true);		 
		}													 		 			
		 
		public void actionPerformed(ActionEvent arg0) {
                    if (arg0.getSource()==ajoutPrem){
                        
                    }
			//System.out.println(arg0.getSource());
			
		 }
		
		 
}




