package fiuba.algo3.implementacion.objetosEncontrables;

import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

public interface Interactuable {
	void interactuarConAuto(Conductor unConductor);
	void interactuarConMoto(Conductor unConductor);
	void interactuarConTodoTerreno(Conductor unConductor);
	boolean dejaPasar(Auto unAuto);
	boolean dejaPasar(Moto unaMoto);
	boolean dejaPasar(TodoTerreno unTodoTerreno);
}
