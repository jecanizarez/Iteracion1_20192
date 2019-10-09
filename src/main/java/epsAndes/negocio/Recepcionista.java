package epsAndes.negocio;

public class Recepcionista  implements VORecepcionista{

	private long documento;
	
	private long IPS;
     
	

	public Recepcionista(long documento, long IPS)
	{
	  this.documento = documento;
	  this.IPS = IPS;
	}
	
	public long getDocumento() {
		return documento;
	}

	public void setDocumento(long documento) {
		this.documento = documento;
	}

	public long getIPS() {
		return IPS;
	}

	public void setIPS(long iPS) {
		IPS = iPS;
	}
	

	
}
