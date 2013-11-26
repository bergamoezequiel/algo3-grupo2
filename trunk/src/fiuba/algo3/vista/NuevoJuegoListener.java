package fiuba.algo3.vista;

//import javax.swing.JFrame;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import fiuba.algo3.modelo.Juego;

public class NuevoJuegoListener implements MenuListener{

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
		Juego unJuego = new Juego();
	}
	

}
