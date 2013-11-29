package fiuba.algo3.vista;
//import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.util.Hashtable;
//import java.io.InputStream;
//import java.awt.Image;
//import java.io.IOException;






//import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

//import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.mapa.*;
import fiuba.algo3.modelo.vehiculos.*;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.vista.pintores.*;

public class PantallaDelNivel extends JPanel {
	
	private static final long serialVersionUID = 9158068573854911242L;
	private int MARGEN_IZQUIERDO = 8;
	private int MARGEN_SUPERIOR = 50;
	private int TAMANIO_ICONOS_MENU = 40;
	
	final int ANCHO_PANTALLA_NIVEL = 600 - MARGEN_IZQUIERDO;
	final int ALTO_PANTALLA_NIVEL = 600 - MARGEN_SUPERIOR;
	
	private Nivel nivel;
	private int anchoCelda;
	private int altoCelda;
	
	private Hashtable<Class, Pintor> hash;
	
	public PantallaDelNivel(Nivel unNivel){
		/*
		 * Esto es lo que se ejecuta cuando se llama al constructor de la clase.
		 * Luego de llamarse al constructor, automaticamente se llama al metodo
		 * PAINT.
		 */
		setBackground(Color.gray);
		this.nivel = unNivel;
		this.anchoCelda = ANCHO_PANTALLA_NIVEL / this.nivel.getMapa().getCantidadDeColumnas();
		this.altoCelda = ALTO_PANTALLA_NIVEL / this.nivel.getMapa().getCantidadDeFilas();
	}
	
	
	
	public Coordenada coordenadaModeloAVista(Coordenada unaCoordenada, int cantFilasMapa){
		return new Coordenada(unaCoordenada.getX()*anchoCelda, (cantFilasMapa-1-unaCoordenada.getY())*altoCelda);
	}

	public void pintarCalles(Graphics g){
		Mapa mapa = this.nivel.getMapa();
		Conductor unConductor = this.nivel.getConductor();
		int cantFilasMapa = mapa.getCantidadDeFilas();
		int cantColumnasMapa = mapa.getCantidadDeColumnas();
		
		//Pinta las CALLES
		for (int i = 0; i < cantColumnasMapa; i++ ) {
			for (int j = 0; j < cantFilasMapa; j++) {
				Coordenada coordenadaVista = this.coordenadaModeloAVista(new Coordenada(i,j), cantFilasMapa);
				new PintorCalle(g).pintar(coordenadaVista, anchoCelda, altoCelda);
			}
		}
	}
	
	public void pintarManzanas(Graphics g){
		Mapa mapa = this.nivel.getMapa();
		Conductor unConductor = this.nivel.getConductor();
		int cantFilasMapa = mapa.getCantidadDeFilas();
		int cantColumnasMapa = mapa.getCantidadDeColumnas();
		
		//Pinta las MANZANAS
		for (int i = 1; i < cantColumnasMapa; i+=2 ) {
			for (int j = 1; j < cantFilasMapa; j+=2) {
				Celda unaCelda = mapa.getCeldaEn(new Coordenada(i,j));
				if (unaCelda.esVisiblePara(unConductor)){
					Coordenada coordenadaVista = this.coordenadaModeloAVista(new Coordenada(i,j), cantFilasMapa);
					new PintorManzana(g).pintar(coordenadaVista, anchoCelda, altoCelda);
				}
			}
		}
	}
	
	public void pintarObjetosEncontrables(Graphics g){
		Mapa mapa = this.nivel.getMapa();
		Conductor unConductor = this.nivel.getConductor();
		int cantFilasMapa = mapa.getCantidadDeFilas();
		int cantColumnasMapa = mapa.getCantidadDeColumnas();
		
		for (int i = 0; i < cantColumnasMapa; i++) {
			for (int j = 0; j < cantFilasMapa; j++) {
				Coordenada coordenadaVista = this.coordenadaModeloAVista(new Coordenada(i,j), cantFilasMapa);
				Celda unaCelda = mapa.getCeldaEn(new Coordenada(i,j));
				if (unaCelda.esVisiblePara(unConductor)){
					//Aca en realidad habria que dibujar el contenido de esa celda.
					
					//Hardcodeo de objetos, pasar a hash cuando se pueda.
					if (unaCelda.getContenido() instanceof Conductor)
						new PintorConductor(g).pintar(coordenadaVista, anchoCelda, altoCelda);
					if (unaCelda.getContenido() instanceof Pozo)
						new PintorPozo2(g).pintar(coordenadaVista, anchoCelda, altoCelda);
					if (unaCelda.getContenido() instanceof Piquete)
						new PintorPiquete(g).pintar(coordenadaVista, anchoCelda, altoCelda);
					if (unaCelda.getContenido() instanceof ControlPolicial)
						new PintorControlPolicial(g).pintar(coordenadaVista, anchoCelda, altoCelda);
					if (unaCelda.getContenido() instanceof Snorlax)
						new PintorSnorlax(g).pintar(coordenadaVista, anchoCelda, altoCelda);
					if (unaCelda.getContenido() instanceof Sorpresa)
						new PintorSorpresa(g).pintar(coordenadaVista, anchoCelda, altoCelda);
					if (unaCelda.getContenido() instanceof Llegada)
						new PintorLlegada(g).pintar(coordenadaVista, anchoCelda, altoCelda);
					
					
				}
				else{
					new PintorZonaNoVisible(g).pintar(coordenadaVista, anchoCelda, altoCelda);;
				}
			}
		}
	}
	
