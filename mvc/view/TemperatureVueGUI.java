/**
 * @author <a href="mailto:gery.casiez@lifl.fr">Gery Casiez</a>
 */

package mvc.view;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import mvc.controller.*;
import mvc.model.*;

public abstract class TemperatureVueGUI extends TemperatureVue {

	private JFrame temperatureJFrame;
	private JTextField display = new JTextField();
	private JButton upJButton = new JButton("+");
	private JButton downJButton = new JButton("-");

	TemperatureVueGUI(String label, TemperatureModel model,
			TemperatureController controller, int posX, int posY) {
		super(model, controller);
		
		//Construction de la fenêtre
		temperatureJFrame = new JFrame(label);
		temperatureJFrame.add(new JLabel(label), BorderLayout.NORTH);
		temperatureJFrame.add(display, BorderLayout.CENTER);
		JPanel panelbuttons = new JPanel();
		panelbuttons.add(downJButton);
		panelbuttons.add(upJButton);
		temperatureJFrame.add(panelbuttons, BorderLayout.SOUTH);
		temperatureJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		temperatureJFrame.setSize(200,100);
		temperatureJFrame.setLocation(posX, posY);
		temperatureJFrame.setVisible(true);
	}

	public void setDisplay(String s) {
		display.setText(s);
	}

	public void enableWarning() {
		display.setBackground(Color.RED);
	}

	public void disableWarning() {
		display.setBackground(Color.WHITE);
	}

	public double getDisplay() {
		double result = 0.0;
		try {
			result = Double.valueOf(display.getText()).doubleValue();
		}
		catch (NumberFormatException e){}
		return result;
	}

	public void addDisplayListener(ActionListener a){ display.addActionListener(a);}
	public void addUpListener(ActionListener a){ upJButton.addActionListener(a);}
	public void addDownListener(ActionListener a){ downJButton.addActionListener(a);}

	protected TemperatureModel model(){
		return model;
	}
}
