package epsAndes.negocio;

public class Orden implements VOOrden {

	private long id;
	
	private long idMedico;
	
	private long idServicio; 
	
	private long idAfiliado;

	public Orden(long id, long idMedico, long idServicio, long idAfiliado)
	{
		this.id = id; 
		this.idMedico = idMedico; 
		this.idAfiliado = idAfiliado; 
		this.idServicio = idServicio;
	}
	
	public Orden()
	{
		id = 0; 
		idMedico = 0; 
		idServicio = 0; 
		idAfiliado = 0; 
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(long idMedico) {
		this.idMedico = idMedico;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	public long getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(long idAfiliado) {
		this.idAfiliado = idAfiliado;
	}
	
}
