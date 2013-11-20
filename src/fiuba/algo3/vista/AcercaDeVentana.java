package fiuba.algo3.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AcercaDeVentana extends JFrame {
		        
     /*
	 *   No se que es esta yerba pero si no se le agrega tira warning.
	 */
	private static final long serialVersionUID = 6576317272840853636L;

		public AcercaDeVentana(){
			setLocation(500, 100);
			this.setVisible(false);                 
			this.setTitle("Acerda de..");
			this.setSize(300,300);
			//this.setLocationRelativeTo(null);
	                        
			JLabel texto= new JLabel("Algoritmos y Programacion III , 2013."
					+ "\n Integrantes: Juan Manuel Castro Pippo"
					+         "\n   Manuel Ruiz Echazu"
					+            "\n Mauro 'La Putita' DiPietro"
					+	     "\n   Ezequiel 'El Fantasma' Bergamo.  		");
	                       
			//texto.setHorizontalAlignment(SwingConstants.CENTER);
            //texto.setHorizontalTextPosition(SwingConstants.CENTER);
            texto.setLocation(-10,100);
            texto.setSize(450,150);
            this.add(texto);              
               
	                           
        }
	
}