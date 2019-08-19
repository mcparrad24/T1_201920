package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo() {
		datos = new ArregloDinamico(7);
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * 
	 * @param tamano
	 */
	public MVCModelo(int capacidad) {
		datos = new ArregloDinamico(capacidad);
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo
	 * 
	 * @return numero de elementos presentes en el modelo
	 */
	public void CSVLector() {
		CSVReader reader = null;
		try {
			
			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-All-MonthlyAggregate.csv"));
			for(String[] nextLine : reader) {
		       System.out.println("col1: " + nextLine[0] + ", col2: "+ nextLine[1]);
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
	}
	
	/**
	 * Requerimiento de agregar dato
	 * 
	 * @param dato
	 */
	public int darTotalViajesSemestre() {
		
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
