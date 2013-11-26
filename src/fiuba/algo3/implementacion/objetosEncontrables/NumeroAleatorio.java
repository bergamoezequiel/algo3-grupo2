package fiuba.algo3.implementacion.objetosEncontrables;

public class NumeroAleatorio {
	
	protected double numero;
	
	public NumeroAleatorio(){
		this.numero= Math.random();
	}
	
	public double obtenerNumero(){
		return this.numero;
	}
}
