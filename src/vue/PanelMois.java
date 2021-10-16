package vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constantes.ConstantesCalendrier;
import constantes.ConstantesCouleursFontes;
import controleur.Controleur;
import modele.CalendrierDuMois;
import modele.Date;

/**
 * Classe contenant le panel representant les 12 mois de l'annee a mettre dans le calendrier
 * @author agadio
 *
 */

public class PanelMois extends JPanel implements ActionListener,ConstantesCalendrier, ConstantesCouleursFontes {

	BoutonDate boutonSelectionne ;	 
	
	ArrayList <BoutonDate> listeBoutons = new ArrayList<BoutonDate>();
	
	/**
	 * Le constructeur du PanelMois
	 * @param mois Le mois choisi
	 */
	public PanelMois (int mois)  {
		Date today = new Date();
		 
		Collection <Date> datesDuMois = new CalendrierDuMois(mois,today.getAnnee()).getDates();
		//System.out.println(datesDuMois);		
		this.setLayout(new GridLayout (0,7,8,8));
		for (int i= 0; i < 7 ; i++) {
			JLabel labeljour = new  JLabel (JOURS_SEMAINE_ABR[i],JLabel.CENTER);
			this.add(labeljour);			
		}
		
		BoutonDate boutonJour;
		
		Iterator <Date> iterateur = datesDuMois.iterator();
		while (iterateur.hasNext()) {
				Date date = iterateur.next() ;
				boutonJour = new  BoutonDate (date);
				
				// Ajout de chaque bouton a la liste BoutonMois
				listeBoutons.add(boutonJour);
				
				boutonJour.addActionListener(this);  // gestion des couleurs des boutons 
				this.add(boutonJour);
				 
				boutonJour.setBackground (VANILLE);
				
			
				if (date.isToday()) {
					boutonJour.setBackground(VERT);
				}	
				if (date.getMois()!=mois)
					boutonJour.setForeground(BLEU);		
				
				

				
					
		}		
		
		setBackground (VANILLE);
	}
	
	
	/**
	 * Change la couleur du bouton selectionne, en fonction de la date de celui-ci.
	 * Si la date est celle d'aujourd'hui, le bouton a une couleur vanille.
	 * Sinon, il a une autre couleur.
	 */
	
	public void actionPerformed(ActionEvent evt) {
		
		if (boutonSelectionne != null && !boutonSelectionne.getDate().isToday()) {
			boutonSelectionne.setBackground(VANILLE);			
		}
		
		boutonSelectionne = (BoutonDate) evt.getSource();
		
		if (!boutonSelectionne.getDate().isToday()) {
			boutonSelectionne.setBackground(MASTIC);
		}		
		
	}
	
	
	/**
	 * Retourne le bouton selectionne
	 * @return JButton
	 */
	
	public JButton getBoutonSelectionne () {
		return boutonSelectionne;	
	}

	
	/**
	 * Met tous les boutons a l'ecoute du controleur. 
	 * Le controleur reagit des que l'on clique sur un bouton
	 * @param controleur Le controleur
	 */
	
	  public void enregistreEcouteur(Controleur controleur) {
		  
		  //On met a l'ecoute tous les boutons du mois
		  for(BoutonDate bouton : listeBoutons){
			  bouton.addActionListener(controleur);	  
		  }
			
	  }
	  
}	// class PanelMois
