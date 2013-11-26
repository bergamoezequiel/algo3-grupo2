package fiuba.algo3.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class AcercaDeVentana extends JFrame {
		        
	private static final long serialVersionUID = -4679695047650909454L;

	public AcercaDeVentana(){
		setLocation(500, 200);
		this.setVisible(false);                 
		this.setTitle("Acerda de..");
		this.setSize(300,100);
		                        
		JLabel texto= new JLabel("Algoritmos y Programacion III , 2013.");

		texto.setLocation(100,100);
		texto.setSize(450,150);
		this.add(texto);
		}
	
}