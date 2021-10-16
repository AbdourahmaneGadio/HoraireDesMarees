package vue;

import javax.swing.JButton;
import modele.Date;

/**
 * Classe representant les boutons
 * contenant des dates dans le calendrier
 * @author agadio
 *
 */
public class BoutonDate extends JButton {

	private Date date;
	
	public BoutonDate(Date date) {
		super (Integer.toString(date.getJour()));
		this.date= date;
	}
	
	/**
	 * Retourne la date
	 * @return Date
	 */
	public Date getDate() {		 
		return date;
	}

}
