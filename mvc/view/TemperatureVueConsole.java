package mvc.view;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import mvc.controller.TemperatureController;
import mvc.model.TemperatureModel;

public class TemperatureVueConsole extends TemperatureVue implements Observer {
	protected Scanner sc;
	
	public TemperatureVueConsole(TemperatureModel model,
			TemperatureController controller) {
		super(model, controller);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();	
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(model.getC());
		
	}
	public void enableWarning(){
		System.out.println("Alerte");
	}
	public void disableWarning(){
		
	}

	
	private class ReadInput implements Runnable{
		public void run() {
			while(true){
				int newCTemp = sc.nextInt();
				controller.fixeDegresC(newCTemp);
			}
		}
	}

}
