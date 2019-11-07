package epsAndes.negocio;

public class Cita implements VOCita {

	
	private long id;
	
	private int hora;
	
	private long Fecha;
	
	private long idServicio; 
	
	private long idAfiliado;
	
	private long idRecepcionista;
		
	

	public Cita(long id, int hora, long idFecha, long idServicio, long idAfiliado, long idRecepcionista)
	{
		this.id = id;
		this.idServicio = idServicio;
		this.idAfiliado = idAfiliado; 
		this.Fecha = idFecha; 
		this.hora = hora;
		this.idRecepcionista = idRecepcionista;
	}
	
	public Cita()
	{
		idAfiliado = 0; 
		idServicio = 0; 
        Fecha = 0;
        hora = 0;
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

	public long getIdFecha() {
		return Fecha;
	}

	public void setFecha(long idFecha) {
		this.Fecha = idFecha;
	}
	
	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public long getIdRecepcionista() {
		return idRecepcionista;
	}

	public void setIdRecepcionista(long idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}

	
}
