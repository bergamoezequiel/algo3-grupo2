package fiuba.algo3.implementacion.objetosEncontrables;

import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

public class ControlPolicial extends Obstaculo {
	int penalizacion;
	/*Probabilidad de quedar demorados por el control policial*/
	final double probabilidadAuto = 0.5;
	final double probabilidadMoto = 0.7;
	final double probabilidadTodoTerreno = 0.3;
	
	
	public ControlPolicial() {
		super();
		this.penalizacion = 3;
	}

	public int obtenerPenalizacion(){
		return this.penalizacion;
	}

	@Override
	public void interactuarConAuto(Conductor unConductor) {
		unConductor.aumentarMovimientosEn(this.obtenerPenalizacion());		
	}

    @Override
    public void interactuarConMoto(Conductor unConductor) {
    	unConductor.aumentarMovimientosEn(this.obtenerPenalizacion());		
    }

   @Override
   public void interactuarConTodoTerreno(Conductor unConductor) {
	   unConductor.aumentarMovimientosEn(this.obtenerPenalizacion());	
   }
   
   @Override
	public boolean dejaPasar(Auto unAuto) {
		double valorAletorio = Math.random();
		if (valorAletorio <= (this.probabilidadAuto)){
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean dejaPasar(Moto unaMoto) {
		double valorAletorio = Math.random();
		if (valorAletorio <= (this.probabilidadMoto)){
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean dejaPasar(TodoTerreno unTodoTerreno) {
		double valorAletorio = Math.random();
		if (valorAletorio <= (this.probabilidadTodoTerreno)){
			return true;
		}
		else
			return false;
	}
}
