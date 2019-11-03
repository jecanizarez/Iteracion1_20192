package epsAndes.negocio;

public class Servicio implements VOServicio{

	private long id; 

	private int capacidad; 

	private int horaInicio;

	private int horaFinal;

	private long TipoServicio;

	private long idIPS;
	
	private String estado;

	private int capacidadActual;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public int getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(int horaFinal) {
		this.horaFinal = horaFinal;
	}
	public long getTipoServicio() {
		return TipoServicio;
	}
	public void setTipoServicio(long tipoServicio) {
		TipoServicio = tipoServicio;
	}
	public long getIdIPS() {
		return idIPS;
	}
	public void setIdIPS(long idIPS) {
		this.idIPS = idIPS;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCapacidadActual() {
		return capacidadActual;
	}
	public void setCapacidadActual(int capacidadActual) {
		this.capacidadActual = capacidadActual;
	}
	public Servicio(long id, int capacidad, int horaInicio, int horaCierre, long idTipoServicio, long ips, String estado, int capacidadActual)
	{
		this.id = id; 
		this.capacidad = capacidad; 
		this.horaInicio = horaInicio;
		this.horaFinal = horaCierre; 
		this.TipoServicio = idTipoServicio;
		this.capacidadActual = capacidadActual;
		this.estado = estado;
		this.idIPS = ips;
	}
	public Servicio()
	{
		capacidad = 0; 
		horaInicio = 0; 
		horaFinal = 0; 
	}




}
