package fiuba.algo3.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class BotonSalirListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().compareTo("Salir")==0) System.exit(0);

	}
}
