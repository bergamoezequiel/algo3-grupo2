package fiuba.algo3.controlador;

import java.awt.event.*;

import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.vehiculos.Conductor;

public class ControlPorTeclado {

	private Conductor conductor;

	public ControlPorTeclado(Conductor unConductor) {
		this.conductor = unConductor;
	}
	
	public KeyListener getKeyListener(){
		return new KeyListener() {
			public void keyPressed(KeyEvent e) {  	    
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int location = e.getKeyCode();

				switch(location){
					case KeyEvent.VK_DOWN:
						conductor.avanzarEnDireccion(new Abajo());
						System.out.println("Abajo");

					case KeyEvent.VK_UP:
						conductor.avanzarEnDireccion(new Arriba());
						System.out.println("Arriba");

					case KeyEvent.VK_LEFT:
						conductor.avanzarEnDireccion(new Izquierda());
						System.out.println("Izquierda");

					case KeyEvent.VK_RIGHT:
						conductor.avanzarEnDireccion(new Derecha());
						System.out.println("Derecha");
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {				
			}	
		};
	}
}
