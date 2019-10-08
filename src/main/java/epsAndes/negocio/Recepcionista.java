package epsAndes.negocio;

public class Recepcionista extends Usuario implements VORecepcionista{

	private long idIPS;
     
	public Recepcionista(String nombre, long identificacion, long tipoDocumento, long idRol,String login,  long idIPS)
	{
	  super(nombre, identificacion, tipoDocumento, idRol, login); 	
	  
	  this.idIPS = idIPS;
	}
	
	public long getIdIPS() {
		return idIPS;
	}

	public void setIdIPS(long idIPS) {
		this.idIPS = idIPS;
	}
	

	
}
