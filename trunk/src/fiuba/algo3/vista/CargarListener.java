package fiuba.algo3.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CargarListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().compareTo("Cargar")==0){
			JFrame unaVentana = new CargarVentana();
			unaVentana.setVisible(true);
			unaVentana.setAlwaysOnTop(true);
		}		
		
	}


}
