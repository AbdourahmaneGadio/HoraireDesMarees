package vue;

import javax.swing.JFrame ;
import constantes.ConstantesCouleursFontes;
import modele.Date;
import java.awt.Insets;

/**
 * Classe repr�sentant la fen�tre dans laquelle sont affich�s tous les panels
 * @author agadio
 *
 */

public class FenetreMarees extends JFrame implements ConstantesCouleursFontes { 
	
	/**
	 * Le constructeur de la fenetre mere
	 * @param parTitre
	 */
	public FenetreMarees (String parTitre) {
	    super (parTitre); 
	    PanelMarees contentPane  = new PanelMarees ();
		
		setContentPane (contentPane);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
		setVisible(true);
		
		/*** accessibilit� : 
		 	* � l'ouverture du formulaire le focus est donn� au premier champ de saisie
	 		* instruction � placer apr�s setVisible(true);  
		*/
		
		setLocation(80,50);
		setSize(1800, 750);
		
		setBackground (MASTIC);
		
	} 
	 
	/**
	 * Le titre de la fenetre
	 * @param args
	 */
	public static void main (String  [] args) {
	 	new FenetreMarees ("Agenda " + Integer.toString(new Date().getAnnee()));
		
	}  

	public Insets getInsets() {
		return new Insets(60,20,20,20);
	}
} 