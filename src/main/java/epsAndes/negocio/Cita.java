package epsAndes.negocio;

import java.sql.Date;

public class Cita implements VOCita {

	
	private long id;
	
	private long idServicio; 
	
	private long idAfiliado;
	
	private long idFecha;
	
    private int hora;

	
	public Cita(long id, long idServicio, long idAfiliado, long idFecha, int hora)
	{
		this.id = id;
		this.idServicio = idServicio;
		this.idAfiliado = idAfiliado; 
		this.idFecha = idFecha; 
		this.hora = hora;
	}
	
	public Cita()
	{
		idAfiliado = 0; 
		idServicio = 0; 
        idFecha = 0;
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
		return idFecha;
	}

	public void setIdFecha(long idFecha) {
		this.idFecha = idFecha;
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

	
}
