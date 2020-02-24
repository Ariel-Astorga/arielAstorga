package telefono;
/**
 * 
 * @author Alumno
 *
 */
public class contacto {
	/**ATRIBUTOS
	 * @param nombre
	 * @param numero 
	 */
	
	private String nombre;
	private int numero;

	// Contructores
	public contacto(String nombre, int numero) {
		this.nombre = nombre;
		this.numero = numero;
	}

	public contacto(String nombre) {
		this.nombre = nombre;
		this.numero = 0;
	}

	// Get and setter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	// comparar
	public boolean equals(contacto p) {
	// si nombre sin espacio es igual a el nombre entregrado retorna verdadero
		if (this.nombre.trim().equalsIgnoreCase(p.getNombre().trim())) {
			return true;
		}

		return false;

	}

	// to String
	@Override
	public String toString() {
		return "nombre: " + nombre + ", numero telefonico es: " + numero;
	}

}