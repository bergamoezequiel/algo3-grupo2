package fiuba.algo3.vista;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import fiuba.algo3.controlador.ControlPorTeclado;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.Usuario;
import fiuba.algo3.modelo.vehiculos.Moto;

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
	
	public NuevoUsuarioVentana(Juego unJuego) {   
		this.juego = unJuego;
		getContentPane().setLayout(new FlowLayout());
		setVisible(true);
		setBounds(400,250, 400,400);
		setTitle("GPS Challenge");
		setVisible(true);
		setSize(220,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		botonAceptar = new JButton("Aceptar");
		botonVolver = new JButton("Volver");
		
		panelCampos = new JPanel();
		texto = new JTextField("Ingrese el Nombre Del Usuario");
		
		add(texto);
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
			
			//this.juego.agregarUsuario(usuarioNuevo);
			//this.juego.setUsuarioActual(usuarioNuevo);
			/*
			 * Deberia poder elegirse la instancia de vehiculo con la que se arranca.
			 */
			this.juego.iniciarPartida(usuarioNuevo, Moto.getInstancia());
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
