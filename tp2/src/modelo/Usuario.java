package modelo;

public class Usuario {
	private String _nombre;
	private int _interesTango, _interesFolclore, _interesRock, _interesUrbano;

	public Usuario(String _nombre, int _interesTango, int _interesFolclore, int _interesRock, int _interesUrbano) {
		verificarInteresEnRango(_interesTango);
		verificarInteresEnRango(_interesFolclore);
		verificarInteresEnRango(_interesUrbano);
		verificarInteresEnRango(_interesRock);
		verificarNombre(_nombre);
		
		this._nombre = _nombre;
		this._interesTango = _interesTango;
		this._interesFolclore = _interesFolclore;
		this._interesRock = _interesRock;
		this._interesUrbano = _interesUrbano;

	}

	private void verificarNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        if(nombre.isEmpty()) {
        	throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
    }
	
	private void verificarInteresEnRango(int interes) {
		if(interes < 1)
			throw new IllegalArgumentException("El interes no puede ser menor a 1");
		if (interes > 5)
			throw new IllegalArgumentException("El interes no puede ser mayor que 5");	
	}
	
	
	public int calcularIndiceDeSimilaridad(Usuario u) {
		return (
				Math.abs(this._interesTango - u.get_interesTango()) +
				Math.abs(this._interesRock - u.get_interesRock()) + 
				Math.abs(this._interesFolclore - u.get_interesFolclore()) + 
				Math.abs(this._interesUrbano - u.get_interesUrbano())			
				);
	}

	public String get_nombre() {
		return _nombre;
	}

	public int get_interesTango() {
		return _interesTango;
	}

	public int get_interesFolclore() {
		return _interesFolclore;
	}

	public int get_interesRock() {
		return _interesRock;
	}

	public int get_interesUrbano() {
		return _interesUrbano;
	}
	
	
	
}
