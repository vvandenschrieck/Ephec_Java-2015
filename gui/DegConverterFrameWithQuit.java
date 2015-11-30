package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class DegConverterFrameWithQuit extends JFrame {
	private JFormattedTextField degres;
    private JLabel fahrenheit;
    private JButton quit;
    private JButton convert;
    
	public DegConverterFrameWithQuit()
    {
        // Appel du constructeur parent
        super ("Convertisseur °C -> °F");
 
        // Paramétrisation de la fenêtre
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize (250, 100);
 
        // Première partie
        JLabel dlabel = new JLabel ("Température en degrés : ");
        degres = new JFormattedTextField (NumberFormat.getInstance());
 
        Box bdegres = Box.createHorizontalBox();
        bdegres.add (dlabel);
        bdegres.add (degres);
 
        // Seconde partie
        JLabel flabel = new JLabel ("Température en fahrenheit : ");
        fahrenheit = new JLabel();
 
        Box bfahrenheit = Box.createHorizontalBox();
        bfahrenheit.add (flabel);
        bfahrenheit.add (fahrenheit);
 
        // Troisième partie
        convert = new JButton ("Convertir");
        convert.addActionListener(new MyListener());
        
        quit = new JButton ("Quitter");
        quit.addActionListener(new MyListener());
 
        Box bcontrol = Box.createHorizontalBox();
        bcontrol.add(convert);
        bcontrol.add(quit);
 
        // La boite principale
        Box main = Box.createVerticalBox();
        main.add (bdegres);
        main.add (bfahrenheit);
        main.add (bcontrol);
 
        // On place la boite principale sur la fenêtre
        getContentPane().add (main);
    }
	private class MyListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
        		if(event.getSource()==convert){
        			double deg = Double.valueOf (degres.getText());
        			double fah = deg * (9.0 / 5) + 32;
        			fahrenheit.setText (String.valueOf (fah));
        		}
        		if(event.getSource()==quit){
        			System.out.println("Exit pressed");
        			System.exit(0);
        		}
        }
    }
	public static void main(String[]args){
		DegConverterFrameWithQuit f = new DegConverterFrameWithQuit();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible (true);
		
	}
}
