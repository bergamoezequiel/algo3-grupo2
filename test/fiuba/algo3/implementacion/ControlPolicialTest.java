package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;

public class ControlPolicialTest {
	@Test
	public void ElPozoTendriaQuePenalizarCon3MovimientosALasMotos(){
        ControlPolicial unControl = new ControlPolicial();
        Moto unaMoto=new Moto();
        Conductor unConductor= new Conductor(unaMoto);
        unControl.interactuarCon(unConductor,unaMoto);
        Assert.assertEquals(3,unConductor.getMovimientos());
	}
	
	@Test
	public void ElPozoTendriaQuePenalizarCon3MovimientosALosAutos(){
		ControlPolicial unControl = new ControlPolicial();
        Auto unAuto=new Auto();
        Conductor unConductor= new Conductor(unAuto);
        unControl.interactuarCon(unConductor,unAuto);
        Assert.assertEquals(3,unConductor.getMovimientos());
	
	}
	
	@Test
	public void ElPozoNoTendriaQuePenalizarALosTodoTerreno(){
		ControlPolicial unControl = new ControlPolicial();
        TodoTerreno unTodoTerreno=new TodoTerreno();
        Conductor unConductor= new Conductor(unTodoTerreno);
        unControl.interactuarCon(unConductor,unTodoTerreno);
        Assert.assertEquals(3,unConductor.getMovimientos());
	}
	
	

}