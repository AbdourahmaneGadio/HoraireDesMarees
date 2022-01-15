package vue;



import javax.swing.table.DefaultTableModel;

import constantes.ConstantesCalendrier;
import modele.*;

/**
 * Classe contenant la structure du tableau
 * @author agadio
 *
 */
public class ModeleTable extends DefaultTableModel implements ConstantesCalendrier{
	
	String [] nomsColonnes = new String[4];	// Tableau contenant les intitul�s
	Date today;
	
	
/**
 * Prend en param�tre la date, et les données, 
 * puis cr�e un tableau contenant toutes les données des marées
 * @param parDate La date choisie par l'utilisateur
 * @param parDonnees Les donnees choisies
 */
	public ModeleTable(Date parDate, Donnees parDonnees){
		
		today = parDate;	// On met la date, au lundi de la semaine

		this.setColumnCount(4);	// nb de colonnes
		this.setRowCount(5);	// nb de lignes

		// Intitulés
		for (int i = 0; i < getColumnCount(); i++){
			
			// La date
			if (i == 0)
				nomsColonnes[i] = today.toString();	
			else
				nomsColonnes[i] = "";	
			
		}
		
		// Valeurs
		
		// Heures
		setValueAt("Heure", 0, 1);
		
		setValueAt("PM", 1, 0);
		setValueAt("BM", 2, 0);
		setValueAt("PM", 3, 0);
		setValueAt("BM", 4, 0);
		
		// PM
		for (int i = 1; i < 5; i++){
			setValueAt(parDonnees.getHeurePM(i), i, 1);
			i++;
		}
		
		// BM
		for (int i = 2; i < 5; i++){
			setValueAt(parDonnees.getHeureBM(i), i, 1);
			i++;
		}
		
		
		
		// Hauteurs
		setValueAt("Hauteur", 0, 2);

		for (int i = 1; i < 5; i++){
			setValueAt(parDonnees.getHauteur(i), i, 2);
		}
		
		
		
		// Coefficients
		setValueAt("Coefficient", 0, 3);

		for (int i = 1; i < 5; i++){
			setValueAt(parDonnees.getCoef(i), i, 3);
			i++;
		}
		
		setColumnIdentifiers(nomsColonnes);
	
		
	}	//constructeur

}	// class ModeleTable
