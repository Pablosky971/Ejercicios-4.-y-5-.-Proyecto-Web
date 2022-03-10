package modelo.entidad;

// La convenci�n JavaBean dice que los atributos son privados y tienen m�todos accesores y modificadores para trabajar con ellos.

// El m�todo accesor empieza por get y luego se pone el atributo en camelcase
public class Persona {
	
	private String nombre;
	private String apellido;
	private int peso;
	
	
	
	


	


	public Persona() {
		super();
	}

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", peso=" + peso + "]";
	}
	}
