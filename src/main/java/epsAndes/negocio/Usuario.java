package epsAndes.negocio;

public class Usuario implements VOUsuario{

	
	private String nombre; 
	
	private long identificacion; 
	
	
	
	private long idTipoDocumento;
	
	
	private long  idRol; 
	
	private String login;
	
	
	public void setIdentificacion(long identificacion) {
		this.identificacion = identificacion;
	}
	public Usuario(String nombre, long identificacion, long tipoDocumento, long idRol, String login)
	{
		this.nombre = nombre; 
		this.identificacion = identificacion; 
		this.idTipoDocumento = tipoDocumento; 
		this.idRol = idRol;
		this.login = login;
	}
	public Usuario()
	{
		nombre = ""; 
		identificacion = 0;
		idTipoDocumento = 0;
		
		
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getIdentificacion() {
		return identificacion;
	}

	public void setIndentificacion(long indentificacion) {
		this.identificacion = indentificacion;
	}


	
	public String toString()
	{
		return "Usuario  [nombre: " + nombre + ", correo:  " +  "identificacion: " + identificacion + "]";
	}

	public long getIdRol() {
		return idRol;
	}
	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public long getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	
	
}
