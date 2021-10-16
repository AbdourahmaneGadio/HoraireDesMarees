package modele;

/**
 * La classe contenant les données des marées
 * sous forme lisible par le panelTableau
 * @author rebornbeing
 *
 */
public class Donnees {
    
    private static String [] heurePM;
    private static String [] heureBM;
    private static String [] hauteurEau;
    private static String [] coef;
    
    /**
     * Constructeur de la classe Donnees
     */
	public Donnees() {
    	
    	heurePM  = new String[2];
    	heureBM = new String[2];
    	hauteurEau = new String[4];
    	coef = new String[2];
    }

    

    /**
     * Met l'heure de basse mer,
     * à celle recu en paramètre
     * @param parChHeure L'heure de basse mer reçu en paramètre
     * @param nbColonne Le n° de colonnes atteint dans les données
     */
    public static void setHeureBM(String parChHeure, int nbColonne) {
    	
    	if (nbColonne == 8)
    		nbColonne = 0;
    	else
    		nbColonne = 1;
    	if (parChHeure.compareTo("--.--") == 0)
    		heureBM[nbColonne] = "--.--";
    	else
    		heureBM[nbColonne] = parChHeure;
    	
    }    // setHeureBM()
    
    
    /**
     * Recupere l'heure de basse mer
     * @param nbColonnesTableau La colonne dans le ModeleTable
     * @return String L'heure
     */
    public String getHeureBM(int nbColonnesTableau) {
    	
    	if (nbColonnesTableau == 2)
    		nbColonnesTableau = 0;
    	else
    		nbColonnesTableau = 1;
    	return heureBM[nbColonnesTableau];   
    	
    }    // getHeureBM()
    
    
    
    /**
     * Met l'heure de pleine mer,
     * à celle recu en paramètre
     * @param parChHeure L'heure de pleine mer recu en paramètre
     * @param nbColonne La colonne où se trouve l'heure
     * de pleine mer dans les données
     */
    public static void setHeurePM(String parChHeure, int nbColonne) {
    	if (nbColonne == 2)
    		nbColonne = 0;
    	else
    		nbColonne = 1;
    	
        heurePM[nbColonne] = parChHeure;
    }    // setHeurePM()
    
    /**
     * Recupere l'heure de pleine mer
     * @param nbColonnesTableau La colonne dans le ModeleTable
     * @return L'heure de pleine mer
     */
    public String getHeurePM(int nbColonnesTableau) {
    	if (nbColonnesTableau == 1)
    		nbColonnesTableau = 0;
    	else
    		nbColonnesTableau = 1;
    	return heurePM[nbColonnesTableau];        
    }    // getHeurePM()


    
    /**
     * Transmet la hauteur, à celle reçu en paramètre
     * @param parChHauteurEau La hauteur dans les données
     * @param nbColonne La colonne où se trouve la hauteur dans les données
     */
    public static void setHauteur(String parChHauteurEau, int nbColonne) {
    	
    	// Attribue une valeur au tableau de string, en fonction
    	// de la colonne lue dans le fichier
    	if (nbColonne == 3)
    		nbColonne = 0;
    	else 
        	if (nbColonne == 6)
        		nbColonne = 1;
        	else
        	if (nbColonne == 9)
        		nbColonne = 2;
        		else
        			nbColonne = 3;
        		
    		
    	// Si pas d'hauteur
    	if (parChHauteurEau.compareTo("--.--") == 0)
    		hauteurEau[nbColonne] = "--.--";
    	else
    		hauteurEau[nbColonne] = parChHauteurEau;
    	
    }    // setHauteur()
    
    /**
     * Recupere la hauteur de la mer
     * @param nbColonnesTableau La colonne dans le ModeleTable
     * @return La hauteur d'eau
     */
    public String getHauteur(int nbColonnesTableau) {
    	return hauteurEau[nbColonnesTableau - 1];       
    }    // getHauteur()
    
    
    
    /**
     * Met le coefficient, à celle
     * recu en parametre
     * @param parChCoef Le coefficient reçu en paramètre, @param nbColonne La position de la colonne
     * @param nbColonne La colonne où se trouve le coef dans les données
     * dans LectureFichierTxt
     */
    public static void setCoef(String parChCoef, int nbColonne) {
    	
      	if (nbColonne == 4)
    		nbColonne = 0;
    	else
    		nbColonne = 1;
      	
    	if (parChCoef.compareTo("---") == 0)
    		coef[nbColonne] = "---";
    	else
    		coef[nbColonne] = parChCoef;
    	
    }    // setCoef()
    
    /**
     * Récupère le coefficient
     * @param nbColonnesTableau La position dans le ModeleTable
     * @return Le coefficient à l'indice souhaité
     */
    public String getCoef(int nbColonnesTableau) {
    	
    	if (nbColonnesTableau == 1)
    		nbColonnesTableau = 0;
    	else
    		nbColonnesTableau = 1;

        return coef[nbColonnesTableau];    
    }    // getCoef()
    
    
    

}    // class Donnees
