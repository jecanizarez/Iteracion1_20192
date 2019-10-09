package epsAndes.negocio;

public class ServiciosAfiliado {

	
	private long idServicio;	
	
	private long idAfiliado;
	
	
	
	public ServiciosAfiliado(long idServicio, long idAfiliado)
	{
		this.idServicio = idServicio; 
		this.idAfiliado = idAfiliado;
	}

	public long getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(long idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	
	
}
