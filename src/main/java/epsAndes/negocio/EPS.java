package epsAndes.negocio;

public class EPS implements VOEPS{

	private long id; 
	
	private String nombre;

	public EPS(long id, String nombre)
	{
		this.id = id;
		this.nombre = nombre; 
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
