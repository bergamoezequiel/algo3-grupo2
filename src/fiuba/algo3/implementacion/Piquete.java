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

	public void InteractuarCon(Conductor unConductor, Moto UnaMoto) {
		unConductor.aumentarMovimientosEn(this.penalizacion);

	}
	public void InteractuarCon(Conductor unConductor, Auto unAuto) {

	}
	public void InteractuarCon(Conductor unConductor, TodoTerreno unTodoTerreno){
       }

	public boolean dejaPasar(Moto unaMoto){
		return true;}
	public boolean dejaPasar(Auto unAuto){
		return false;}
	public boolean dejaPasar(TodoTerreno unTodoTerreno){
		return false;}
	}


