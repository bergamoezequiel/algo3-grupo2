package fiuba.algo3.vista;

import fiuba.algo3.modelo.coordenadas.Coordenada;
import fiuba.algo3.modelo.vehiculos.Conductor;

public class ConductorObs extends Observador{
	
	private Conductor unConductor;
	private Coordenada unaCoordenada;
	
	@Override
	public void actualizar(){
		unaCoordenada = unConductor.getCelda().getCoordenada();
	}
	
}
