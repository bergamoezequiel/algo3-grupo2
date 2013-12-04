package fiuba.algo3.vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import fiuba.algo3.modelo.TablaDePuntuaciones;

public class RankingVentana extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RankingVentana(){
		add(new PanelGPS());
		TablaDePuntuaciones unaTabla = new TablaDePuntuaciones();
		unaTabla= TablaDePuntuaciones.leerXml();
		

		setLocation(500, 200);
		this.setVisible(true);                 
		this.setTitle("Ranking");
		this.setSize(250,unaTabla.getTamanio()*100);
		this.setResizable(true);
	
		
		
		                        
		String str = "<html><div style='text-align: center;'>"
				+ "<FONT FACE=verdana"
				+ "<br>"
				+ "<br>"
				+ "<br>"
				+ "<br>"
				+ "<b>TAAAABLA DE POSICION JUAN! </b><br>"
				+ "<br>"
				+ "<TABLE BORDER WIDTH = '40%'>"
				+ "<TR><TD> Nombre de Usuario </TD><TD> Puntaje</TD>";
		
				//Recorre la lista de usuarios.
				for (int i = 0; i < unaTabla.getTamanio(); i++) {					
					
						str += "<TR><TD> " + unaTabla.getElementoEnPosicion(i).getNombre()+ "</TD><TD> " + unaTabla.getElementoEnPosicion(i).getPuntaje()+ " </TD>"
						+ "</TR>";
				};
				
				str +=  "</TABLE>" 
				+ "<br>"
				+ "<br>"		
				+ "</html></div></font>";
		
		JLabel texto= new JLabel(str);
		this.add(texto);
		}

	
}