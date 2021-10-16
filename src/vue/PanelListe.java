package vue;


import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constantes.*;
import controleur.Controleur;

/**
 * Classe représentant le choix des listes
 * Atlantique, ou bien Manche
 * @author agadio
 *
 */
public class PanelListe extends JLabel implements ConstantesCouleursFontes{
	
	final static File REPERTOIRE_PORTS = new File("mes_ports");
	final static String [] NOMS_PORTS = REPERTOIRE_PORTS.list();
	
	private JLabel labelChoixPort = new JLabel ("Choix du Port : ");
	
	private JLabel labelChoixType = new JLabel ("Choississez le type : ");
	public JButton boutonAtlantique = new JButton ("Atlantique");
	public JButton boutonManche = new JButton ("Manche");
	
	private JLabel labelChoixListe = new JLabel ("Choisissez parmi la liste : ");
	public JComboBox<String> nomsPortsAlt = new JComboBox<String>();
	public JComboBox<String> nomsPortsMan = new JComboBox<String>();
	
	JPanel panelListePorts = new JPanel();
	
	// Instanciation d'un objet de la classe CardLayout
	CardLayout gestListe = new CardLayout (5,5);
	
	/**
	 * Le constructeur de la classe PanelListe
	 */
	public PanelListe() {
		
		 for (int i = 0; i< 2; i++) {
	         String filename = NOMS_PORTS[i];
	         nomsPortsAlt.addItem(filename);
	      }	
		 
		 for (int i = 2; i< 4; i++) {
	         String filename = NOMS_PORTS[i];
	         nomsPortsMan.addItem(filename);
	      }
			
			// Le gestionnaire de repartition
			setLayout (new GridBagLayout ());	
			GridBagConstraints contraintes = new GridBagConstraints ();
		  	contraintes.insets = new Insets (0,0,20,0); 
			contraintes.anchor = GridBagConstraints.WEST;
			
			// ChoixPort
			contraintes.gridy=0; contraintes.gridwidth = 4;	contraintes.gridx=0;
			this.add(labelChoixPort, contraintes);
			
			// ChoixType
			contraintes.gridy++;
			this.add(labelChoixType, contraintes);
			
			// boutonAtlantique
			contraintes.gridx+=10;
			this.add(boutonAtlantique, contraintes);
			
			// boutonManche
			contraintes.gridx+=5;
			this.add(boutonManche, contraintes);
			
			// ChoixListe
			contraintes.gridx=0;
			contraintes.gridy++;
			this.add(labelChoixListe, contraintes);
			
			// nomsPorts
			contraintes.gridx+=10;
			
			panelListePorts.setLayout(gestListe);
			
			panelListePorts.add(nomsPortsAlt);
			panelListePorts.add(nomsPortsMan);
			this.add(panelListePorts, contraintes);
			
			
			
			
			// Police d'écriture
			
			labelChoixPort.setFont(FONT_14);
			
			labelChoixType.setFont(FONT_11);
			
			labelChoixListe.setFont(FONT_11);
			
			
			setPreferredSize(new Dimension (600,800));
		
	}	// panelListe()
	
	
	/**
	 * Met le controleur a l'ecoute des boutons et des listes
	 * @param controleur Le controleur
	 */
	public void enregistreEcouteur(Controleur controleur) {
		
		// Les boutons sont à l'écoute
		boutonAtlantique.addActionListener(controleur);
		boutonManche.addActionListener(controleur);
		
		// Les listes sont à l'écoute
		nomsPortsAlt.addActionListener(controleur);
		nomsPortsMan.addActionListener(controleur);
		
		
	}
	
	/**
	 * Change la liste de l'application
	 * en liste Atlantique
	 */
	public void listeAlt() {
		gestListe.first(panelListePorts);
	}
	
	/**
	 * Change la liste de l'application
	 * en liste Manche
	 */
	public void listeManche() {
		gestListe.last(panelListePorts);
	}


	

}	// class PanelListe
