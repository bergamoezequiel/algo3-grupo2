package fiuba.algo3.vista;

import javax.swing.*;
import javax.swing.text.JTextComponent;


import fiuba.algo3.controlador.ControlPorTeclado;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.Usuario;
import fiuba.algo3.modelo.vehiculos.*;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.*;
public class NuevoUsuarioVentana extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame f;
	private JButton botonAceptar, botonVolver;
	private JPanel panelCampos;
	private JTextField texto;
	private Juego juego;
	private Choice desplegable;
	
	public NuevoUsuarioVentana(Juego unJuego) {   
		this.juego = unJuego;
		getContentPane().setLayout(new FlowLayout());
		setVisible(true);
		setBounds(400,250, 400,400);
		setTitle("Crear Nuevo Usuario");
		setVisible(true);
		setSize(360,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		botonAceptar = new JButton("Aceptar");
		botonVolver = new JButton("Volver");
		
		panelCampos = new JPanel();
		texto = new JTextField("Ingrese el Nombre Del Usuario");
		
		desplegable = new Choice();
		desplegable.add("Moto");
		desplegable.add("Auto");
		desplegable.add("TodoTerreno");

		
		
		add(texto);
		add(desplegable);
		add(botonAceptar);
		add(botonVolver);
		add(panelCampos);
		
		
		botonAceptar.addActionListener(this);
		botonVolver.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource()== botonAceptar) {
			Usuario usuarioNuevo = new Usuario(texto.getText());
			System.out.println(texto.getText());
			System.out.println(desplegable.getSelectedItem());
			
			//this.juego.agregarUsuario(usuarioNuevo);
			//this.juego.setUsuarioActual(usuarioNuevo);
			/*
			 * Si el usuario es idiota y elige "seleccione un vehiculo" como vehiculo
			 * se le asigna una moto.
			 */
			switch (desplegable.getSelectedIndex()) {
			case 0:
				this.juego.iniciarPartida(usuarioNuevo, Moto.getInstancia());
				break;
			case 1:
				this.juego.iniciarPartida(usuarioNuevo, Auto.getInstancia());
				break;

			default:
				this.juego.iniciarPartida(usuarioNuevo, TodoTerreno.getInstancia());
				break;
			}
			
			Ventana unaVentana = new Ventana(this.juego, new ControlPorTeclado(this.juego));
			this.juego.addObserver(unaVentana);
			
			dispose();
			
		}
		if (e.getSource() == botonVolver){
			setVisible(false);
			new VentanaInicial(this.juego);
			System.out.println(texto.getText());
		}
	}
}
