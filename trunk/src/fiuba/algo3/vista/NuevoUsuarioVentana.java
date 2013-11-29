package fiuba.algo3.vista;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import fiuba.algo3.controlador.ControlPorTeclado;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.Usuario;

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
    private Juego unJuego = new Juego();
    
    
    public NuevoUsuarioVentana() {   
    	
 
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
        texto = new JTextField(" Ingrese el Nombre Del Usuario       ");
        
        add(texto);
        add(botonAceptar);
        add(botonVolver);
        add(panelCampos);       
        
        botonAceptar.addActionListener(this);
        botonVolver.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
    	
    	
        if (e.getSource()== botonAceptar) {
        	dispose();
        	Usuario usuarioNuevo = new Usuario(texto.getText());
        	System.out.println(texto.getText());
        	
        	this.unJuego.agregarUsuario(usuarioNuevo);
        	this.unJuego.setUsuarioActual(usuarioNuevo);
        	Ventana unaVentana = new Ventana(this.unJuego, new ControlPorTeclado(this.unJuego.getNivelActual().getConductor()));
        	
        }
        if (e.getSource() == botonVolver){
        	setVisible(false);
        	VentanaInicial unaVentana = new VentanaInicial();
        	System.out.println(texto.getText());
        }
    }
}
