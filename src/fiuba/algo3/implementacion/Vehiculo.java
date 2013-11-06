package fiuba.algo3.implementacion;



public class Vehiculo{
	
	private int movimientos;
	
	public Vehiculo(){
		this.movimientos=0;
	}
	
	public int getMovimientos(){
		return this.movimientos;
	}

	public void avanzar(){
		this.movimientos += 1;
	}
}