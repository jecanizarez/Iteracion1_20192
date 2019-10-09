package epsAndes.negocio;

public class Usuario implements VOUsuario{

	
	private String login;
	
	private long  rol; 
	
	private long documento; 
	
	private long tipoDocumento;
	
	private String nombre; 
	
	
	public Usuario(String login, long identificacion, long tipoDocumento, long idRol, String nombre)
	{
		this.nombre = nombre; 
		this.documento = identificacion; 
		this.tipoDocumento = tipoDocumento; 
		this.rol = idRol;
		this.login = login;
	}
	public Usuario()
	{
		nombre = ""; 
		documento = 0;
		tipoDocumento = 0;
		
		
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public long getRol() {
		return rol;
	}
	public void setRol(long rol) {
		this.rol = rol;
	}
	public long getDocumento() {
		return documento;
	}
	public void setDocumento(long documento) {
		this.documento = documento;
	}
	public long getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(long tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString()
	{
		return "Usuario  [nombre: " + nombre + ", correo:  " +  "identificacion: " + documento + "]";
	}

	
	
	
}
