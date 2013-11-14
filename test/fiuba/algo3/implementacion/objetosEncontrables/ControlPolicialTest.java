package fiuba.algo3.implementacion.objetosEncontrables;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.objetosEncontrables.ControlPolicial;
import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

public class ControlPolicialTest {
	@Test
	public void ElControlPolicialTendriaQuePenalizarCon3MovimientosALasMotos(){
        ControlPolicial unControl = new ControlPolicial();
        Moto unaMoto=new Moto();
        Conductor unConductor= new Conductor(unaMoto);
        unControl.interactuarConMoto(unConductor);
        Assert.assertEquals(3,unConductor.getMovimientos());
	}
	
	@Test
	public void ElControlPolicialTendriaQuePenalizarCon3MovimientosALosAutos(){
		ControlPolicial unControl = new ControlPolicial();
        Auto unAuto=new Auto();
        Conductor unConductor= new Conductor(unAuto);
        unControl.interactuarConAuto(unConductor);
        Assert.assertEquals(3,unConductor.getMovimientos());
	
	}
	
	@Test
	public void ElControlPolicialTendriaQuePenalizarCon3MovimientosALosTodoTerreno(){
		ControlPolicial unControl = new ControlPolicial();
        TodoTerreno unTodoTerreno=new TodoTerreno();
        Conductor unConductor= new Conductor(unTodoTerreno);
        unControl.interactuarConTodoTerreno(unConductor);
        Assert.assertEquals(3,unConductor.getMovimientos());
	}
	
	@Test
	public void elControlPolicialSoloTendriaQueDejarPasarALaMoto(){
		/*
		 * No deja pasar a nadie por como fue definida la funcion RANDOM().
		 */
		ControlPolicial unControlPolicial = new ControlPolicial();
		Auto unAuto = new Auto();
		Moto unaMoto = new Moto();
		TodoTerreno unTodoTerreno = new TodoTerreno();
		
		Assert.assertEquals (false, unControlPolicial.dejaPasar(unAuto));
		Assert.assertEquals (false, unControlPolicial.dejaPasar(unTodoTerreno));
		
		Assert.assertEquals (true, unControlPolicial.dejaPasar(unaMoto));
		
	}
	
	

}