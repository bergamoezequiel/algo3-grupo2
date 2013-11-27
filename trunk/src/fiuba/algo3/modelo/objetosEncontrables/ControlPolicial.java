package fiuba.algo3.modelo.objetosEncontrables;

import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Conductor;
import fiuba.algo3.modelo.vehiculos.Moto;
import fiuba.algo3.modelo.vehiculos.TodoTerreno;


public class ControlPolicial extends ObjetoEncontrable {
	int penalizacion;
	/*Probabilidad de quedar demorados por el control policial*/
	final double probabilidadDePasarMoto = 0.7;
	final double probabilidadDePasarAuto = 0.5;
	final double probabilidadDePasarTodoTerreno = 0.3;
	
	
	public ControlPolicial() {
		super();
		this.penalizacion = 3;
	}

	public int obtenerPenalizacion(){
		return this.penalizacion;
	}
	
	public void interactuarConAuto(Conductor unConductor,NumeroAleatorio aleatorio) {
		if ((aleatorio.obtenerNumero()<=this.probabilidadDePasarAuto)&(aleatorio.obtenerNumero()>0))
			unConductor.variarMovimientosEn(this.obtenerPenalizacion());
	}

	@Override
	public void interactuarConAuto(Conductor unConductor) {
		NumeroAleatorio aleatorio= new NumeroAleatorio();
		this.interactuarConAuto(unConductor,aleatorio);		
	}
	
	public void interactuarConMoto(Conductor unConductor,NumeroAleatorio aleatorio) {
		if ((aleatorio.obtenerNumero()<=this.probabilidadDePasarMoto)&(aleatorio.obtenerNumero()>0))
			unConductor.variarMovimientosEn(this.obtenerPenalizacion());
	}

    @Override
    public void interactuarConMoto(Conductor unConductor) {
    	NumeroAleatorio aleatorio= new NumeroAleatorio();
		this.interactuarConMoto(unConductor,aleatorio);			
    }
    
    public void interactuarConTodoTerreno(Conductor unConductor,NumeroAleatorio aleatorio) {
		if ((aleatorio.obtenerNumero()<=this.probabilidadDePasarTodoTerreno)&(aleatorio.obtenerNumero()>0))
			unConductor.variarMovimientosEn(this.obtenerPenalizacion());
	}

    @Override
    public void interactuarConTodoTerreno(Conductor unConductor) {
    	NumeroAleatorio aleatorio= new NumeroAleatorio();
		this.interactuarConTodoTerreno(unConductor,aleatorio);		
    }

    
	@Override
	public boolean dejaPasar(Moto unaMoto) {
		return true;
	}

    @Override
	public boolean dejaPasar(Auto unAuto) {
		return true;
	}
	
	@Override
	public boolean dejaPasar(TodoTerreno unTodoTerreno) {
		return true;
	}
}
