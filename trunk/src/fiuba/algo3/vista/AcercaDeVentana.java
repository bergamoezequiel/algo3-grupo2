package fiuba.algo3.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class AcercaDeVentana extends JFrame {
		        
	private static final long serialVersionUID = -4679695047650909454L;

	public AcercaDeVentana(){
		setLocation(500, 200);
		this.setVisible(false);                 
		this.setTitle("Acerca de..");
		this.setSize(220,250);
		this.setResizable(false);
		                        
		String str = "<html><div style='text-align: center;'>"
				+ "<b><u>Algoritmos y Programacion III 2013 </b></u><br>"
				+ "<br>"
				+ "<br>"
				+ " DiPietro, Mauro<br>"
				+ " Castro Pippo, Juan Manuel<br>"
				+ " Bergamo, Ezequiel<br>"
				+ " Ruiz Echazu, Manuel<br>"   
				+ "<br>"
				+ "<br>"
				+ "<div style='text-align: left;'>"
				+ " ® GPS Challenge v1.1<br>"		
				+ "</html></div>";
		
		JLabel texto= new JLabel(str);

		texto.setLocation(100,100);
		texto.setSize(450,150);
		this.add(texto);
		}
	
}