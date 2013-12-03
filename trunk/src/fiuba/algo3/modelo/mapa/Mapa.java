package fiuba.algo3.modelo.mapa;

import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import fiuba.algo3.modelo.ElementoTablaDePuntuacion;
import fiuba.algo3.modelo.Nivel;
import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.coordenadas.Derecha;
import fiuba.algo3.modelo.objetosEncontrables.*;
import fiuba.algo3.modelo.vehiculos.Conductor;
import fiuba.algo3.modelo.vehiculos.Moto;


public class Mapa {
    
	private ArrayList<ArrayList<Celda>> celdas;
	private int filas;
	private int columnas;

	private Mapa(){}
	public Mapa(int cantManzanasAncho, int cantManzanasAlto) {
		this.celdas = new ArrayList<ArrayList<Celda>>();
		this.filas = (cantManzanasAlto*2)+1;
		this.columnas = (cantManzanasAncho*2)+1;
		for (int x = 0; x<this.columnas ; x++){
			ArrayList<Celda> columna = new ArrayList<Celda>();
			for (int y = 0; y < this.filas; y++){
				columna.add(new Celda(this, new Coordenada(x, y)));
			}
			this.celdas.add(columna);            
    	}
	}

	public int getCantidadDeFilas() {
		return this.filas;
	}

	public int getCantidadDeColumnas() {
		return this.columnas;
	}
	
	public void setCantidadDeFilas(int filas) {
		this.filas=filas;
		System.out.println("filas del mapa"+ Integer.toString(filas));
	}

	public void setCantidadDeColumnas(int columnas) {
		this.columnas=columnas;
		System.out.println("columnas del mapa"+ Integer.toString(columnas));
	}

	public Celda getCeldaEn(Coordenada unaCoordenada) throws UbicacionEnMapaException  {
		if (!this.coordenadaValida(unaCoordenada)){
			throw new UbicacionEnMapaException();
		}
		ArrayList<Celda> fila = this.celdas.get(unaCoordenada.getX());
		return fila.get(unaCoordenada.getY());
	}
	
	public boolean coordenadaValida(Coordenada unaCoordenada) {
		return (unaCoordenada.getX() <= this.getCantidadDeColumnas()-1 && unaCoordenada.getX() >= 0) &&
			(unaCoordenada.getY() <= this.getCantidadDeFilas()-1 && unaCoordenada.getY() >= 0);
		}
	
	public Element serializar(){
		Element nodoMapa = new Element("mapa");
		nodoMapa.setAttribute("filas", Integer.toString(this.filas));
		nodoMapa.setAttribute("columnas", Integer.toString(this.columnas));
		System.out.println("Se setearon bien las filas y col");
		for (int x = 0; x<this.columnas ; x++)
			for (int y = 0; y < this.filas; y++){
				System.out.println("entro el for");	
				if ((celdas.get(x).get(y).getContenido())!=null){
				nodoMapa.addContent((celdas.get(x)).get(y).serializar());}
				System.out.println("se agregaro una coordenada");	
			}
			
		return nodoMapa;
		}
	public void guardar(){
		try{
		Document docMapa =new Document();
		System.out.println("Se creo el doc");
		Element mapa = this.serializar();
		
		docMapa.setRootElement(mapa);
		System.out.println("se agrego el mapa al documento");	
		XMLOutputter xmlOutput =new XMLOutputter(Format.getPrettyFormat());
		xmlOutput.output(docMapa,new FileOutputStream(new File("./src/nivelFacil.xml")));
		System.out.println("Se escribio el archivo");
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// En el lugar del conductor pone siempre el mismo conductor
	public static Mapa deserializarse(Element nodoMapa,Nivel nivel ){
		Mapa unMapa = new Mapa();
		System.out.println("Se creo el mapa");
		unMapa.setCantidadDeFilas(Integer.parseInt(nodoMapa.getAttributeValue("filas")));
		unMapa.setCantidadDeColumnas(Integer.parseInt(nodoMapa.getAttributeValue("columnas")));
		unMapa.celdas = new ArrayList<ArrayList<Celda>>();
		for (int x = 0; x<unMapa.getCantidadDeColumnas() ; x++){
			ArrayList<Celda> columna = new ArrayList<Celda>();
			for (int y = 0; y < unMapa.getCantidadDeFilas(); y++){
				columna.add(new Celda(unMapa, new Coordenada(x, y)));
				System.out.println("Se creo celda");
			}
			unMapa.celdas.add(columna);            
    	}
		
		for(Element nodoCelda : nodoMapa.getChildren("celda")){
			System.out.println("entro el for de las celdas");
			Coordenada coordenada= Coordenada.deserializarse(nodoCelda.getChild("coordenada"));
			System.out.println("se creo una coordenada");
			Celda celda = unMapa.getCeldaEn(coordenada);
			if ((nodoCelda.getChild("contenido").getAttributeValue("tipoDeEncontrable")).equals("Pozo")){
				celda.agregarContenido(new Pozo());
				System.out.println("se agrego un pozo");
			}
			else{ 
				if ((nodoCelda.getChild("contenido").getAttributeValue("tipoDeEncontrable")).equals("Piquete")){
				celda.agregarContenido(new Piquete());
				System.out.println("se agrego un piquete");
				}
				else{ 
					if ((nodoCelda.getChild("contenido").getAttributeValue("tipoDeEncontrable")).equals("Control")){
					celda.agregarContenido(new ControlPolicial());
					System.out.println("se agrego un control policial");
				    }
					else{ 
						if ((nodoCelda.getChild("contenido").getAttributeValue("tipoDeEncontrable")).equals("Llegada")){
						celda.agregarContenido(new Llegada());
						System.out.println("se agrego un Llegada");
					    }
						else{ 
							if ((nodoCelda.getChild("contenido").getAttributeValue("tipoDeEncontrable")).equals("Cambio")){
							celda.agregarContenido(new CambioDeVehiculo());
							System.out.println("se agrego un cambio de vehiculo");
						    }
							else{ 
								if ((nodoCelda.getChild("contenido").getAttributeValue("tipoDeEncontrable")).equals("Snorlax")){
								celda.agregarContenido(new Snorlax());
								System.out.println("se agrego un Snorlax");
							    }
								else{ 
										if ((nodoCelda.getChild("contenido").getAttributeValue("tipoDeEncontrable")).equals("favorable")){
										celda.agregarContenido(new SorpresaFavorable());
										System.out.println("se agrego una sorpresa favorable");
									    }
										else{ 
											if ((nodoCelda.getChild("contenido").getAttributeValue("tipoDeEncontrable")).equals("Desfavorable")){
											celda.agregarContenido(new SorpresaDesfavorable());
											System.out.println("se agrego un sorpresa desfavorable");
										    }
											else{ 
												if ((nodoCelda.getChild("contenido").getAttributeValue("tipoDeEncontrable")).equals("Conductor")){
												Conductor conductor=new Conductor(Moto.getInstancia(), new Derecha(), 5);
												celda.agregarContenido(conductor);
												nivel.setConductor(conductor);
												nivel.getConductor().addObserver(nivel);
												System.out.println("se agrego un conductor");
											    }
									    }
								}}
							}
						}
					}		
				}
			}
		}
	
		return unMapa;		
	}
	
	
	
}	