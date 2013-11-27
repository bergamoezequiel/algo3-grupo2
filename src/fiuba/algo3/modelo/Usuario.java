package fiuba.algo3.modelo;

public class Usuario {

	private String nombre; 
	
	@Override
	public boolean equals (Object unObjeto) {
		boolean sonIguales = false;
		
		if (unObjeto instanceof Usuario) {
			Usuario unUsuario = (Usuario) unObjeto;
			if ( this.getNombre() == unUsuario.getNombre() ) {
				sonIguales = true;
			}
		}
		return sonIguales;
	}
	
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
