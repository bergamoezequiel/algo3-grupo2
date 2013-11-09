package fiuba.algo3.implementacion;

public interface Interactuable {
	void InteractuarCon(Conductor unConductor, Moto unaMoto);
	void InteractuarCon(Conductor unConductor, Auto unAuto);
	void InteractuarCon(Conductor unConductor, TodoTerreno unTodoTerreno);
	boolean dejaPasar(Moto unaMoto);
	boolean dejaPasar(Auto unAuto);
	boolean dejaPasar(TodoTerreno unTodoTerreno);
}