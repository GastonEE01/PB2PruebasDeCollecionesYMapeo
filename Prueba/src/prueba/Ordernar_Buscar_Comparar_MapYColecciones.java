package prueba;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ordernar_Buscar_Comparar_MapYColecciones {

	public static void main(String[] args) {
		
		Maquina maquina = new Maquina();
		
		//Ordenar por map
		Persona persona1 = new Persona("Gaston",4);
		Persona persona2 = new Persona("Adri",6);
		Persona persona3 = new Persona("Jorge",1);
		
		maquina.agregarPorMap(persona1);
		maquina.agregarPorMap(persona2);
		maquina.agregarPorMap(persona3);
		
		maquina.ordernarPorMap();
		
		//Ordernar por  HastSet
		maquina.agregarPorCollecionSet(persona1);
		maquina.agregarPorCollecionSet(persona2);
		maquina.agregarPorCollecionSet(persona3);
		
		maquina.ordernarPorColeccionSet();
		
		// Ordernar por TreeSet
		maquina.agregarPorCollecionTree(persona1);
		maquina.agregarPorCollecionTree(persona2);
		maquina.agregarPorCollecionTree(persona3);

		maquina.ordernarPorColeccionTree();
				
		/**********************Buscar********************************************/
		System.out.println("La persona encontrada por Map es: " + maquina.buscarEnMap(persona1.getNombre()));
		System.out.println("La persona encontrada por HasSet es: " + maquina.buscarEnHashSet(persona1.getNombre()));
		System.out.println("La persona encontrada por TreeSet es: " + maquina.buscarEnHashSet("Pepe"));
		
		
	}
}



