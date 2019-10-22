package epsAndes.negocio;

public class ServiciosAfiliado {

	
	private long idServicio;	
	
	private long idAfiliado;
	
	private String fechaAsistida;
	
	private long IPS;
	
	
	
	public ServiciosAfiliado(long idServicio, long idAfiliado, String fechaAsistida,long IPS)
	{
		this.idServicio = idServicio; 
		this.idAfiliado = idAfiliado;
		this.fechaAsistida = fechaAsistida;
		this.IPS = IPS;
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
	
	public String getFechaAsistida() {
		return fechaAsistida;
	}

	public void setFechaAsistida(String fechaAsistida) {
		this.fechaAsistida = fechaAsistida;
	}

	public long getIPS() {
		return IPS;
	}

	public void setIPS(long iPS) {
		IPS = iPS;
	}

	
}
