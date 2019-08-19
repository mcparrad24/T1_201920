package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import model.data_structures.ListaSencillamenteEncadenada;
import model.data_structures.IListaSencillamenteEncadenada;

/**
 * Definicion del modelo del mundo
 * @param <T>
 *
 */
public class MVCModelo<T> {
	/**
	 * Atributos del modelo del mundo
	 */
	private IListaSencillamenteEncadenada<T> datos;
	
	/**
	 * Me falta añadir los datos a la lista
	 * 
	 * @return numero de elementos presentes en el modelo
	 */
	private int CSVLector() {
		CSVReader reader = null;
		int total = 0;
		try {
			
			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-1-All-MonthlyAggregate.csv"));
			for(String[] nextLine : reader) {
		       System.out.println("col1: " + nextLine[0] + ", col2: "+ nextLine[1] + ", col3: "+ nextLine[2] + ", col4: "+ nextLine[3] + ", col5: "+ nextLine[4] + ", col6: "+ nextLine[5] + ", col7: "+ nextLine[6]);
		       total++;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
		reader = null;
		try {
			
			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-All-MonthlyAggregate.csv"));
			for(String[] nextLine : reader) {
		       System.out.println("col1: " + nextLine[0] + ", col2: "+ nextLine[1] + ", col3: "+ nextLine[2] + ", col4: "+ nextLine[3] + ", col5: "+ nextLine[4] + ", col6: "+ nextLine[5] + ", col7: "+ nextLine[6]);
		       total++;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
		return total;
	}
	
	/**
	 * Requerimiento de agregar dato
	 * 
	 * @param dato
	 */
	public int darTotalViajesSemestre() {
		int totalviajes = this.CSVLector();
		return totalviajes;
	}
	
	public ArrayList<String> consultarViajesMesYZonaDeOrigen(int mes, String sourceID) {
	}
	
	public ArrayList<String> consultarViajesMes(int mes) {
		
	}
	
	public double porcentajeViajesMes(int mes) {
		
	}
	
	public double porcentajeViajesMesYZonaDeOrigen (int mes, String sourceID) {
		
	}

}
