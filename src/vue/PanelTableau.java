package vue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import modele.Date;
import modele.Donnees;

/**
 * Panel affichant la table contenant les �v�nements
 * @author agadio
 *
 */

public class PanelTableau extends JPanel {
	
	//Declarations des objets
	ModeleTable modele;
	JTable tableSemaine;
	Date today = new Date();
	
	/**
	 * Constructeur du PanelAffichage
	 * @param parDonnees Les données choisies
	 */
	public PanelTableau(Donnees parDonnees){
		
		//Instanciations
		modele = new ModeleTable (today , parDonnees) ;
		tableSemaine = new JTable (modele) ;
		
		JScrollPane scrollPane = new JScrollPane(tableSemaine,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.add(scrollPane);
		
	}	//constructeur
	
	/**
	 * Change le mod�le de la table,
	 * en fonction de la date choisie par l'utilisateur
	 * @param parDate La date choisie par l'utilisateur
	 * @param parDonnees Les données choisies
	 */
	public void setModelTable (Date parDate, Donnees parDonnees) {
		tableSemaine.setModel( new ModeleTable (parDate, parDonnees) );
	}	// setModel()


}	// class PanelAffichage
