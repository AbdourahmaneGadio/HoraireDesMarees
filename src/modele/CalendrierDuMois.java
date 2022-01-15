package modele;
import java.util.TreeSet;
import java.util.Collection;

/**
 * Classe comprenant le calendrier du mois
 * @author agadio
 *
 */
public class CalendrierDuMois {	
  
  private Collection <Date> treeSetDate;	  
  
  /**
   * Le constructeur de la classe CalendrierDuMois
   * @param mois Le mois sélectioné
   * @param annee L'année sélectionée
   */
  public CalendrierDuMois ( int mois, int annee) {			   
	    treeSetDate = new TreeSet <Date> ();
	    Date date = new Date (1,mois,annee);
	    int indiceJour = date.getJourSemaine() ;
	    for (int x = indiceJour ; x!=0 ; x--) {	    	 
	    	treeSetDate.add(date);	    	
	    	date = date.dateDeLaVeille();
	    }	    
	    date = new Date (2,mois,annee);
	    indiceJour = indiceJour % 7 ;
	    while (date.getMois () == mois) {
	      while(indiceJour<7) {
	    	treeSetDate.add(date);
	    	date = date.dateDuLendemain();
	    	indiceJour++ ;
	      } 
	      indiceJour=0;
	    }    
	  }

/**
 * Retourne la collection de dates  
 * @return Collection La collection de dates
 */
public Collection <Date> getDates() {	
	return treeSetDate;	
}	

/**
 * Retourne le string de la collection
 */
public String toString () {
	return treeSetDate.toString();
}
    
}