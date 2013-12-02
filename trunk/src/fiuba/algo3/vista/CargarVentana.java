package fiuba.algo3.vista;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CargarVentana extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JButton botonAceptar, botonVolver;
    private JPanel panelCampos;
    private Choice desplegable;

	public CargarVentana(){                  
		    	
		getContentPane().setLayout(new FlowLayout());
		setBounds(400,250, 400,400);
		setTitle("Cargar");
		setVisible(true);
		setSize(220,100); 
		        
		botonAceptar = new JButton("Aceptar");
		botonVolver = new JButton("Volver");
		        
		panelCampos = new JPanel();
		desplegable = new Choice();
		
		/*
		 * Aca se irian agreando los archivos ? 
		 * Sino, que el usuario ponga el nombre completo del archivo con su ruta.
		 */
		
		desplegable.add("Seleccione el Archivo");
		desplegable.add("Usuario 1");
		desplegable.add("Usuario 2");
		desplegable.add("Usuario 3");
		
		
		desplegable.setSize(100, 100);
		        
		add(desplegable);
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