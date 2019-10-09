package epsAndes.negocio;

public class Orden implements VOOrden {
	
	
	private long idAfiliado;
	
	private long idMedico;
	
	private long tipoServicio; 
	
	

	public Orden( long idMedico, long idServicio, long idAfiliado)
	{
		this.idMedico = idMedico; 
		this.idAfiliado = idAfiliado; 
		this.tipoServicio = idServicio;
	}
	
	public Orden()
	{
		idMedico = 0; 
		tipoServicio = 0; 
		idAfiliado = 0; 
	}
	
	public long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(long idMedico) {
		this.idMedico = idMedico;
	}

	public long getIdServicio() {
		return tipoServicio;
	}

	public void setIdServicio(long idServicio) {
		this.tipoServicio = idServicio;
	}

	public long getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(long idAfiliado) {
		this.idAfiliado = idAfiliado;
	}
	
}
