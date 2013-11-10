package fiuba.algo3.implementacion;

//COORDENADAS CARTESIANAS//
public class Coordenada {
	private int x;
	private int y;
	
	public Coordenada(int coordenadaX, int coordenadaY){
		this.x = coordenadaX;		
		this.y = coordenadaY;	
	}

	@Override
	public boolean equals (Object unObjeto) {
		boolean boEquals = false;
		if (unObjeto instanceof Coordenada) {
			Coordenada unaCoordenada = (Coordenada) unObjeto;
			if ( this.getX() == unaCoordenada.getX() && this.getY() == unaCoordenada.getY() ) {
				boEquals = true;
			}
		}
		return boEquals;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public Coordenada sumar(Coordenada unaCoordenada){
		return new Coordenada (this.x+unaCoordenada.getX(), this.y+unaCoordenada.getY());
	}
	
	public double calcularDistancia(Coordenada unaCoordenada){
		double distanciaXAlCuadrado = Math.pow(this.getX() - unaCoordenada.getX(), 2);
		double distanciaYAlCuadrado = Math.pow(this.getY() - unaCoordenada.getY(), 2);;
		return Math.sqrt(distanciaXAlCuadrado + distanciaYAlCuadrado);
	}
		
}
