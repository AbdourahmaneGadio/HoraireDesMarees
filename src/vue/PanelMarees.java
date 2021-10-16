package vue;

import java.awt.FlowLayout;
import javax.swing.JPanel;

import constantes.ConstantesCouleursFontes;
import controleur.Controleur;
import modele.Donnees;



/**
 * Classe contenant le panel qui affiche le calendrier, le formulaire, et le tableau
 * @author agadio
 *
 */


public class PanelMarees extends JPanel implements ConstantesCouleursFontes {
	
	 /**
	  * Le constructeur du PanelMarees.
	  * Il instancie tous les panels
	  */
	 public PanelMarees () {
		 
		/**
		 * Cr�e l'agenda, et y ajoute le calendrier, le formulaire et le tableau 
		 */
	  
		setLayout(new FlowLayout(FlowLayout.CENTER,25, 25));
		
		Donnees donnees = new Donnees();
		
		// Instanciations des panels
		PanelListe panelListe = new PanelListe();
		PanelCalendrier panelCalendrier = new PanelCalendrier ();
		PanelTableau panelTableau = new PanelTableau(donnees);
		
		Controleur controleur = new Controleur(donnees, panelListe, panelCalendrier, panelTableau);
		 
		// Ajout des panels
		this.add(panelCalendrier);		
		this.add(panelListe);
		this.add(panelTableau);
		
		setBackground(VANILLE);
	}
	 

	

}
