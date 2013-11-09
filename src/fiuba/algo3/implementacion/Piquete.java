package fiuba.algo3.implementacion;

public class Piquete extends Obstaculo {
	int penalizacion;

	public Piquete() {
		super();
		this.penalizacion = 2;
	}

	public int obtenerPenalizacion(){
		return this.penalizacion;
	}
	
	@Override
	public void interactuarCon(Conductor unConductor, Moto UnaMoto) {
		unConductor.aumentarMovimientosEn(this.penalizacion);
	}
	
	@Override
	public void interactuarCon(Conductor unConductor, Auto unAuto) {
	}
	
	@Override
	public void interactuarCon(Conductor unConductor, TodoTerreno unTodoTerreno){
	}

	@Override
	public boolean dejaPasar(Moto unaMoto){
		return true;
	}
	
	@Override
	public boolean dejaPasar(Auto unAuto){
		return false;
	}
	
	@Override
	public boolean dejaPasar(TodoTerreno unTodoTerreno){
		return false;
	}
}


