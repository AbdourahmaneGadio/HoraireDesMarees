package constantes;

/**
 * Classe contenant les constantes a utiliser sur le calendrier (lundi, mardi ...; janvier, fevrier ...)
 * @author agadio
 *
 */

public interface ConstantesCalendrier {
	
	final String [] JOURS_SEMAINE = {"lundi","mardi","mercredi","jeudi","vendredi","samedi","dimanche"} ; 
	
	final String [] JOURS_SEMAINE_ABR = {"lu","ma","me","je","ve","sa","di"} ;  
	
	final  String [] MOIS = {"janvier", "fevrier","mars","avril","mai","juin","juillet", "aout","septembre","octobre","novembre","decembre"};
	
	final String INTIT_PREMIER = "<<";
	final String INTIT_PRECEDENT = "<";
	final String INTIT_SUIVANT = ">";
	final String INTIT_DERNIER = ">>";
	final  String [] INTITULES_BOUTONS = {INTIT_PREMIER,INTIT_PRECEDENT, INTIT_SUIVANT, INTIT_DERNIER};
	
	final String INTITULE_BOUTON_AJOUT ="+";
	
	public final  String [] HEURES = {"00", "01", "02", "03", "04", "05", "06",
		"07", "08", "09", "10", "11", "12", "13",
		"14", "15", "16", "17", "18", "19", "20",
		"21", "22", "23"};
	public final  String [] MINUTES = {"00", "15", "30", "45"};
	
	 
	
}
