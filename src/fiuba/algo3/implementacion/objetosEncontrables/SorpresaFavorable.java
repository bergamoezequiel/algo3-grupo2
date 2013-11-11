package fiuba.algo3.implementacion.objetosEncontrables;

import fiuba.algo3.implementacion.vehiculos.Auto;
import fiuba.algo3.implementacion.vehiculos.Conductor;
import fiuba.algo3.implementacion.vehiculos.Moto;
import fiuba.algo3.implementacion.vehiculos.TodoTerreno;

public class SorpresaFavorable extends Sorpresa {
	double penalizacion;
	
	public SorpresaFavorable() {
		super();
		this.penalizacion = 0.2;
	}
	
	
	/*
	 * En caso de que el producto de los movimientos con el porcentaje de la penalizacion
	 * sea menor a 1, se le agrega siempre 1 movimiento extra.
	 */
	@Override
	public void interactuarCon(Conductor unConductor, Moto unaMoto) {
		int penalizacionADescontar = ((int) Math.round(unConductor.getMovimientos()*this.penalizacion));
		
		if (penalizacionADescontar < 1){
			unConductor.disminuirMovimientosEn(1);
		} else{
			unConductor.disminuirMovimientosEn (penalizacionADescontar);
		}
	}
	

	
	/*
	 * En caso de que el producto de los movimientos con el porcentaje de la penalizacion
	 * sea menor a 1, se le agrega siempre 1 movimiento extra.
	 */
	@Override
	public void interactuarCon(Conductor unConductor, Auto unAuto) {
		int penalizacionADescontar = ((int) Math.round(unConductor.getMovimientos()*this.penalizacion));
		
		if (penalizacionADescontar < 1){
			unConductor.disminuirMovimientosEn(1);
		} else{
			unConductor.disminuirMovimientosEn (penalizacionADescontar);
		}
	}
	
	
	
	/*
	 * En caso de que el producto de los movimientos con el porcentaje de la penalizacion
	 * sea menor a 1, se le agrega siempre 1 movimiento extra.
	 */
	@Override
	public void interactuarCon(Conductor unConductor, TodoTerreno unTodoTerreno){
	/*Redondea el valor a un numero entero*/
		int penalizacionADescontar = ((int) Math.round(unConductor.getMovimientos()*this.penalizacion));
		
		if (penalizacionADescontar < 1){
			unConductor.disminuirMovimientosEn(1);
		} else{
			unConductor.disminuirMovimientosEn (penalizacionADescontar);
		}
	}
		
	

	/*No Afecta al Paso de Vehiculos*/
	
	@Override
	public boolean dejaPasar(Moto unaMoto) {
		return true;
	}


	@Override
	public boolean dejaPasar(Auto unAuto) {
		return true;
	}


	@Override
	public boolean dejaPasar(TodoTerreno unTodoTerreno) {
		return true;
	}
}


