package fiuba.algo3.implementacion.objetosEncontrables;

import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

public interface Interactuable {
	void interactuarCon(Conductor unConductor, Auto unAuto);
	void interactuarCon(Conductor unConductor, Moto unaMoto);
	void interactuarCon(Conductor unConductor, TodoTerreno unTodoTerreno);
	boolean dejaPasar(Auto unAuto);
	boolean dejaPasar(Moto unaMoto);
	boolean dejaPasar(TodoTerreno unTodoTerreno);
}
