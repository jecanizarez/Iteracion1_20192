package epsAndes.negocio;

public interface VOServicio {

	public int getCapacidad();
	
	public int getHoraInicio();
	
	public int getHoraCierre();
	
	public long getId(); 
	
	@Override
	public String toString(); 
}
