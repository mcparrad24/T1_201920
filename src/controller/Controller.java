package controller;

import java.util.Scanner;

import model.logic.MVCModelo;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo */
	private MVCModelo modelo;

	/* Instancia de la Vista */
	private MVCView view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * 
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller() {
		view = new MVCView();
		modelo = new MVCModelo();
	}

	public void run() {
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String []datos;
		int mes = 0;
		String sourceID = "";

		while (!fin) {
			view.printMenu();

			int option = lector.nextInt();
			switch (option) {
			case 1:
				System.out.println("--------- \nMostrar el total de viajes del primer semestre del año \nDar capacidad inicial del arreglo: ");
				System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");
				break;

			case 2:
				System.out.println("--------- \nConsultar viajes reportados en un mes dado desde una zona de origen \nDar número de mes del primer semestre y el identificador númerico de la zona de origen \nDar el número del mes seguido por una coma y el identificador númerico de la zona de origen(e.g., 1, 260): ");
				dato = lector.next();
				datos = dato.split(",");
				mes = Integer.parseInt(datos[0]);
				sourceID = datos[1];
				modelo.agregar(dato);
				System.out.println("Dato agregado");
				System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");
				break;

			case 3:
				System.out.println("--------- \nReportar estadísticas \nDar número de mes del primer semestre y el identificador númerico de la zona de origen \nDar el número del mes seguido por una coma y el identificador númerico de la zona de origen (e.g., 1, 260): ");
				dato = lector.next();
				datos = dato.split(",");
				mes = Integer.parseInt(datos[0]);
				sourceID = datos[1];
				System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");
				break;

			case 4:
				System.out.println("--------- \n Hasta pronto !! \n---------");
				lector.close();
				fin = true;
				break;

			default:
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}
}
