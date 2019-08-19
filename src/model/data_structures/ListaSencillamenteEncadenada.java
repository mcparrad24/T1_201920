package model.data_structures;

import sun.font.CreatedFontTracker;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ListaSencillamenteEncadenada<T> implements IListaSencillamenteEncadenada<T> {
	
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        
        private Node first;
        
        private Node last;
        
        private Node oldLast;

		public void agregar( T viajeUber )
        {
			if (first == null) {
				first = new Node();
				first.dato = viajeUber;
			}
			else {
				Node nodoActual = first;
				while (first.next != null) {
					nodoActual = nodoActual.next;
				}
				oldLast = nodoActual;
				last = new Node();
				last.dato = viajeUber;
				oldLast.next = last;
			}
       }

		public int darTamano() {
			int tamaño = 0;
			Node nodoActual = first;
			while (first != null){
				nodoActual = nodoActual.next;
				tamaño++;
			}
			return tamaño;
		}

		public String darElemento(int i) {
			// TODO implementar
			return null;
		}

		public String buscar(String dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			return null;
		}

		public String eliminar(String dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			return null;
		}

		@Override
		public String modificar(String dato, int posicion) {
			// TODO Auto-generated method stub
			return null;
		}
		
		private class Node{
			T dato;
			Node next;
		}

}
