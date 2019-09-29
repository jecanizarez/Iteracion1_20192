package epsAndes.negocio;

public class IPS implements VOIPS{

	private String localizacion; 

	private String nombre;
	
	private long id;

	public IPS(String localizacion, String nombre, long id)
	{
		this.localizacion = localizacion;
		this.nombre = nombre;
		this.id =  id; 
	}

	public IPS()
	{
		localizacion = ""; 
		nombre = "";
		id = 0; 
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
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
