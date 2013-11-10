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
        unControl.interactuarCon(unConductor,unaMoto);
        Assert.assertEquals(3,unConductor.getMovimientos());
	}
	
	@Test
	public void ElControlPolicialTendriaQuePenalizarCon3MovimientosALosAutos(){
		ControlPolicial unControl = new ControlPolicial();
        Auto unAuto=new Auto();
        Conductor unConductor= new Conductor(unAuto);
        unControl.interactuarCon(unConductor,unAuto);
        Assert.assertEquals(3,unConductor.getMovimientos());
	
	}
	
	@Test
	public void ElControlPolicialTendriaQuePenalizarALosTodoTerreno(){
		ControlPolicial unControl = new ControlPolicial();
        TodoTerreno unTodoTerreno=new TodoTerreno();
        Conductor unConductor= new Conductor(unTodoTerreno);
        unControl.interactuarCon(unConductor,unTodoTerreno);
        Assert.assertEquals(3,unConductor.getMovimientos());
	}
	
	

}