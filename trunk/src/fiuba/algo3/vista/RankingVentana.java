package fiuba.algo3.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;

import fiuba.algo3.modelo.TablaDePuntuaciones;

public class RankingVentana extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RankingVentana(){
		setLocation(500, 200);
		this.setVisible(false);                 
		this.setTitle("Ranking");
		this.setSize(250,200);
		this.setResizable(false);
		TablaDePuntuaciones unaTabla = new TablaDePuntuaciones();
		
		unaTabla= TablaDePuntuaciones.leerXml();
		                        
		String str = "<html><div style='text-align: center;'>"
				+ "<FONT FACE=verdana"
				+ "<b>TAAAABLA DE POSICION JUAN! </b><br>"
				+ "<br>"
				+ "<br>";
		
				//Recorre la lista de usuarios.
				for (int i = 0; i < unaTabla.getTamanio(); i++) {
					str += unaTabla.getElementoEnPosicion(i).getNombre() + unaTabla.getElementoEnPosicion(i).getPuntaje() + "<br>";
				};
				
				str += "<br>"
				+ "<br>"		
				+ "</html></div></font>";
		
		JLabel texto= new JLabel(str);
		this.add(texto);
		}
	
}