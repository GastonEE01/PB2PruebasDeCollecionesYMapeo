package prueba;

public class Persona implements Comparable<Persona>  {

	private String nombre;
	private Integer DNI;
	
	public Persona(String nombre,Integer DNI) {
		this.nombre = nombre;
		this.DNI = DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDNI() {
		return DNI;
	}

	public void setDNI(Integer dNI) {
		DNI = dNI;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", DNI=" + DNI + "]";
	}

	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
        return this.getDNI() - o.getDNI();
	}

}
