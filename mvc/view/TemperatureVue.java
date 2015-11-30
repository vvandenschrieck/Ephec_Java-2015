package mvc.view;

import java.util.Observer;

import mvc.controller.TemperatureController;
import mvc.model.TemperatureModel;

public abstract class TemperatureVue implements Observer{
	
	protected TemperatureModel model;
	protected TemperatureController controller;
	
	TemperatureVue(TemperatureModel model,
			TemperatureController controller) {
		this.model = model;
		this.controller = controller;
		model.addObserver(this); // Connexion entre la vue et le modele
	}

	public abstract void enableWarning() ;

	public abstract void disableWarning() ;


	

}
