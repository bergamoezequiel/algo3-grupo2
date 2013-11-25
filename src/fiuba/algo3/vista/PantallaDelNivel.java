package fiuba.algo3.vista;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.mapa.Celda;
import fiuba.algo3.modelo.mapa.ContenidoDeCelda;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.objetosEncontrables.CambioDeVehiculo;
import fiuba.algo3.modelo.objetosEncontrables.ControlPolicial;
import fiuba.algo3.modelo.objetosEncontrables.Piquete;
import fiuba.algo3.modelo.objetosEncontrables.Pozo;
import fiuba.algo3.modelo.objetosEncontrables.SorpresaDesfavorable;
import fiuba.algo3.modelo.objetosEncontrables.SorpresaFavorable;
import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Conductor;
import fiuba.algo3.modelo.vehiculos.Moto;
import fiuba.algo3.modelo.vehiculos.TodoTerreno;


public class PantallaDelNivel extends JPanel {
	
	private int MARGEN_IZQUIERDO = 8;
	private int MARGEN_SUPERIOR = 50;
	
	final int ANCHO_PANTALLA_NIVEL = 600 - MARGEN_IZQUIERDO;
	final int ALTO_PANTALLA_NIVEL = 600 - MARGEN_SUPERIOR;
	
	private Nivel nivel;
	private int anchoCelda;
	private int altoCelda;
	
	private Hashtable<Class, Color> hash;
	
	public PantallaDelNivel(Nivel unNivel){
		/*
		 * Esto es lo que se ejecuta cuando se llama al constructor de la clase.
		 * Luego de llamarse al constructor, automaticamente se llama al metodo
		 * PAINT.
		 */
		setBackground(Color.gray);
		this.nivel = unNivel;
		this.hash = new Hashtable();
		this.anchoCelda = ANCHO_PANTALLA_NIVEL / this.nivel.getMapa().getCantidadDeColumnas();
		this.altoCelda = ALTO_PANTALLA_NIVEL / this.nivel.getMapa().getCantidadDeFilas();
		
		//Aca se crean los objetos para poder hashearlos con su clse
		Auto unAuto = new Auto();
		Moto unaMoto = new Moto();
		TodoTerreno unTodoTerreno = new TodoTerreno();
		
		Pozo unPozo = new Pozo();
		Piquete unPiquete = new Piquete();
		SorpresaFavorable unaSorpresaFavorable = new SorpresaFavorable();
		SorpresaDesfavorable unaSorpresaDesfavorable = new SorpresaDesfavorable();
		CambioDeVehiculo unCambioDeVehiculo = new CambioDeVehiculo();
		ControlPolicial unControlPolicial = new ControlPolicial();

		this.hash.put(unAuto.getClass(), Color.RED );
		this.hash.put(unaMoto.getClass(), Color.YELLOW);
		this.hash.put(unTodoTerreno.getClass(), Color.ORANGE);
		
		this.hash.put(unPozo.getClass(),Color.BLACK);
		this.hash.put(unPiquete.getClass(), Color.BLUE);
		this.hash.put(unaSorpresaFavorable.getClass(),Color.CYAN);
		this.hash.put(unaSorpresaDesfavorable.getClass(), Color.GRAY);
		this.hash.put(unCambioDeVehiculo.getClass(), Color.GREEN);
		this.hash.put(unControlPolicial.getClass(), Color.PINK);
	}
	
	
	public Coordenada coordenadaModeloAVista(Coordenada unaCoordenada, int cantFilasMapa){
		return new Coordenada(unaCoordenada.getX()*anchoCelda, (cantFilasMapa-1-unaCoordenada.getY())*altoCelda);
	}
	
	public void pintorCeldaNoVisible(Graphics g, Coordenada unaCoordenadaVista){
		g.setColor(Color.black);
		g.fillRect(unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda);
	}
	
	public void pintorContenidoDeCelda(Graphics g, Coordenada unaCoordenadaVista, ContenidoDeCelda unContenido){
		g.setColor(Color.lightGray);
		g.fillRect(unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda);
		
		//En realidad deberia fijarse si es un conductor
		//Como esta ahora pinta un circulo rojo siempre que se ubique un contenido de celda, sea lo que sea.
		if (unContenido != null){
			if (unContenido instanceof Conductor ){
				g.setColor((Color)this.hash.get(((Conductor) unContenido).getVehiculo().getClass()));
				g.fillOval(unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda);
			}
				else{
					g.setColor((Color)this.hash.get(unContenido.getClass()));
					g.fillOval(unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda);
				}
		}
	}
	
	public void paint(Graphics g) {
		
		Mapa mapa = this.nivel.getMapa();
		Conductor conductor = this.nivel.getConductor();
		int cantColumnasMapa = mapa.getCantidadDeColumnas();
		int cantFilasMapa = mapa.getCantidadDeFilas();

		for (int i = 0; i < cantColumnasMapa; i++) {
			for (int j = 0; j < cantFilasMapa; j++) {
				Coordenada coordenadaVista = this.coordenadaModeloAVista(new Coordenada(i,j), cantFilasMapa);
				if (mapa.getCeldaEn(new Coordenada(i,j)).esVisiblePara(conductor)){
					//Aca en realidad habria que dibujar el contenido de esa celda.
					this.pintorContenidoDeCelda(g, coordenadaVista, mapa.getCeldaEn(new Coordenada(i,j)).getContenido());
				}
				else{
					this.pintorCeldaNoVisible(g, coordenadaVista);
				}
			}
		}

		//Pintando las MANZANAS de naranja.
		for (int i = 1; i < this.nivel.getMapa().getCantidadDeColumnas(); i+=2 ) {
			for (int j = 1; j < this.nivel.getMapa().getCantidadDeFilas(); j+=2) {
				if (mapa.getCeldaEn(new Coordenada(i,j)).esVisiblePara(conductor)){
					Coordenada coordenadaVista = this.coordenadaModeloAVista(new Coordenada(i,j), cantFilasMapa);
					g.setColor(Color.black);
					g.fillRect(coordenadaVista.getX(), coordenadaVista.getY(), anchoCelda, altoCelda);
					
					g.setColor(Color.orange);
					double contorno = 0.1;
					int margenAnchura = (int) Math.round(anchoCelda*contorno);
					int margenAltura = (int) Math.round(altoCelda*contorno);
					g.fillRect(coordenadaVista.getX()+margenAnchura, coordenadaVista.getY()+margenAltura, anchoCelda-margenAnchura, altoCelda-margenAltura);
				}
			}
		}
	}
}