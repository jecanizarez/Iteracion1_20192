package epsAndes.negocio;

public class Servicio implements VOServicio{

	private long id; 
	
	private int capacidad; 
	
	private int horaInicio;
	
	private int horaCierre;
	
	private long idTipoServicio;
	
	private int capacidadActual;
	
	public Servicio(long id, int capacidad, int horaInicio, int horaCierre, long idTipoServicio, int capacidadActual)
	{
		this.id = id; 
		this.capacidad = capacidad; 
		this.horaInicio = horaInicio;
		this.horaCierre = horaCierre; 
		this.idTipoServicio = idTipoServicio;
		this.capacidadActual = capacidadActual;
	}
	public Servicio()
	{
		capacidad = 0; 
		horaInicio = 0; 
		horaCierre = 0; 
	}
	
	
	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(int horaCierre) {
		this.horaCierre = horaCierre;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public long getIdTipoServicio() {
		return idTipoServicio;
	}
	public void setIdTipoServicio(long idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}

	public int getCapacidadActual() {
		return capacidadActual;
	}
	public void setCapacidadActual(int capacidadActual) {
		this.capacidadActual = capacidadActual;
	}
	
	
}
