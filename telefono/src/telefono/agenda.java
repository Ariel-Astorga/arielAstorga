package telefono;
/**
 * en esta clase agenda estan definidos los constructores y los metodos 
 * @author MAtias, Claudia,Ariel
 * @vercion 1.0
 * 
 */
public class agenda {
	/**
	 *en este arreglo contacto almacenamos los contactos ingresados por el usuario (nombre y numero) 
	 */
	private contacto[] contactos;

	/**
	 * Constructor donde el arreglo contactos es declarado y se le da un valor por defecto
	 */
	public agenda() {
		this.contactos = new contacto[15]; // por defecto
	}
	/**
	 * en este constructor el arreglo recive un largo dado por el usuario
	 * @param largo
	 */

	public agenda(int largo) {
		this.contactos = new contacto[largo];
		// largo que nosotros queramos
	}
	/**
	 * este es un metodo donde se agrega un contacto nuevo a nuestro arreglo.
	 * Se utilizara un 
	 * 
	 * 
	 * @param p
	 */

	public void agregarContacto(contacto p) {

		if (existeContacto(p)) { // Indico si existe el contacto
			System.out.println("El contacto con ese nombre ya existe");
		} else if (agendaLlena()) { // Indico si la agenda esta o no llena
			System.out.println("La agenda esta llena");
		} else {

			boolean encontrado = false;
			for (int i = 0; i < contactos.length && !encontrado; i++) {
				if (contactos[i] == null) { // controlo los nulos
					contactos[i] = p; // Inserto el contacto
					encontrado = true; // Indico que lo he encontrado
				}
			}

			if (encontrado) {
				System.out.println("Se ha añadido");
			} else {
				System.out.println("No se ha podido añadir");
			}
		}

	}

	public boolean existeContacto(contacto p) {

		for (int i = 0; i < contactos.length; i++) {
			// Controlo vacios e indico si el contacto es el mismo
			if (contactos[i] != null && p.equals(contactos[i])) {
				return true;
			}
		}
		return false;

	}


	// Lista los contactos de la agenda
	public void listarContactos() {

		if (espaciosLibre() == contactos.length) {
			System.out.println("No hay contactos que mostrar");
		} else {
			for (int i = 0; i < contactos.length; i++) {
				if (contactos[i] != null) {
					System.out.println(contactos[i]);
				}
			}
		}

	}

	/**
	 * Busca un contacto por su nombre
	 *
	 * 
	 */
    public void buscarPorNombre(String nombre) {
    	 
        boolean encontrado = false;
        for (int i = 0; i < contactos.length && !encontrado; i++) {
            //Controlo nulos y compruebo que es el contacto buscado (forma mas engorrosa)
            if (contactos[i] != null && contactos[i].getNombre().trim().equalsIgnoreCase(nombre.trim())) {
                System.out.println("Su telefono es " + contactos[i].getNumero()); //muestro el telefono
                encontrado = true; //Indico que lo he encontrado
            }
        }
 
        if (!encontrado) {
            System.out.println("No se ha encontrado el contacto");
        }
 
    }

	public boolean agendaLlena() {

		for (int i = 0; i < contactos.length; i++) {
			if (contactos[i] == null) {
				return false;
			}
		}

		return true;
		// reviso que contactos no este vacia, en el caso contrario respondo que esta
		// llena

	}

	public void eliminarContacto(contacto p) {

		boolean encontrado = false;
		for (int i = 0; i < contactos.length && !encontrado; i++) {
			if (contactos[i] != null && contactos[i].equals(p)) {
				contactos[i] = null;
				encontrado = true;
			}
		}

		if (encontrado) {
			System.out.println("Se ha eliminado el contacto");
		} else {
			System.out.println("No se ha eliminado el contacto");

		}

	}

	public int espaciosLibre() {

		int contadorLibres = 0;
		for (int i = 0; i < contactos.length; i++) {
			if (contactos[i] == null) {
				contadorLibres++;
			}

		}
		return contadorLibres;
	}
}
