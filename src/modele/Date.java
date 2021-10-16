package modele;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import constantes.ConstantesCalendrier;

import java.util.Calendar;

/**
 * Classe g�n�rant la date
 * @author agadio
 *
 */

public class Date implements Comparable <Date>,ConstantesCalendrier {
  private int jour;
  private int mois;
  private int annee;
  private int jourSemaine ;
  
  /**
   * Le constructeur de la classe Date 
   */
  public Date ()   { 
	  GregorianCalendar dateAuj = new GregorianCalendar ();
	  annee = dateAuj.get (Calendar.YEAR);
	  mois = dateAuj.get (Calendar.MONTH) + 1; 
	  jour = dateAuj.get (Calendar.DAY_OF_MONTH);
	  jourSemaine = dateAuj.get (Calendar.DAY_OF_WEEK);
	  if (jourSemaine == 1)
		  jourSemaine = 7;
	  else jourSemaine -= 1; 
  }
  
  /**
   * Change la date, aux valeurs entrées
   * par l'utilisateur
   * @param parJour Le jour entré par l'utilisateur
   * @param parMois Le mois entré par l'utilisateur
   * @param parAnnee L'année entré par l'utilisateur
   */
  public Date (int parJour, int parMois, int parAnnee)   {   
	jour = parJour;
	mois = parMois;
	annee = parAnnee; 
	GregorianCalendar date = new GregorianCalendar (annee,mois-1,jour);
	jourSemaine = date.get (Calendar.DAY_OF_WEEK);		
	if (jourSemaine == 1)
		  jourSemaine = 7;
	else jourSemaine -= 1; 
  }
  
 
   
  /**
   * Retourne 0 si this et parDate sont �gales, 
   * -1 si this pr�c�de parDate,
   *  1 si parDate pr�c�de this
   *  @return int
   */
  public int compareTo (Date parDate) {
    if (annee < parDate.annee)
		return -3;
	if (annee > parDate.annee)
		return 3;
	// les ann�es sont =
	if (mois < parDate.mois)
		return -2;
	if (mois > parDate.mois)
		return 2;
	// les mois sont =
	if (jour < parDate.jour)
		return -1;
	if (jour > parDate.jour)
		return 1;
	return 0;	
  }
  
  /**
   * Retourne la date du lendemain
   * @return Date
   */
 
  public Date dateDuLendemain ()   {	
    if (jour < dernierJourDuMois(mois,annee))
		     return  new Date (jour+1,mois,annee);
		else if (mois < 12)
				return new Date (1,mois+1,annee);
			 else return new Date (1,1,annee+1);	
  }  
  
  
  /**
   * Retourne la date de la veille
   * @return Date
   */
  public Date dateDeLaVeille () {    
	if (jour > 1)
			return  new Date (jour-1,mois,annee);
	else if (mois > 1)
			   return new Date (Date.dernierJourDuMois(mois-1, annee),mois-1,annee);
		 else return  new Date (31,12,annee-1);
  }	 
  
  
/**
 * Retourne le dernier jour du mois donn� en param�tre
 * @param parMois Le mois entré par l'utilisateur
 * @param parAnnee L'année entré par l'utilisateur
 * @return int Le dernier jour du mois
 */
  
  public static int dernierJourDuMois (int parMois, int parAnnee) {
		switch (parMois) {
			 case 2 : if (estBissextile (parAnnee))  return 29 ; else return 28 ;  
			 case 4 : 	 case 6 : 	 case 9 : 	 case 11 : return 30 ;
			 default : return 31 ;
			}  // switch
	  } 
	
  /**
   * V�rifie si une ann�e est bissextile.
   * Retourne 0 si elle l'est, 
   * 1 dans le cas contraire.
   * @return boolean
   */
  private static boolean estBissextile(int parAnnee) {
			return parAnnee % 4 == 0 && (parAnnee % 100 != 0 || parAnnee % 400 == 0);
	  }
 
  /**
   * Retourne la date sous le format jourSemaine jj mm
   */
  public String toString () {
    return  JOURS_SEMAINE [jourSemaine -1] + " " + jour + " " + MOIS [mois-1];	  
  }  

  	
  /**
   * Retourne l'ann�e
   * @return int
   */
	public int getAnnee() { 
		return annee;
	}

	/**
	 * Retourne le jour
	 * @return int
	 */	
	public int getJour() { 
		return jour;
	}
	
	/**
	 * Retourne le mois
	 * @return int
	 */	
	public int getMois() { 
		return mois;
	}
	
	/**
	 * Retourne le jour de la semaine
	 * @return int
	 */	
	public int getJourSemaine () {
		return jourSemaine;
	}
	
	/**
	 * V�rifie si la date est celle d'aujourd'hui
	 * @return Date
	 */	
	public boolean isToday() {
		return new Date().compareTo(this) == 0;
	}
	
	
	/**
	 * Retourne la date du lundi de la semaine
	 * @return Date
	 */

	public Date datePremierJourSemaine() {
		Date date = this;
		
		// Tant qu'on est pas lundi
		while(date.getJourSemaine()!=1)
			date = date.dateDeLaVeille();
		return date;
	}
	  
	  /**
	   * Retourne la date sous le format lun. jour
	   * @return String
	   */
	  public String abrToString () {
		    return  JOURS_SEMAINE_ABR [jourSemaine -1] + " " + jour;	  
	  }  
	  
  
	  /**
	   * Convertit la date lue dans les données (String)
	   * en objet de classe Date
	   * @param parDateDonnees
	   * @return Date La date lue dans les données
	   */
	  public Date StringToDate(String parDateDonnees) {

			StringTokenizer tokenizer = new StringTokenizer(parDateDonnees, "/-");
			
			String annee = tokenizer.nextToken();
			String mois = tokenizer.nextToken();
			String jour = tokenizer.nextToken();
			
			int evtJour = Integer.parseInt(jour);
			int evtMois = Integer.parseInt(mois);
			int evtAnnee = Integer.parseInt(annee);
			
			Date dateDonnees = new Date(evtJour, evtMois, evtAnnee);
			
			return dateDonnees;
				  
		  
	  }
	  
	  /**
	   * Compare si la date lue dans les données est 
	   * celle choisi dans le calendrier
	   * @param parDateDonnees La date contenue dans les données
	   * @return un booléen
	   */
	  public int compareToLecture(String parDateDonnees) {

		  	Date dateDonnees = this.StringToDate(parDateDonnees);
			
			return this.compareTo(dateDonnees);
				  
		  
	  }
	  
	
}  // class Date