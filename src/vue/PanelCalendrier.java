package vue;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel ;

import constantes.ConstantesCalendrier;
import constantes.ConstantesCouleursFontes;
import controleur.Controleur;
import modele.Date;

import javax.swing.JLabel ;
import javax.swing.JButton ;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe contenant le panel qui contient toutes les informations du calendrier
 * @author agadio
 *
 */

public class PanelCalendrier  extends JPanel implements ActionListener, ConstantesCalendrier, ConstantesCouleursFontes {
	
	JPanel panelCentre = new JPanel ( ) ; 
	CardLayout gestCard = new CardLayout(10,10);
	JButton [] tabBoutons = new JButton [INTITULES_BOUTONS.length];
	 
	JLabel labelIntituleMois;
	 	
	int indiceMois = 0;  
		 
	PanelMois [] panelsMois ;	
  
  /**
   * Le constructeur du PanelCalendrier
   */
  public PanelCalendrier  ()	{
	 
	Date today = new Date();		 
	
	this.setLayout (new BorderLayout (9,9)) ;  
	JPanel panelSud = new JPanel ( ) ; 
	this.add (panelSud, BorderLayout.SOUTH); 
		
	// panelCentre
	this.add (panelCentre, BorderLayout.CENTER);
	panelsMois = new PanelMois [MOIS.length];

	panelCentre.setLayout (gestCard);
	for (int indiceMois = 0 ; indiceMois< ConstantesCalendrier.MOIS.length ; indiceMois++)		{
		//JLabel etiq = new JLabel (MOIS[indiceMois]);  // pour test prealable
		//panelCentre.add (etiq, MOIS[indiceMois]);
		
		panelsMois [indiceMois] = new PanelMois (indiceMois+1);	 
	 	panelCentre.add (panelsMois[indiceMois], MOIS[indiceMois]);
		
	}
	// placer le mois courant en haut de la pile
	gestCard.show (panelCentre, MOIS[today.getMois()-1]); 		
	indiceMois = today.getMois()-1;
	
	// panelSud  
	labelIntituleMois = new JLabel (MOIS[today.getMois()-1], JLabel.LEFT);
	labelIntituleMois.setPreferredSize(new Dimension (80,20)); 		 
	labelIntituleMois.setFont (new Font ("Verdana",Font.PLAIN,14));	 
	panelSud.add (labelIntituleMois);  
	
	panelSud.setLayout (new FlowLayout ( FlowLayout.CENTER, 4,4));	
	for (int i = 0 ; i< INTITULES_BOUTONS.length ; i++)		{
		tabBoutons[i] = new JButton (INTITULES_BOUTONS[i]);  
		tabBoutons[i].setActionCommand(INTITULES_BOUTONS[i]) ; 
		tabBoutons[i].addActionListener (this);  
		tabBoutons[i].setFont (new Font ("Verdana",Font.PLAIN,16));
		tabBoutons[i].setBackground(ConstantesCouleursFontes.VANILLE);
		tabBoutons[i].setBorderPainted(false);
		panelSud.add (tabBoutons[i]) ;
	}
	
	panelCentre.setBackground( VANILLE);
	panelSud.setBackground ( VANILLE);	
	setBackground (VANILLE);
	setPreferredSize(new Dimension (500,320));
	
} // PanelFils  ()
  
  /**
   * Change la couleur du bouton selectionne, et transmet la date du bouton en texte
   */

  public void actionPerformed (ActionEvent evt){   
	  
	// pour decoloriser le bouton selectionne  
	JButton boutonSelectionne = panelsMois[indiceMois].getBoutonSelectionne();
	if (boutonSelectionne != null) {
		boutonSelectionne.setBackground(VANILLE);
	}
	switch (evt.getActionCommand()) {
		case INTIT_PREMIER :{
			gestCard.first (panelCentre);
			indiceMois=0; 			
			break;
		}
		case INTIT_PRECEDENT :{
			gestCard.previous (panelCentre);		 
			if (indiceMois==0) {
				indiceMois=ConstantesCalendrier.MOIS.length-1; 				
				}
			else {
				--indiceMois;
			}
			break ;
		}
		case INTIT_SUIVANT :{
			gestCard.next (panelCentre);		
			if (indiceMois==ConstantesCalendrier.MOIS.length-1) {
				indiceMois=0; 
				 
				}
			else {
				++indiceMois;
			}
			break;
		}
		case INTIT_DERNIER : {
			gestCard.last (panelCentre);
			indiceMois=ConstantesCalendrier.MOIS.length-1; 
			break;			
		}
		 
	}// switch
	labelIntituleMois.setText (ConstantesCalendrier.MOIS[indiceMois]);
	
  }// actionPerformed

  /**
   * Met le controleur a l'ecoute des PanelMois
   * @param controleur Le controleur
   */
  public void enregistreEcouteur(Controleur controleur) {
	  
	  //On initialise un tableau contenant 12 panelMois
	  for(PanelMois panel : panelsMois){
	  
		  panel.enregistreEcouteur(controleur);
		  
	  }
		
  }
  


} 
