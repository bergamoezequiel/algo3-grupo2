package fiuba.algo3.implementacion;
import java.util.Random;

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
	public void interactuarCon(Conductor unConductor, Auto unAuto) {
		unConductor.aumentarMovimientosEn(this.obtenerPenalizacion());		
	}

    @Override
    public void interactuarCon(Conductor unConductor, Moto unaMoto) {
    	unConductor.aumentarMovimientosEn(this.obtenerPenalizacion());		
    }

   @Override
   public void interactuarCon(Conductor unConductor, TodoTerreno unTodoTerreno) {
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