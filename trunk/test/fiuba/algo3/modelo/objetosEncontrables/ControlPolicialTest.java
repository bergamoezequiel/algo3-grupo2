package fiuba.algo3.modelo.objetosEncontrables;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.objetosEncontrables.ControlPolicial;
import fiuba.algo3.modelo.vehiculos.Auto;
import fiuba.algo3.modelo.vehiculos.Conductor;
import fiuba.algo3.modelo.vehiculos.Moto;
import fiuba.algo3.modelo.vehiculos.TodoTerreno;
import fiuba.algo3.implementacion.objetosEncontrables.*;
public class ControlPolicialTest {
	
	@Test
	public void ElControlPolicialTendriaQuePenalizarCon3MovimientosALasMotosDependiendoDelNumeroAleatorio(){
        ControlPolicial unControl = new ControlPolicial();
        Moto unaMoto=new Moto();
        Conductor unConductor= new Conductor(unaMoto, 4);
        
        /*Tendria que penalizar si el numero aleatorio es menor o igual a 0.7*/
        
       NumeroAleatorio aleatorio= new NumeroAleatorioFalso(0.1);
       unControl.interactuarConMoto(unConductor,aleatorio);
       Assert.assertEquals(3,unConductor.getMovimientos());
        
       aleatorio= new NumeroAleatorioFalso(0.2);
       unControl.interactuarConMoto(unConductor,aleatorio);
       Assert.assertEquals(6,unConductor.getMovimientos());
       
       aleatorio= new NumeroAleatorioFalso(0.3);
       unControl.interactuarConMoto(unConductor,aleatorio);
       Assert.assertEquals(9,unConductor.getMovimientos());
       
       aleatorio= new NumeroAleatorioFalso(0.4);
       unControl.interactuarConMoto(unConductor,aleatorio);
       Assert.assertEquals(12,unConductor.getMovimientos());
       
       aleatorio= new NumeroAleatorioFalso(0.5);
       unControl.interactuarConMoto(unConductor,aleatorio);
       Assert.assertEquals(15,unConductor.getMovimientos());
       
       aleatorio= new NumeroAleatorioFalso(0.6);
       unControl.interactuarConMoto(unConductor,aleatorio);
       Assert.assertEquals(18,unConductor.getMovimientos());
       
       aleatorio= new NumeroAleatorioFalso(0.7);
       unControl.interactuarConMoto(unConductor,aleatorio);
       Assert.assertEquals(21,unConductor.getMovimientos());
       
       /*No tendria que penalizar si el numero aleatorio es mayor a 0.7*/ 
       
       aleatorio= new NumeroAleatorioFalso(0.8);
       unControl.interactuarConMoto(unConductor,aleatorio);
       Assert.assertEquals(21,unConductor.getMovimientos());
       
       aleatorio= new NumeroAleatorioFalso(0.9);
       unControl.interactuarConMoto(unConductor,aleatorio);
       Assert.assertEquals(21,unConductor.getMovimientos());
	}
	
	@Test
	public void ElControlPolicialTendriaQuePenalizarCon3MovimientosALosAutosDependiendoDelNumeroAleatorio(){
		ControlPolicial unControl = new ControlPolicial();
        Auto unAuto=new Auto();
        Conductor unConductor= new Conductor(unAuto, 4);
        
        /*Tendria que penalizar si el numero aleatorio es menor o igual a 0.5*/
        NumeroAleatorio aleatorio= new NumeroAleatorioFalso(0.1);
        unControl.interactuarConAuto(unConductor,aleatorio);
        Assert.assertEquals(3,unConductor.getMovimientos());
        
        aleatorio= new NumeroAleatorioFalso(0.2);
        unControl.interactuarConAuto(unConductor,aleatorio);
        Assert.assertEquals(6,unConductor.getMovimientos());
        
        aleatorio= new NumeroAleatorioFalso(0.3);
        unControl.interactuarConAuto(unConductor,aleatorio);
        Assert.assertEquals(9,unConductor.getMovimientos());
        
        aleatorio= new NumeroAleatorioFalso(0.4);
        unControl.interactuarConAuto(unConductor,aleatorio);
        Assert.assertEquals(12,unConductor.getMovimientos());
        
        aleatorio= new NumeroAleatorioFalso(0.5);
        unControl.interactuarConAuto(unConductor,aleatorio);
        Assert.assertEquals(15,unConductor.getMovimientos());
	
        /*No tendria que penalizar si el numero aleatorio es mayor a 0.5*/
        
        aleatorio= new NumeroAleatorioFalso(0.6);
        unControl.interactuarConAuto(unConductor,aleatorio);
        Assert.assertEquals(15,unConductor.getMovimientos());
        
        aleatorio= new NumeroAleatorioFalso(0.7);
        unControl.interactuarConAuto(unConductor,aleatorio);
        Assert.assertEquals(15,unConductor.getMovimientos());
        
        aleatorio= new NumeroAleatorioFalso(0.8);
        unControl.interactuarConAuto(unConductor,aleatorio);
        Assert.assertEquals(15,unConductor.getMovimientos());
        
        aleatorio= new NumeroAleatorioFalso(0.9);
        unControl.interactuarConAuto(unConductor,aleatorio);
        Assert.assertEquals(15,unConductor.getMovimientos());
	}
	
