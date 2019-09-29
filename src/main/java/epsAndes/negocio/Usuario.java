package epsAndes.negocio;

public class Usuario implements VOUsuario{

	
	private String nombre; 
	
	private long identificacion; 
	
	private String correoElectronico;
	
	private long idTipoDocumento;
	
	
	private long  idRol; 
	
	private long login;
	
	
	public void setIdentificacion(long identificacion) {
		this.identificacion = identificacion;
	}
	public Usuario(String nombre, long identificacion, String correo, long tipoDocumento, long idRol, long login)
	{
		this.nombre = nombre; 
		this.identificacion = identificacion; 
		correoElectronico = correo; 
		this.idTipoDocumento = tipoDocumento; 
		this.idRol = idRol;
		this.login = login;
	}
	public Usuario()
	{
		nombre = ""; 
		identificacion = 0;
		correoElectronico = "";
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

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	public String toString()
	{
		return "Usuario  [nombre: " + nombre + ", correo: " + correoElectronico + ", identificacion: " + identificacion + "]";
	}

	public long getIdRol() {
		return idRol;
	}
	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}
	
	public long getLogin() {
		return login;
	}
	public void setLogin(long login) {
		this.login = login;
	}
	
	public long getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	
	
}
