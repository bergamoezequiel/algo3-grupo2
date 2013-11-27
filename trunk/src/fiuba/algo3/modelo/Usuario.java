package fiuba.algo3.modelo;

import fiuba.algo3.modelo.mapa.UbicacionEnMapaException;

public class Usuario {

	private String nombre; 
	
	public Usuario (String unNombre) throws NombreDeUsuarioInvalidoException {
		if (unNombre == ""){
			throw new NombreDeUsuarioInvalidoException();
		}
		else{
			this.nombre = unNombre;
		}
	}
	
	public String getNombre(){
		return this.nombre;
	}
}
