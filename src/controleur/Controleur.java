package controleur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;

import modele.*;
import outils.LectureFichierTxt;
import vue.*;

/**
 * Classe contenant le contr�leur qui fait le lien entre les diff�rents panels
 * @author agadio
 *
 */

public class Controleur implements ActionListener {
	
	Donnees donnees;
	PanelListe panelListe;
	PanelCalendrier panelCalendrier;
	PanelTableau panelTableau;
	
	final static File REPERTOIRE_PORTS = new File("mes_ports");
	final static File[] ACCES_PORTS = REPERTOIRE_PORTS.listFiles();
	final static String [] NOMS_PORTS = REPERTOIRE_PORTS.list();
	
	
	/**
	 * Le contr�leur prend en param�tre les panels,
	 * et se met à leur écoute
	 * @param parDonnees Les donnees choisies
	 * @param parPanelListe Le PanelListe
	 * @param parPanelCalendrier Le PanelCalendrier
	 * @param parPanelAffichage Le PanelAffichage
	 */
	public Controleur (Donnees parDonnees,
	PanelListe parPanelListe, PanelCalendrier parPanelCalendrier, PanelTableau parPanelAffichage) {
		
		donnees = parDonnees;
		panelListe = parPanelListe;
		panelCalendrier = parPanelCalendrier;
		panelTableau = parPanelAffichage;
		
		panelCalendrier.enregistreEcouteur(this);
		panelListe.enregistreEcouteur(this);
		
		
	}	//constructeur

	
	/** Lors d'un clic sur une date ou un fichier d'une liste
	 * le controleur recupere la date et le fichier, et les met dans le tableau
	 */
	public void actionPerformed(ActionEvent evt) {
				
		// Si le bouton cliqu� est une date
		if (evt.getSource() instanceof BoutonDate){
			
			BoutonDate boutonDate = (BoutonDate) evt.getSource();	// On r�cup�re le bouton (get)
			
			LectureFichierTxt.lecture(ACCES_PORTS[0], boutonDate.getDate());	// On lit le fichier sélectionné à la bonne date
			
			// On transmet la date au panelTableau
			panelTableau.setModelTable( boutonDate.getDate(), donnees );
			
			// La date devient celle à lire dans les données
			
		} // if boutonDate
		
		
		// Le bouton cliqu� est un bouton
		
		// Boutons
		else if (evt.getSource() instanceof JButton){
			
			// bouton Atlantique
			if (evt.getSource() == panelListe.boutonAtlantique)
				panelListe.listeAlt();
			// bouton Atlantique
			if (evt.getSource() == panelListe.boutonManche)
				panelListe.listeManche();
			
		} // else boutons
		
		
		// On clique sur un port d'une liste
		
		else{
			
			JComboBox<String> nomsPortsListe = (JComboBox<String>) evt.getSource();
			
			Date date = new Date(); // Date d'aujourd'hui, à remplacer
									// par la date du calendrier
			
			for (int i = 0; i< NOMS_PORTS.length; i++) {
				if (NOMS_PORTS[i].compareTo((String) nomsPortsListe.getSelectedItem()) == 0) {
					LectureFichierTxt.lecture(ACCES_PORTS[i], date);
				}
			}
			
			panelTableau.setModelTable( date, donnees );

			
		}	// else liste
			


	}	// actionPerformed
	
} // class Controleur