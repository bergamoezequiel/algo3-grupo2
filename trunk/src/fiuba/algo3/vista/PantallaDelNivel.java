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
	
	ImageIcon dibujoAuto = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/auto.png")).getImage());
	ImageIcon dibujoMoto = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/moto.png")).getImage());
	ImageIcon dibujoTodoTerreno = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/todoTerreno.png")).getImage());
	ImageIcon dibujoManzana = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/manzana.png")).getImage());
	ImageIcon dibujoSorpresa = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/sorpresa.png")).getImage());
	ImageIcon dibujoControlPolicial = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/controlPolicial.png")).getImage());
	ImageIcon dibujoPiquete = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/piquete.png")).getImage());
	ImageIcon dibujoPozo = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/pozo.png")).getImage());
	ImageIcon dibujoLlegada = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/llegada.png")).getImage());
	ImageIcon dibujoCalle = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/calle.png")).getImage());
	ImageIcon dibujoSnorlax = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/snorlax.png")).getImage());

	
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
		
		
		this.hash.put((new Auto()).getClass(), dibujoAuto);
		this.hash.put((new Moto()).getClass(), dibujoMoto);
		this.hash.put((new TodoTerreno()).getClass(), dibujoTodoTerreno);
		this.hash.put((new Pozo()).getClass(),dibujoPozo);
		this.hash.put((new Piquete()).getClass(), dibujoPiquete);
		this.hash.put((new ControlPolicial()).getClass(), dibujoControlPolicial);
		this.hash.put((new Snorlax()).getClass(), dibujoSnorlax);
		this.hash.put((new SorpresaFavorable()).getClass(),dibujoSorpresa);
		this.hash.put((new SorpresaDesfavorable()).getClass(),dibujoSorpresa);
		this.hash.put((new CambioDeVehiculo()).getClass(), dibujoSorpresa);
		this.hash.put((new Llegada()).getClass(),dibujoLlegada);
	}
	
	
	
	public Coordenada coordenadaModeloAVista(Coordenada unaCoordenada, int cantFilasMapa){
		return new Coordenada(unaCoordenada.getX()*anchoCelda, (cantFilasMapa-1-unaCoordenada.getY())*altoCelda);
	}
	
	public void pintorCeldaNoVisible(Graphics g, Coordenada unaCoordenadaVista){
		g.setColor(Color.black);
		g.fillRect(unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda);
	}
	
	public void pintorContenidoDeCelda(Graphics g, Coordenada unaCoordenadaVista, ContenidoDeCelda unContenido){
		g.drawImage(dibujoCalle.getImage(),unaCoordenadaVista.getX(),  unaCoordenadaVista.getY(), anchoCelda, altoCelda, null);	
		if (unContenido != null){
			if (unContenido instanceof Conductor ){
				g.drawImage(((ImageIcon)this.hash.get(((Conductor) unContenido).getVehiculo().getClass())).getImage(),unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda,null);
			}
			else{
				g.drawImage(((ImageIcon)this.hash.get(unContenido.getClass())).getImage(),unaCoordenadaVista.getX(), unaCoordenadaVista.getY(), anchoCelda, altoCelda,null);
			}
		}
	}
	
	/*
	 * En el panel derecho se pintan los movimientos actuales y el Vehiculo Actual.
	 */
	public void pintarPanelDerecho(Graphics g){
		g.setColor(Color.BLUE);
		g.drawString("Movientos Actuales:"+(String)Integer.toString(this.nivel.getConductor().getMovimientos()), ANCHO_PANTALLA_NIVEL, 50);
		g.drawString("Vehiculo Actual:"+this.nivel.getConductor().getVehiculo().getClass().getSimpleName(), ANCHO_PANTALLA_NIVEL, 65);
		g.drawString("Movimientos Limites: "+(String)Integer.toString(nivel.getMovimientosLimites()), ANCHO_PANTALLA_NIVEL, 130);
		//g.drawString("Puntaje: "+(String)Integer.toString(nivel.getMovimientosRestantes() * this.nivel.getPuntajePorMovimientosSobrantes()), ANCHO_PANTALLA_NIVEL, 150);
		
		if(nivel.getJuegoActual().conductorLlego()){
			g.setColor(Color.RED);
			g.drawString("FIN", ANCHO_PANTALLA_NIVEL, 80);
			g.drawString("Tu puntaje es:"+(String)Integer.toString(nivel.getJuegoActual().getPuntajeDelConductor()), ANCHO_PANTALLA_NIVEL, 100);
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
					g.drawImage(dibujoManzana.getImage(),coordenadaVista.getX(),  coordenadaVista.getY(), anchoCelda, altoCelda, null);	
				}
			}
		}
		
		pintarPanelDerecho(g);
	}
}