package fiuba.algo3.implementacion;

import org.junit.Assert;
import org.junit.Test;

public class PiqueteTest {
	@Test
	public void ElPiqueteTendriaQuePenalizarCon2MovimientosALasMotos(){
        Piquete unPiquete= new Piquete();
        Moto unaMoto=new Moto();
        Conductor unConductor= new Conductor(unaMoto);
        unPiquete.InteractuarCon(unConductor,unaMoto);
        Assert.assertEquals(2,unConductor.getMovimientos());

	}

	@Test
	public void ElPiqueteNoTendriaQuePenalizarALosAutos(){
        Piquete unPiquete=new Piquete();
        Auto unAuto=new Auto();
        Conductor unConductor= new Conductor(unAuto);
        unPiquete.InteractuarCon(unConductor,unAuto);
        Assert.assertEquals(0,unConductor.getMovimientos());

	}

	@Test
	public void ElPiqueteNoTendriaQuePenalizarALosTodoTerreno(){
        Piquete unPiquete=new Piquete();
        TodoTerreno unTodoTerreno=new TodoTerreno();
        Conductor unConductor= new Conductor(unTodoTerreno);
        unPiquete.InteractuarCon(unConductor,unTodoTerreno);
        Assert.assertEquals(0,unConductor.getMovimientos());

	}
	public void ElPiqueteDeberiaDejarPasarALasMotos(){
		Piquete unPiquete=new Piquete();
		Moto unaMoto= new Moto();
		Assert.assertEquals(true,unPiquete.dejaPasar(unaMoto));
	}

	public void ElPiqueteNoDeberiaDejarPasarALosAutos(){
		Piquete unPiquete=new Piquete();
		Auto unAuto= new Auto();
		Assert.assertEquals(false,unPiquete.dejaPasar(unAuto));
	}

	public void ElPiqueteNoDeberiaDejarPasarALosTodoTerreno(){
		Piquete unPiquete=new Piquete();
		TodoTerreno unTodoTerreno=new TodoTerreno();
		Assert.assertEquals(false,unPiquete.dejaPasar(unTodoTerreno));
	}

}
