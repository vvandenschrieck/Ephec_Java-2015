/**
 * @author <a href="mailto:gery.casiez@lifl.fr">Gery Casiez</a>
 */

package mvc.view;

import java.util.Observable;
import java.awt.event.*;

import mvc.controller.*;
import mvc.model.*;

public class TemperatureVueCelsius extends TemperatureVueGUI {
	
	public TemperatureVueCelsius(TemperatureModel modele,
			TemperatureController controleur, int posX, int posY) {
		super("Temperature Celsius",modele, controleur, posX, posY);
		setDisplay(""+model.getC());
		addUpListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.augmenteDegresC(); 
			}});
		addDownListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.diminueDegresC();
			}});
		addDisplayListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tempC = getDisplay();
				controller.fixeDegresC(tempC);
			}});
	}

	public void update(Observable s, Object o) {
		setDisplay(""+model().getC());
	}
}
