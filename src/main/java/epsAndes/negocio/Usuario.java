package epsAndes.negocio;

public class Usuario implements VOUsuario{

	
	private String login;
	
	private long  rol; 
	
	private long documento; 
	
	private long tipoDocumento;
	
	private String nombre; 
	
	
	public void setIdentificacion(long identificacion) {
		this.documento = identificacion;
	}
	public Usuario(String nombre, long identificacion, long tipoDocumento, long idRol, String login)
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

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getIdentificacion() {
		return documento;
	}

	public void setIndentificacion(long indentificacion) {
		this.documento = indentificacion;
	}


	
	public String toString()
	{
		return "Usuario  [nombre: " + nombre + ", correo:  " +  "identificacion: " + documento + "]";
	}

	public long getIdRol() {
		return rol;
	}
	public void setIdRol(long idRol) {
		this.rol = idRol;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public long getIdTipoDocumento() {
		return tipoDocumento;
	}
	public void setIdTipoDocumento(long idTipoDocumento) {
		this.tipoDocumento = idTipoDocumento;
	}
	
	
}
