package fiuba.algo3.vista;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.mapa.Celda;
import fiuba.algo3.modelo.mapa.ContenidoDeCelda;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Conductor;


public class PantallaDelNivel extends Canvas {
	
	private int MARGEN_IZQUIERDO = 8;
	private int MARGEN_SUPERIOR = 50;
	
	final int ANCHO_PANTALLA_NIVEL = 600 - MARGEN_IZQUIERDO;
	final int ALTO_PANTALLA_NIVEL = 600 - MARGEN_SUPERIOR;
	
	private Juego juego;
	private int anchoCelda;
	private int altoCelda;
	
	
	public PantallaDelNivel(Juego unJuego){
		/*
		 * Esto es lo que se ejecuta cuando se llama al constructor de la clase.
		 * Luego de llamarse al constructor, automaticamente se llama al metodo
		 * PAINT.
		 */
		setBackground(Color.gray);
		this.juego = unJuego;
		this.anchoCelda = ANCHO_PANTALLA_NIVEL / this.juego.getMapa().getCantidadDeColumnas();
		this.altoCelda = ALTO_PANTALLA_NIVEL / this.juego.getMapa().getCantidadDeFilas();
	}
	
	public Coordenada coordenadaModeloAVista(Coordenada unaCoordenada, int cantColumnasMapa){
		return new Coordenada(unaCoordenada.getX()*anchoCelda, (cantColumnasMapa-1-unaCoordenada.getY())*altoCelda);
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
			g.setColor(Color.red);
			g.fillOval(unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda);		}
	}
	
	public void paint(Graphics g) {
		
		Mapa mapa = this.juego.getMapa();
		Conductor conductor = this.juego.getConductor();
		int cantColumnasMapa = mapa.getCantidadDeColumnas();
		int cantFilasMapa = mapa.getCantidadDeFilas();
		
		for (int i = 0; i < cantFilasMapa; i++) {
			for (int j = 0; j < cantColumnasMapa; j++) {
				Coordenada coordenadaVista = this.coordenadaModeloAVista(new Coordenada(i,j), this.juego.getMapa().getCantidadDeColumnas());
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
		for (int i = 1; i < this.juego.getMapa().getCantidadDeFilas(); i+=2 ) {
			for (int j = 1; j < this.juego.getMapa().getCantidadDeColumnas(); j+=2) {
				if (mapa.getCeldaEn(new Coordenada(i,j)).esVisiblePara(conductor)){
					Coordenada coordenadaVista = this.coordenadaModeloAVista(new Coordenada(i,j), this.juego.getMapa().getCantidadDeColumnas());
					g.setColor(Color.orange);
					g.fillRect(coordenadaVista.getX(), coordenadaVista.getY(), anchoCelda, altoCelda);
				}
			}
		}
		
		this.juego.getConductor().avanzarEnDireccion(new Abajo());
		//this.juego.getConductor().avanzarEnDireccion(new Arriba());
		//this.juego.getConductor().avanzarEnDireccion(new Arriba());
		
	}
}