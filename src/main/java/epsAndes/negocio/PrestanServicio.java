package epsAndes.negocio;

public class PrestanServicio implements VOPrestanServicio{
  
	private long idIPS;
	
	private long idServicio;

	public PrestanServicio(long idIPS, long idServicio)
	{
		this.idIPS = idIPS;
		this.idServicio = idServicio; 
	}
	
	public long getIdIPS() {
		return idIPS;
	}

	public void setIdIPS(long idIPS) {
		this.idIPS = idIPS;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	
}