	/*public void pintorContenidoDeCelda(Graphics g, Coordenada unaCoordenadaVista, ContenidoDeCelda unContenido){
		g.drawImage(dibujoCalle.getImage(),unaCoordenadaVista.getX(),  unaCoordenadaVista.getY(), anchoCelda, altoCelda, null);	
		if (unContenido != null){
			if (unContenido instanceof Conductor ){
				g.drawImage(((ImageIcon)this.hash.get(((Conductor) unContenido).getVehiculo().getClass())).getImage(),unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda,null);
			}
			else{
				g.drawImage(((ImageIcon)this.hash.get(unContenido.getClass())).getImage(),unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda,null);
			}
		}
	}*/
	
	/*
	 * En el panel derecho se pintan los movimientos actuales y el Vehiculo Actual.
	 */
	public void pintarPanelDerecho(Graphics g){
		g.setColor(Color.BLUE);
		g.drawString("Movientos Actuales:"+(String)Integer.toString(this.nivel.getConductor().getMovimientos()), ANCHO_PANTALLA_NIVEL, 50);
		g.drawString("Vehiculo Actual: ", ANCHO_PANTALLA_NIVEL, 70);
		g.drawString(this.nivel.getConductor().getVehiculo().getClass().getSimpleName(), ANCHO_PANTALLA_NIVEL + TAMANIO_ICONOS_MENU + 10 , 100);
		//g.drawImage(((ImageIcon)this.hash.get(this.nivel.getConductor().getVehiculo().getClass())).getImage(),ANCHO_PANTALLA_NIVEL, 80, TAMANIO_ICONOS_MENU, TAMANIO_ICONOS_MENU, null);
		g.drawString("Movimientos Limites: "+(String)Integer.toString(nivel.getMovimientosLimites()), ANCHO_PANTALLA_NIVEL, 150);

		//g.drawString("Puntaje: "+(String)Integer.toString(nivel.getMovimientosRestantes() * this.nivel.getPuntajePorMovimientosSobrantes()), ANCHO_PANTALLA_NIVEL, 150);
		
		g.drawString("REFERENCIAS: ", ANCHO_PANTALLA_NIVEL, 280);
		g.drawString("Sorpresa: ", ANCHO_PANTALLA_NIVEL, 320);
		//g.drawImage((ImageIcon)this.hash.get(new Pozo()), 80, TAMANIO_ICONOS_MENU, TAMANIO_ICONOS_MENU, null);
		//g.drawImage(this.hash.get(),ANCHO_PANTALLA_NIVEL, 80, TAMANIO_ICONOS_MENU, TAMANIO_ICONOS_MENU, null);
		g.drawString("Pozo: ", ANCHO_PANTALLA_NIVEL, 360);
		g.drawString("Control Policial: ", ANCHO_PANTALLA_NIVEL, 400);
		g.drawString("Piquete: ", ANCHO_PANTALLA_NIVEL, 440);
		g.drawString("Snorlax: ", ANCHO_PANTALLA_NIVEL, 480);
		
		
		if(nivel.getJuegoActual().conductorLlego()){
			g.setColor(Color.RED);
			//g.drawString("FIN", ANCHO_PANTALLA_NIVEL, 150);
			//g.drawString("Tu puntaje es:"+(String)Integer.toString(nivel.getJuegoActual().getPuntajeDelConductor()), ANCHO_PANTALLA_NIVEL, 170);
		}
		
	}
	
	public void paint(Graphics g) {
			
		/*this.hash = new Hashtable();
		this.hash.put((new Auto()).getClass(), new PintorConductor(g));
		this.hash.put((new Moto()).getClass(), new PintorConductor(g));
		this.hash.put((new TodoTerreno()).getClass(), new PintorConductor(g));
		this.hash.put((new Pozo()).getClass(), new PintorPozo2(g));
		this.hash.put((new Piquete()).getClass(), new PintorPiquete(g));
		this.hash.put((new ControlPolicial()).getClass(), new PintorControlPolicial(g));
		this.hash.put((new Snorlax()).getClass(), new PintorSnorlax(g));
		this.hash.put((new SorpresaFavorable()).getClass(), new PintorSorpresa(g));
		this.hash.put((new SorpresaDesfavorable()).getClass(), new PintorSorpresa(g));
		this.hash.put((new CambioDeVehiculo()).getClass(), new PintorSorpresa(g));
		this.hash.put((new Llegada()).getClass(), new PintorLlegada(g));*/
		
		this.pintarCalles(g);
		this.pintarObjetosEncontrables(g);
		this.pintarManzanas(g);
		this.pintarPanelDerecho(g);
	}
}