package fiuba.algo3.implementacion.objetosEncontrables;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.implementacion.objetosEncontrables.Pozo;
import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

public class PozoTest {
	@Test
	public void ElPozoTendriaQuePenalizarCon3MovimientosALasMotos(){
        Pozo unPozo= new Pozo();
        Moto unaMoto=new Moto();
        Conductor unConductor= new Conductor(unaMoto);
        unPozo.interactuarConMoto(unConductor);
        Assert.assertEquals(3,unConductor.getMovimientos());
	}
	
	@Test
	public void ElPozoTendriaQuePenalizarCon3MovimientosALosAutos(){
        Pozo unPozo= new Pozo();
        Auto unAuto=new Auto();
        Conductor unConductor= new Conductor(unAuto);
        unPozo.interactuarConAuto(unConductor);
        Assert.assertEquals(3,unConductor.getMovimientos());
	
	}
	
	@Test
	public void ElPozoNoTendriaQuePenalizarALosTodoTerreno(){
        Pozo unPozo= new Pozo();
        TodoTerreno unTodoTerreno=new TodoTerreno();
        Conductor unConductor= new Conductor(unTodoTerreno);
        unPozo.interactuarConTodoTerreno(unConductor);
        Assert.assertEquals(0,unConductor.getMovimientos());
	}
	
	@Test
	public void ElPozoDeberiaDejarPasarALasMotos(){
		Pozo unPozo= new Pozo();
		Moto unaMoto= new Moto();
		Assert.assertEquals(true,unPozo.dejaPasar(unaMoto));
	}
	
	@Test
	public void ElPozoDeberiaDejarPasarALosAutos(){
		Pozo unPozo= new Pozo();
		Auto unAuto= new Auto();
		Assert.assertEquals(true,unPozo.dejaPasar(unAuto));
	}
	
	@Test
	public void ElPozoDeberiaDejarPasarALosTodoTerreno(){
		Pozo unPozo= new Pozo();
		TodoTerreno unTodoTerreno=new TodoTerreno();
		Assert.assertEquals(true,unPozo.dejaPasar(unTodoTerreno));
	}

}