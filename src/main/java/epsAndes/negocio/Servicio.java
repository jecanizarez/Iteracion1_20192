package epsAndes.negocio;

public class Servicio implements VOServicio{

	private long id; 
	
	private int capacidad; 
	
	private int horaInicio;
	
	private int horaCierre;
	
     
	public Servicio(int capacidad, int horaInicio, int horaCierre)
	{
		this.capacidad = capacidad; 
		this.horaInicio = horaInicio;
		this.horaCierre = horaCierre; 
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
	
	
	
}
