package cookies.gui;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import cookies.controleur.CookieGUIControleur;
import cookies.magasin.MagasinCookies;

public class MagasinFrame extends JFrame  {
	PanelVente panelVente;
	PanelStock panelStock;
	PanelComptes panelCompte;
	public MagasinFrame(MagasinCookies m, CookieGUIControleur ctrl ) {
		super(m.getNom());
	    
		// Parametrisation de la fenetre
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize (500, 600);
 
       
        
        panelVente = new PanelVente(m, ctrl);
        panelStock = new PanelStock(m, ctrl);
        panelCompte = new PanelComptes(m, ctrl);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Vente", panelVente);
        tabbedPane.addTab("Stock", panelStock);
        tabbedPane.addTab("Comptes", panelCompte);
 
        // On place la boite principale sur la fenetre
        getContentPane().add(tabbedPane);
        setVisible(true);
	}

	public PanelVente getPanelVente() {
		return panelVente;
	}
	
}
