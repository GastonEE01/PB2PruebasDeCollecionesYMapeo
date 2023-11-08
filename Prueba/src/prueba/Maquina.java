package prueba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Maquina {
	private Map<String,Integer> personasMapTRE;
	private Map<String,Integer> personasMapSET;
	private Set<Persona> hasset;
	private Set<Persona> treeset;
	
	public Maquina() {
		this.personasMapSET = new HashMap<String, Integer>();
		this.personasMapTRE = new TreeMap<String, Integer>();
		this.hasset = new HashSet<Persona>();
		this.treeset = new TreeSet<Persona>();
	}

	public void agregarPorMap(Persona persona1) {
		this.personasMapSET.put(persona1.getNombre(), persona1.getDNI());
	}

	/*
	 * Ordenar los elementos en un Mappor sus valores, necesitará una lógica personalizada, ya que los mapas en Java no mantienen un orden basado en sus valores. 
	 */
	public void ordernarPorMap() {
	    List<Map.Entry<String, Integer>> list = new LinkedList<>(personasMapSET.entrySet());

	    // Utilizamos un Comparator para comparar por valores
	    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	            return (o1.getValue()).compareTo(o2.getValue());
	        }
	    });

	    // Convertimos la lista ordenada nuevamente en un Map
	    Map<String, Integer> mapaOrdenado = new LinkedHashMap<>();
	    for (Map.Entry<String, Integer> entry : list) {
	        mapaOrdenado.put(entry.getKey(), entry.getValue());
	    }

	    // Imprimimos el mapa ordenado
	    System.out.println("Mapa ordenado por DNI:");
	    for (Map.Entry<String, Integer> entry : mapaOrdenado.entrySet()) {
	        System.out.println(entry.getKey() + ": " + entry.getValue());
	    }
	}

	public void agregarPorCollecionSet(Persona persona1) {
		this.hasset.add(persona1);
		
	}
	
	/*
	 * Si quieres ordenar los elementos en un HashSet, necesitas convertirlo a una lista y luego usar un Comparator para definir el criterio de ordenación.
	 * No es necesario que la clase implemente Comparableni que sobrescriba equals()o hashCode().
	 */
	public void ordernarPorColeccionSet() {
	    List<Persona> listaOrdenada = new ArrayList<>(this.hasset);

	    Collections.sort(listaOrdenada, new Comparator<Persona>() {
	        @Override
	        public int compare(Persona persona1, Persona persona2) {
	        	//Menor a mayor persona1 - persona2 ,mayor persona2 - persona1
	            return persona1.getDNI() - persona2.getDNI();
	        }
	    });

	    // Imprimimos la lista ordenada
	    System.out.println("Lista ordenada por DNI:");
	    for (Persona persona : listaOrdenada) {
	        System.out.println(persona.getNombre() + ": " + persona.getDNI());
	    }
		
	}

		public void agregarPorCollecionTree(Persona persona1) {
			this.treeset.add(persona1);
			
		}

		public void ordernarPorColeccionTree() {
		    // Como el TreeSet ya está ordenado por DNI, no es necesario realizar ninguna operación adicional.
			//NoordernarPorColeccionTree()porque unTreeSetse mantiene ordenado automáticamente segúnPersona.
			//RecuerdacompareTo()en la clase `Personadebeequals(). Además, si sobrescribeequals(),hashCode()
			for(Persona persona : this.treeset) {
				System.out.println(persona.toString());
			}
			
		}

	/****************************BUSCAR***************************************************************/
		public Persona buscarEnMap(String nombre) {
			Integer dni = this.personasMapSET.get(nombre);
			    if (dni != null) {
			        return new Persona(nombre, dni);
			    } else {
			        return null; // Si no se encuentra el nombre en el mapa
			    }
			}

		
		//, Set<Persona> treeSet
		public Persona buscarEnTreeSet(String nombre) {
		    for (Persona persona : this.treeset) {
		        if (persona.getNombre().equals(nombre)) {
		            return persona;
		        }
		    }
		    return null; // Si no se encuentra el nombre en el TreeSet
		}
		
		public Persona buscarEnHashSet(String nombre) {
		    for (Persona persona : this.hasset) {
		        if (persona.getNombre().equals(nombre)) {
		            return persona;
		        }
		    }
		    return null; // Si no se encuentra el nombre en el HashSet
		}

		//Nota: Recuerde que Comparablese utiliza para definir el orden natural de un objeto, mientras que Comparatorproporciona una forma externa de comparar objetos.
		 
		
}
