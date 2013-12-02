package fiuba.algo3.vista;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fiuba.algo3.controlador.ControlPorTeclado;
import fiuba.algo3.modelo.Usuario;

public class GuardarVentana extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JButton botonAceptar, botonVolver;
    private JPanel panelCampos;
    private JTextField texto;

	public GuardarVentana(){                  
		    	
		getContentPane().setLayout(new FlowLayout());
		setVisible(true);
		setBounds(400,250, 400,400);
		setTitle("Guardar");
		setVisible(true);
		setSize(220,100); 
		        
		botonAceptar = new JButton("Aceptar");
		botonVolver = new JButton("Volver");
		        
		panelCampos = new JPanel();
		texto = new JTextField("Ingrese el nombre del archivo.");
		        
		add(texto);
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
		        	
		        	dispose();
		        	
		        }
		        if (e.getSource() == botonVolver){
		        	setVisible(false);
		        }
		    }
}