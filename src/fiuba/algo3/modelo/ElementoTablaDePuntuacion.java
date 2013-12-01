package fiuba.algo3.modelo;


public class ElementoTablaDePuntuacion implements Comparable<ElementoTablaDePuntuacion>{

	private String nombre;
	private int puntaje;
	
	public ElementoTablaDePuntuacion(Usuario unUsuario, int unPuntaje){
		this.nombre = unUsuario.getNombre();
		this.puntaje = unPuntaje;
	}

	public String getNombre(){
		return this.nombre;
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}

	@Override
	public int compareTo(ElementoTablaDePuntuacion unElementoTablaDePuntuacion) {
		return this.getPuntaje() - unElementoTablaDePuntuacion.getPuntaje();		
	}

}