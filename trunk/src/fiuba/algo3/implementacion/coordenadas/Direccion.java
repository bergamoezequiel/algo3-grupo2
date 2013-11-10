package fiuba.algo3.implementacion.coordenadas;


public abstract class Direccion {
	
	protected int direccionX;
	protected int direccionY;
	
	public Coordenada getDireccionComoCoordenada(){
		return (new Coordenada(direccionX, direccionY));
	}
}
