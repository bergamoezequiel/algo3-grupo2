package fiuba.algo3;

import fiuba.algo3.modelo.Juego;
import fiuba.algo3.vista.VentanaInicial;

public class Main {
	public static void main(String args[]){

		
		//TablaDePuntuaciones.leerXml();
		//String ruta = "./src/archivos/NivelVacio.xml";
		//Nivel.CargarNivelXml(ruta);
		
	
		// CODIGO PARA GENERAR LOS ARCHIVOS DE LOS NIVELES  http://www.youtube.com/watch?v=HWoVxBcvy1s
		 //Nivel nivel = new NivelMuyDificil(Moto.getInstancia(), new Juego());
		 //nivel.guardar();
		
		Juego unJuego = new Juego(); //Observado
		new VentanaInicial(unJuego);
		
	}
}