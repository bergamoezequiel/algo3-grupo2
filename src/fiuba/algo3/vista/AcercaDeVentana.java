package fiuba.algo3.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class AcercaDeVentana extends JFrame {
		        
     /*
	 *   No se que es esta yerba pero si no se le agrega tira warning.
	 */
	private static final long serialVersionUID = 1L;

		public AcercaDeVentana(){
			setLocation(500, 200);
			this.setVisible(false);                 
			this.setTitle("Acerda de..");
			this.setSize(300,100);
			
	                        
			JLabel texto= new JLabel("          Algoritmos y Programacion III , 2013.");

            texto.setLocation(100,100);
            texto.setSize(450,150);
            this.add(texto);              
               
	                           
        }
	
}