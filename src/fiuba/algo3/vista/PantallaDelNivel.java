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

import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.mapa.*;
import fiuba.algo3.modelo.vehiculos.*;
import fiuba.algo3.modelo.objetosEncontrables.*;

public class PantallaDelNivel extends JPanel {
	
	private static final long serialVersionUID = 9158068573854911242L;
	private int MARGEN_IZQUIERDO = 8;
	private int MARGEN_SUPERIOR = 50;
	
	final int ANCHO_PANTALLA_NIVEL = 600 - MARGEN_IZQUIERDO;
	final int ALTO_PANTALLA_NIVEL = 600 - MARGEN_SUPERIOR;
	
	private Nivel nivel;
	private int anchoCelda;
	private int altoCelda;
	
	private Hashtable<Class, ImageIcon> hash;
	
	ImageIcon dibujo= new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/1.png")).getImage());
	ImageIcon dibujo2= new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/2.png")).getImage());
	ImageIcon dibujo3= new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/3.png")).getImage());
	ImageIcon dibujo4= new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/4.png")).getImage());
	ImageIcon dibujo5= new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/5.png")).getImage());
	ImageIcon dibujo6= new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/6.png")).getImage());
	ImageIcon dibujo7= new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/7.png")).getImage());
	ImageIcon dibujo8= new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/8.jpg")).getImage());
	ImageIcon dibujo9= new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/10.gif")).getImage());
	
	
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
		Llegada unaLLegada =new Llegada();
		Piquete unPiquete = new Piquete();
		SorpresaFavorable unaSorpresaFavorable = new SorpresaFavorable();
		SorpresaDesfavorable unaSorpresaDesfavorable = new SorpresaDesfavorable();
		CambioDeVehiculo unCambioDeVehiculo = new CambioDeVehiculo();
		ControlPolicial unControlPolicial = new ControlPolicial();

		this.hash.put(unAuto.getClass(), dibujo);
		this.hash.put(unaMoto.getClass(), dibujo2);
		this.hash.put(unTodoTerreno.getClass(), dibujo3);
		
		this.hash.put(unPozo.getClass(),dibujo8);
		this.hash.put(unPiquete.getClass(), dibujo7);
		this.hash.put(unaSorpresaFavorable.getClass(),dibujo5);
		this.hash.put(unaSorpresaDesfavorable.getClass(),dibujo5);
		this.hash.put(unCambioDeVehiculo.getClass(), dibujo5);
		this.hash.put(unControlPolicial.getClass(), dibujo6);
		this.hash.put(unaLLegada.getClass(),dibujo9);
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
				
				g.drawImage(((ImageIcon)this.hash.get(((Conductor) unContenido).getVehiculo().getClass())).getImage(),unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda,null);
				/*				g.setColor((Color)this.hash.get(((Conductor) unContenido).getVehiculo().getClass()));
				g.fillOval(unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda);*/
			}
				else{
					g.drawImage(((ImageIcon)this.hash.get(unContenido.getClass())).getImage(),unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda,null);
			
/*					g.setColor((Color)this.hash.get(unContenido.getClass()));
					g.fillOval(unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda);*/
				}
		}
	}
	public void pintarPanelDerecho(Graphics g){
		g.setColor(Color.BLUE);
		g.drawString("Movientos Actuales:"+(String)Integer.toString(this.nivel.getConductor().getMovimientos()), ANCHO_PANTALLA_NIVEL, 50);
		
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
					g.drawImage(dibujo4.getImage(),coordenadaVista.getX()+margenAnchura,  coordenadaVista.getY()+margenAltura, anchoCelda-margenAnchura, altoCelda-margenAltura,null);
				
				}
			}
		}
		
		pintarPanelDerecho(g);
	}
}