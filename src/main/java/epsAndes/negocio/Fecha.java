package epsAndes.negocio;

import java.sql.Date;

public class Fecha implements VOFecha{
    
	public long id;
	
	public String fecha;

	public Fecha(long id, String fecha)
	{
		this.id = id; 
		this.fecha = fecha;
	}
	
	public Fecha()
	{
		id = 0;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	
}
