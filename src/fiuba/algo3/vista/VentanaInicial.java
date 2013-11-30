package fiuba.algo3.vista;

import javax.swing.*;

import fiuba.algo3.controlador.ControlPorTeclado;
import fiuba.algo3.modelo.Juego;

import java.awt.event.*;

public class VentanaInicial extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton botonNuevo;
	JButton botonExisto;    
    
    public VentanaInicial() {    	
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setBounds(300,100, 400,400);
        
        setTitle("GPS Challenge");
        botonNuevo = new JButton("Nuevo Usuario");
        botonExisto = new JButton ("Ya tengo un Usuario");
        
        botonNuevo.setBounds(100,100,200,30);
        botonExisto.setBounds(100,200,200,30);
        
        add(botonNuevo);
        add(botonExisto);
        
        botonNuevo.addActionListener(this);
        botonExisto.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== botonNuevo) {
        	dispose();
        	NuevoUsuarioVentana unaVentana = new NuevoUsuarioVentana();
        }
        if (e.getSource() == botonExisto){
        	setVisible(false);
        }
    }
    
    public static void main(String[] ar) {
        VentanaInicial formulario1 = new VentanaInicial();
    }
}