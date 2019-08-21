package model.data_structures;
import java.util.ArrayList;

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
        
        private Node<T> first;
        
        private Node<T> last;
        
        private Node<T> oldLast;
        
        private int dat = 0;

		public void agregar( T viajeUber )
        {
			if (first == null) {
				first = new Node<T>();
				first.dato = viajeUber;
				System.out.println("Dato "+dat+": "+first.dato);
				dat++;
			}
			else {
				Node<T> nodoActual = first;
				while (nodoActual.next != null) {
					nodoActual = nodoActual.next;
				}
				oldLast = nodoActual;
				last = new Node<T>();
				last.dato = viajeUber;
				System.out.println("Dato "+dat+": "+last.dato);
				oldLast.next = last;
				dat++;
			}
       }

		public int darTamano() {
			int tamano = 0;
			Node<T> nodoActual = first;
			while (nodoActual != null){
				nodoActual = nodoActual.next;
				tamano++;
			}
			return tamano;
		}

		public void eliminar(T viajeUber) {
			Node<T> nodoActual = first;
			boolean eliminado = false;
			if (first.dato == viajeUber) {
				first = first.next;
			}
			else {
				while (first.next != null && !eliminado) {
					if (nodoActual.next.dato == viajeUber) {
						if (nodoActual.next == last) {
							last = nodoActual;
						}
						nodoActual.next = nodoActual.next.next;
						eliminado = true;
					}
					else {
						nodoActual = nodoActual.next;
					}
				}
			}
		}
		
		public ArrayList<T> leer() {
			ArrayList<T> arc = new ArrayList<>();
			Node<T> nodoActual = first; 
	        while (nodoActual != null) { 
	            arc.add(nodoActual.dato);
	            nodoActual = nodoActual.next; 
	        }
	        return arc;
		}
		
		private class Node<T>{
			T dato;
			Node<T> next;
		}
}
