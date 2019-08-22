package controller;

import java.util.*;

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
		ArrayList<String[]> arr = new ArrayList<>();
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		int nume = 0;
		String dato = "";
		String[] datos;
		String sourceID = "", mes = "";

		while (!fin) {
			view.printMenu();

			int option = lector.nextInt();
			switch (option) {
			case 1:
				System.out.println("--------- \nMostrar el total de viajes del primer semestre del año");
				nume = modelo.darTotalViajesSemestre();
				System.out.println("Total de viajes del primer semestre del año " + nume);
				break;

			case 2:
				if (nume == 0) {
					nume = modelo.darTotalViajesSemestre();
				}
				System.out.println(
						"--------- \nConsultar viajes reportados en un mes dado desde una zona de origen \nDar número de mes del primer semestre y el identificador numérico de la zona de origen \nDar el número del mes seguido por una coma y el identificador numérico de la zona de origen(e.g., 1,260): ");
				dato = lector.next();
				datos = dato.split(",");
				mes = datos[0];
				sourceID = datos[1];
				if (modelo.consultarViajesMesYZonaDeOrigen(mes, sourceID).size() == 0) {
					System.out.println("No hay viajes reportados en el mes " + mes + " desde la zona de origen con ID "
							+ sourceID + ".");
				} else {
					arr = modelo.consultarViajesMesYZonaDeOrigen(mes, sourceID);
					System.out.print("Viajes reportados en el mes " + mes + " desde la zona de origen con ID "
							+ sourceID + ": ");
					for (String[] arre : arr) {
						System.out.println(Arrays.toString(arre));
					}
				}
				break;

			case 3:
				if (nume == 0) {
					nume = modelo.darTotalViajesSemestre();
				}
				System.out.println(
						"--------- \nReportar estadísticas "
						+ "\nDar el número del mes seguido por una coma y el identificador numérico de la zona de origen (e.g., 1,260): ");
				dato = lector.next();
				datos = dato.split(",");
				mes = datos[0];
				sourceID = datos[1];
				System.out.println("Total de viajes reportados en el semestre " + nume + "\n---------");
				System.out.println(
						"Total de viajes reportados en el mes de consulta " + modelo.consultarViajesMes(mes).size()
								+ "\nPorcentaje con respecto al total de viajes del semestre: "
								+ modelo.porcentajeViajesMes(mes) + "%\n---------");
				System.out.println(
						"Total de viajes reportados en el mes de consulta saliendo desde la zona de origen de consulta "
								+ modelo.consultarViajesMesYZonaDeOrigen(mes, sourceID).size()
								+ "\nPorcentaje con respecto al total de viajes del mes de consulta: "
								+ modelo.porcentajeViajesMesYZonaDeOrigen(mes, sourceID) + "%\n---------");
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
