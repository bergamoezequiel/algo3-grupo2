package fiuba.algo3.modelo.coordenadas;


public abstract class Direccion {
	
	protected int direccionX;
	protected int direccionY;
	
	@Override
	public boolean equals (Object unObjeto) {
		boolean sonIguales = false;
		
		if (unObjeto instanceof Direccion) {
			Direccion unaDireccion = (Direccion) unObjeto;
			if ( this.getX() == unaDireccion.getX() && this.getY() == unaDireccion.getY() ) {
				sonIguales = true;
			}
		}
		return sonIguales;
	}
	
	public Coordenada getDireccionComoCoordenada(){
		return (new Coordenada(direccionX, direccionY));
	}
	
	private int getX(){
		return this.direccionX;
	}
	
	private int getY(){
		return this.direccionY;
	}
}