	@Test
	public void ElControlPolicialTendriaQuePenalizarCon3MovimientosALosTodoTerrenoDependiendoDelNumeroAleatorio(){
		ControlPolicial unControl = new ControlPolicial();
        TodoTerreno unTodoTerreno=new TodoTerreno();
        Conductor unConductor= new Conductor(unTodoTerreno, 4);
        
        /*Tendria que penalizar si el numero aleatorio es menor o igual a 0.3*/
        
        NumeroAleatorio aleatorio= new NumeroAleatorioFalso(0.1);
        unControl.interactuarConTodoTerreno(unConductor,aleatorio);
        Assert.assertEquals(3,unConductor.getMovimientos());
         
        aleatorio= new NumeroAleatorioFalso(0.2);
        unControl.interactuarConTodoTerreno(unConductor,aleatorio);
        Assert.assertEquals(6,unConductor.getMovimientos());
        
        aleatorio= new NumeroAleatorioFalso(0.3);
        unControl.interactuarConTodoTerreno(unConductor,aleatorio);
        Assert.assertEquals(9,unConductor.getMovimientos());
        
        /*No tendria que penalizar si el numero aleatorio es mayor a 0.3*/ 
        
        aleatorio= new NumeroAleatorioFalso(0.4);
        unControl.interactuarConTodoTerreno(unConductor,aleatorio);
        Assert.assertEquals(9,unConductor.getMovimientos());
        
        aleatorio= new NumeroAleatorioFalso(0.5);
        unControl.interactuarConTodoTerreno(unConductor,aleatorio);
        Assert.assertEquals(9,unConductor.getMovimientos());
        
        aleatorio= new NumeroAleatorioFalso(0.6);
        unControl.interactuarConTodoTerreno(unConductor,aleatorio);
        Assert.assertEquals(9,unConductor.getMovimientos());
        
        aleatorio= new NumeroAleatorioFalso(0.7);
        unControl.interactuarConTodoTerreno(unConductor,aleatorio);
        Assert.assertEquals(9,unConductor.getMovimientos());
        
        
        aleatorio= new NumeroAleatorioFalso(0.8);
        unControl.interactuarConTodoTerreno(unConductor,aleatorio);
        Assert.assertEquals(9,unConductor.getMovimientos());
        
        aleatorio= new NumeroAleatorioFalso(0.9);
        unControl.interactuarConTodoTerreno(unConductor,aleatorio);
        Assert.assertEquals(9,unConductor.getMovimientos());
	}
	
	@Test
	public void elControlPolicialTendriaQueDejarPasarALosAutos(){
		ControlPolicial unControlPolicial = new ControlPolicial();
		Auto unAuto = new Auto();
		
		Assert.assertTrue (unControlPolicial.dejaPasar(unAuto));		
		
	}
	
	@Test
	public void elControlPolicialTendriaQueDejarPasarALasMotos(){
		ControlPolicial unControlPolicial = new ControlPolicial();
		Moto unaMoto = new Moto();
		
		Assert.assertTrue (unControlPolicial.dejaPasar(unaMoto));		
		
	}
	@Test
	public void elControlPolicialTendriaQueDejarPasarALosTodoTerrenos(){
		ControlPolicial unControlPolicial = new ControlPolicial();
		TodoTerreno unTodoTerreno = new TodoTerreno();
		
		Assert.assertTrue (unControlPolicial.dejaPasar(unTodoTerreno));			
	}

}