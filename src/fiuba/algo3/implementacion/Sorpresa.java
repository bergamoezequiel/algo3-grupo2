package fiuba.algo3.implementacion;

public abstract class Sorpresa extends ContenidoDeCelda implements Interactuable{
	public Sorpresa(){
		super();
	}
	
	public boolean dejaPasar(Moto unaMoto){ 
		return true;}
	public boolean dejaPasar(Auto unAuto){ 
		return true;}
	public boolean dejaPasar(TodoTerreno unTodoTerreno){ 
		return true;}
}
