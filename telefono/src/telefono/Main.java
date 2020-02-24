package telefono;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int op; // Guardaremos la opcion del usuario

		agenda agendaTelefonica = new agenda(3);
		String nombre;
		int numero;

		contacto p;

		while (!salir) {
			System.out.println("+++ Menu telefonico +++");
			System.out.println("");
			System.out.println("1. Añadir contacto");
			System.out.println("2. Existe contacto");
			System.out.println("3. Listar contactos");
			System.out.println("4. Buscar contactos");
			System.out.println("5. Eliminar contacto");
			System.out.println("6. Agenda llena");
			System.out.println("7. Contactos Disponibles");
			System.out.println("8. Salir");
			System.out.println("");
			try {
				System.out.println("Escribe una de las opciones");
				op = sn.nextInt();

				switch (op) {
				// agrego usuario
				case 1:

					// Pido valores
					System.out.println("Ingrese el nombre del contacto");
					nombre = sn.next();

					System.out.println("Ingrese el numero del telefono");
					numero= sn.nextInt();

					// Creo el contacto en el array
					p = new contacto(nombre, numero);

					agendaTelefonica.agregarContacto(p);

					break;
				// Indica si el contacto existe
				case 2:
					// pido el nombre
					System.out.println("Escribe un nombre");
					nombre = sn.next();

					agendaTelefonica.buscarPorNombre(nombre);

					break;
				// Muestra todos los contactos agregados
				case 3:

					agendaTelefonica.listarContactos();

					break;

				// busco el contacto por nombre
				case 4:

					// pido el nombre
					System.out.println("Escribe un nombre");
					nombre = sn.next();

					// Creo el contacto auxiliar para comparar
					p = new contacto(nombre, 0);

					if (agendaTelefonica.existeContacto(p)) {
						System.out.println("Existe contacto");
					} else {
						System.out.println("No existe contacto");
					}

					break;
				// Elimino el contacto ingresado por nombre
				case 5:

					// pido el nombre
					System.out.println("Escribe un nombre");
					nombre = sn.next();

					// Creo el contacto auxiliar
					p = new contacto(nombre, 0);

					agendaTelefonica.eliminarContacto(p);

					break;
				// Indica si la agenda esta llena
				case 6:

					if (agendaTelefonica.agendaLlena()) {
						System.out.println("La agenda esta llena");
					} else {
						System.out.println("Aun puedes meter contactoss");
					}

					break;
				// Reviso cuantos espacios estan libres
				case 7:

					System.out.println("Existen " + agendaTelefonica.espaciosLibre() + " contactos libre");

					break;

				case 8:
					System.out.println("Muchas gracias por utilizar nuestro Software :)");
					salir = true;
					break;
				default:
					System.out.println("Solo números entre 1 y 8");
				}

			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				sn.next();
			}

		}

	}

}