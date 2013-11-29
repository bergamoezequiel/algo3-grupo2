package fiuba.algo3.modelo.objetosEncontrables;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.coordenadas.*;
import fiuba.algo3.modelo.objetosEncontrables.Piquete;
import fiuba.algo3.modelo.vehiculos.*;

public class PiqueteTest {
	@Test
	public void ElPiqueteTendriaQuePenalizarCon2MovimientosALasMotos(){
		Piquete unPiquete = new Piquete();
		Moto unaMoto = new Moto();
		Conductor unConductor = new Conductor(unaMoto, new Derecha(), 4);
		unPiquete.interactuarConMoto(unConductor);
		Assert.assertEquals(2, unConductor.getMovimientos());
	}

	@Test
	public void ElPiqueteNoTendriaQuePenalizarALosAutos(){
		Piquete unPiquete = new Piquete();
		Auto unAuto = new Auto();
		Conductor unConductor = new Conductor(unAuto, new Derecha(), 4);
		unPiquete.interactuarConAuto(unConductor);
		Assert.assertEquals(0, unConductor.getMovimientos());

	}

	@Test
	public void ElPiqueteNoTendriaQuePenalizarALosTodoTerreno(){
		Piquete unPiquete = new Piquete();
		TodoTerreno unTodoTerreno = new TodoTerreno();
		Conductor unConductor = new Conductor(unTodoTerreno, new Derecha(), 4);
		unPiquete.interactuarConTodoTerreno(unConductor);
		Assert.assertEquals(0, unConductor.getMovimientos());
	}
	
	@Test
	public void ElPiqueteDeberiaDejarPasarALasMotos(){
		Piquete unPiquete = new Piquete();
		Moto unaMoto = new Moto();
		Assert.assertEquals(true, unPiquete.dejaPasar(unaMoto));
	}

	@Test
	public void ElPiqueteNoDeberiaDejarPasarALosAutos(){
		Piquete unPiquete = new Piquete();
		Auto unAuto = new Auto();
		Assert.assertEquals(false, unPiquete.dejaPasar(unAuto));
	}

	@Test
	public void ElPiqueteNoDeberiaDejarPasarALosTodoTerreno(){
		Piquete unPiquete = new Piquete();
		TodoTerreno unTodoTerreno = new TodoTerreno();
		Assert.assertEquals(false, unPiquete.dejaPasar(unTodoTerreno));
	}
}
