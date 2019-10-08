package epsAndes.negocio;

public class Afiliado extends Usuario implements VOAfiliado{
	
	private  long idEps;
	
	private long idFecha;
	
	public Afiliado(String nombre, long identificacion, long tipoDocumento, long idRol, String login, long idEps, long idFecha)
	{
		super(nombre, identificacion, tipoDocumento, idRol, login);
		this.idEps = idEps; 
		this.idFecha = idFecha; 
	}
	
	public Afiliado()
	{
		super();
	}
	

	public long getIdEps() {
		return idEps;
	}

	public void setIdEps(long idEps) {
		this.idEps = idEps;
	}
	
	public long getIdRol()
	{
		return super.getIdRol();
	}
	
	public long getId()
	{
		return super.getIdentificacion();
	}
	
    
	public long getIdFecha() {
		return idFecha;
	}

	public void setIdFecha(long idFecha) {
		this.idFecha = idFecha;
	}


	
	
}
