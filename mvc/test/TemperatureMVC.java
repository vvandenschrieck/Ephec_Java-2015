package mvc.test;
/**
 * @author <a href="mailto:gery.casiez@lifl.fr">Gery Casiez</a>
 * modified by vvds
 */

import mvc.controller.*;
import mvc.model.*;
import mvc.view.*;

public class TemperatureMVC {
	public TemperatureMVC() {
		//Création du modèle
		TemperatureModel tempmod = new TemperatureModel();
		//Création des contrôleurs : Un pour chaque vue
		//Chaque contrôleur doit avoir une référence vers le modèle pour pouvoir le commander
		TemperatureController tempcontrolC = new TemperatureController(tempmod);
		TemperatureController tempcontrolF = new TemperatureController(tempmod);
		TemperatureController tempcontrolConsole = new TemperatureController(tempmod);
		//Création des vues.
		//Chaque vue doit connaître son contrôleur et avoir une référence vers le modèle pour pouvoir l'observer
		TemperatureVueCelsius pvc = new TemperatureVueCelsius(tempmod, tempcontrolC, 100, 200);
		TemperatureVueFarenheit tvf = new TemperatureVueFarenheit(tempmod, tempcontrolF, 100, 350);
		TemperatureVueConsole console = new TemperatureVueConsole(tempmod, tempcontrolConsole);
		//On donne la référence à la vue pour chaque contrôleur
		tempcontrolC.addView(pvc);
		tempcontrolF.addView(tvf);	
		tempcontrolConsole.addView(console);
		
	}
	
	public static void main(String args[]) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TemperatureMVC();
			}
		});
	}
}
