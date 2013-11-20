package fiuba.algo3.vista;

import javax.swing.JFrame;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class AcerdaDeListener implements MenuListener{

	@Override
	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuSelected(MenuEvent arg0) {
		JFrame unaVentana = new AcercaDeVentana();
		unaVentana.setVisible(true);
		unaVentana.setAlwaysOnTop(true);	
	}
	

}
