package epsAndes.negocio;

public class Trabajan implements VOTrabajan{
    
	private long idEPS;
	
	private long idIPS;

	public Trabajan(long idEPS, long idIPS)
	{
		this.idEPS = idEPS;
		this.idIPS = idIPS; 
	}
	
	public Trabajan()
	{
		idIPS = 0; 
		idEPS = 0; 
	}
	
	public long getIdEPS() {
		return idEPS;
	}

	public void setIdEPS(long idEPS) {
		this.idEPS = idEPS;
	}

	public long getIdIPS() {
		return idIPS;
	}

	public void setIdIPS(long idIPS) {
		this.idIPS = idIPS;
	}
	
     
}
