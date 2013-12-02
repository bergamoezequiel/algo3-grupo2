package fiuba.algo3.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class GuardarListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().compareTo("Guardar")==0){
			JFrame unaVentana = new GuardarVentana();
			unaVentana.setVisible(true);
			unaVentana.setAlwaysOnTop(true);
		}		
		
	}


}
