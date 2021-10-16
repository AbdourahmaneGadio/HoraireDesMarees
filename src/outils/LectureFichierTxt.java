package outils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import modele.Date;
import modele.Donnees;
 
/**
 * Classe lisant le contenu d'un fichier
 * @author agadio
 *
 */
public class LectureFichierTxt {

	
	/**
	 * Lit les données d'un fichier, et compare les dates 
	 * contenues dans celui-ci, afin de prendre 
	 * uniquement les données correspondantes à la date
	 * 
	 * @param fichier Le fichier choisi par l'utilisateur
	 * @param parDate La date choisie par l'utilisateur
	 */
	public static void lecture (File fichier, Date parDate) {
		
		try { 
			
			BufferedReader buffer = new BufferedReader (
				new InputStreamReader ( new FileInputStream (fichier) ) );
			
				String ligneLue ; 
				
				int lignes = 1;
				int colonnes = 1;
				int dateValide = 0;
				
				while ((ligneLue = buffer.readLine()) != null) {
						
						StringTokenizer decoup = new StringTokenizer(ligneLue,"\t");
						
						while (decoup.hasMoreTokens()) {
							String token = decoup.nextToken();
							
							// Lorsqu'on atteint les données à afficher
							if (lignes >= 5) {
								
								// Lorsqu'on atteint la date
								
								// Si la date lue est celle choisi dans le calendrier
								if (colonnes == 1 && parDate.compareToLecture(token) == 0) {
									dateValide = 1;
								}
								
								// Si le calendrier est ouvert à un autre mois
								// que celui du fichier
								else
									if (colonnes == 1 && ( parDate.compareToLecture(token) == -2 
									|| parDate.compareToLecture(token) == 2) ) {
										parDate = parDate.StringToDate(token);
										dateValide = 1;
									}
									
								
								if (dateValide == 1) {
									// Heures
									// Lorsqu'on atteint les heures de PM
									if ( (colonnes == 2 || colonnes == 5)) {
										Donnees.setHeurePM(token, colonnes);
									} // heures de PM
									
									// Lorsqu'on atteint les heures de BM
									if (colonnes == 8 || colonnes == 10) {
										Donnees.setHeureBM(token, colonnes);
									} // heures de BM
									
									
									
									
									// Hauteurs
									
									// Lorsqu'on atteint les hauteurs
									if (colonnes == 3 || colonnes == 6 || colonnes == 9 || colonnes == 11) {
										Donnees.setHauteur(token, colonnes);
									} // hauteurs
	
									// Coef
									// Lorsqu'on atteint les coef (PM uniquement)
									if (colonnes == 4 || colonnes == 7) {	
										Donnees.setCoef(token, colonnes);
									} // coef (PM uniquement)
								
								} // if si date valide

								colonnes++;
								
								// Quand on fini de collecter les données d'une ligne
								// on passe à la ligne suivante
								if (colonnes == 12) {
									colonnes = 1;	// On réinitialise le placement de la colonne
									dateValide = 0; // Les dates suivantes ne sont plus valides
								}
								
								
								
							}	// if lignes avec données (à partir de la ligne 5)
	
						} // while pour afficher

						lignes++;	
						
						
				} // while pour chaque ligne	
				
		} // try
		
		catch (IOException parException) { 
				// Traitement de l�erreur 
		}	// catch
		
	}	// public static
}
