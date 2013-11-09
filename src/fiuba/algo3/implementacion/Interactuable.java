package fiuba.algo3.implementacion;

public interface Interactuable {
	void interactuarCon(Conductor unConductor, Moto unaMoto);
	void interactuarCon(Conductor unConductor, Auto unAuto);
	void interactuarCon(Conductor unConductor, TodoTerreno unTodoTerreno);
	boolean dejaPasar(Moto unaMoto);
	boolean dejaPasar(Auto unAuto);
	boolean dejaPasar(TodoTerreno unTodoTerreno);
}
