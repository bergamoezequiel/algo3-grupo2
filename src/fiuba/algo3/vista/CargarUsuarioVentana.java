package fiuba.algo3.vista;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.modelo.Juego;

public class CargarUsuarioVentana extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton botonAceptar, botonVolver;
	private JPanel panelCampos;
	private Choice desplegable;
	private Choice desplegableVehiculo;

	public CargarUsuarioVentana(Juego unJuego){				  
		getContentPane().setLayout(new FlowLayout());
		setBounds(400,250, 400,400);
		setTitle("Cargar");
		setVisible(true);
		setSize(240,140); 
				
		botonAceptar = new JButton("Aceptar");
		botonVolver = new JButton("Volver");
				
		panelCampos = new JPanel();
		desplegable = new Choice();
		
		/*
		 * Aca se irian agreando los Nombres de los usuarios con un For. 
		 */
		
		desplegable.add("Seleccione su Usuario.");
		desplegable.add("Usuario 1");
		desplegable.add("Usuario 2");
		desplegable.add("Usuario 3");
		
		desplegableVehiculo = new Choice();
		desplegableVehiculo.add("Seleccione un Vehiculo ...");
		desplegableVehiculo.add("Auto");
		desplegableVehiculo.add("Moto");
		desplegableVehiculo.add("TodoTerreno");
				
		add(desplegable);
		add(desplegableVehiculo);
		add(botonAceptar);
		add(botonVolver);
		add(panelCampos);	   
				
		botonAceptar.addActionListener(this);
		botonVolver.addActionListener(this);
	}
			
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()== botonAceptar) {
		/*
		 * Aca iria lo que pasa cuando se pone aceptar.
		 */
			//this.juego.iniciarPartida(unUsuario, tipoDeVehiculo);
			dispose();	
		}
		if (e.getSource() == botonVolver){
			dispose();
		}
	}
	
}