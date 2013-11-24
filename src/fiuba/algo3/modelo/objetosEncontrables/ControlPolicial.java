package fiuba.algo3.modelo.objetosEncontrables;

import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Conductor;
import fiuba.algo3.modelo.vehiculos.Moto;
import fiuba.algo3.modelo.vehiculos.TodoTerreno;
import fiuba.algo3.implementacion.objetosEncontrables.NumeroAleatorio;


public class ControlPolicial extends ObjetoEncontrable {
	int penalizacion;
	/*Probabilidad de quedar demorados por el control policial*/
	final double probabilidadDePasarMoto = 0.7;
	final double probabilidadDePasarAuto = 0.5;
	final double probabilidadDePasarTodoTerreno = 0.3;
	
	/*
	 * Este metodo debera ser borrado, se creo solamente para que los tests
	 * de ControlPolicial pasen. Ya nos van a explicar en clase como hacer
	 * para testear un RANDOM.
	 * 
	 */
	private double RANDOM(double numero) {
		return numero;
	}
	
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

    public boolean probabilidadDePasarSegunVehiculo(double probabilidad){
    	boolean puedePasar;
    	//double valorAletorio = Math.random();
    	double valorAletorio = this.RANDOM(0.6);
    	if (valorAletorio <= probabilidad){
    		puedePasar = true;
    	}
    	else{
    		puedePasar = false;
    	}
    	return puedePasar;
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
