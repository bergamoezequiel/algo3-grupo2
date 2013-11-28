package fiuba.algo3.modelo.objetosEncontrables;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.objetosEncontrables.Snorlax;
import fiuba.algo3.modelo.vehiculos.*;

public class SnorlaxTest {
	@Test
	public void SnorlaxNoTendriaQuePenalizarALasMotos(){
        Snorlax unSnorlax = new Snorlax();
        Moto unaMoto = new Moto();
        Conductor unConductor = new Conductor(unaMoto, 4);
        unSnorlax.interactuarConMoto(unConductor);
        Assert.assertEquals(0, unConductor.getMovimientos());
	}
	
	@Test
	public void SnorlaxNoTendriaQuePenalizarsALosAutos(){
        Snorlax unSnorlax = new Snorlax();
        Auto unAuto = new Auto();
        Conductor unConductor = new Conductor(unAuto, 4);
        unSnorlax.interactuarConAuto(unConductor);
        Assert.assertEquals(0, unConductor.getMovimientos());
	
	}
	
	@Test
	public void SnorlaxNoTendriaQuePenalizarALosTodoTerreno(){
        Snorlax unSnorlax = new Snorlax();
        TodoTerreno unTodoTerreno = new TodoTerreno();
        Conductor unConductor = new Conductor(unTodoTerreno, 4);
        unSnorlax.interactuarConTodoTerreno(unConductor);
        Assert.assertEquals(0, unConductor.getMovimientos());
	}
	
	@Test
	public void ElSnorlaxDeberiaDejarPasarALasMotos(){
		Snorlax unSnorlax = new Snorlax();
		Moto unaMoto = new Moto();
		Assert.assertEquals(false, unSnorlax.dejaPasar(unaMoto));
	}
	
	@Test
	public void ElSnorlaxDeberiaDejarPasarALosAutos(){
		Snorlax unSnorlax = new Snorlax();
		Auto unAuto = new Auto();
		Assert.assertEquals(false, unSnorlax.dejaPasar(unAuto));
	}
	
	@Test
	public void ElSnorlaxDeberiaDejarPasarALosTodoTerreno(){
		Snorlax unSnorlax = new Snorlax();
		TodoTerreno unTodoTerreno = new TodoTerreno();
		Assert.assertEquals(false, unSnorlax.dejaPasar(unTodoTerreno));
	}

}