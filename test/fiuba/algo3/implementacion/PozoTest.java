package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;

public class PozoTest {
	@Test
	public void ElPozoTendriaQuePenalizarCon3MovimientosALasMotos(){
        Pozo unPozo= new Pozo();
        Moto unaMoto=new Moto();
        Conductor unConductor= new Conductor(unaMoto);
        unPozo.InteractuarCon(unConductor,unaMoto);
        Assert.assertEquals(3,unConductor.getMovimientos());
	
	}
	
	@Test
	public void ElPozoTendriaQuePenalizarCon3MovimientosALosAutos(){
        Pozo unPozo= new Pozo();
        Auto unAuto=new Auto();
        Conductor unConductor= new Conductor(unAuto);
        unPozo.InteractuarCon(unConductor,unAuto);
        Assert.assertEquals(3,unConductor.getMovimientos());
	
	}
	
	@Test
	public void ElPozoNoTendriaQuePenalizarALosTodoTerreno(){
        Pozo unPozo= new Pozo();
        TodoTerreno unTodoTerreno=new TodoTerreno();
        Conductor unConductor= new Conductor(unTodoTerreno);
        unPozo.InteractuarCon(unConductor,unTodoTerreno);
        Assert.assertEquals(0,unConductor.getMovimientos());
	
	}
	public void ElPozoDeberiaDejarPasarALasMotos(){
		Pozo unPozo= new Pozo();
		Moto unaMoto= new Moto();
		Assert.assertEquals(true,unPozo.dejaPasar(unaMoto));
	}
	
	public void ElPozoDeberiaDejarPasarALosAutos(){
		Pozo unPozo= new Pozo();
		Auto unAuto= new Auto();
		Assert.assertEquals(true,unPozo.dejaPasar(unAuto));
	}
	
	public void ElPozoDeberiaDejarPasarALosTodoTerreno(){
		Pozo unPozo= new Pozo();
		TodoTerreno unTodoTerreno=new TodoTerreno();
		Assert.assertEquals(true,unPozo.dejaPasar(unTodoTerreno));
	}

}