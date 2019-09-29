package epsAndes.negocio;

public class Rol implements VORol{

	private long id;
	
	private String rol;

	public Rol(long id, String rol)
	{
		this.id = id; 
		this.rol = rol; 
	}
	
	public Rol()
	{
		id = 0; 
		rol = ""; 
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	} 
	
}
