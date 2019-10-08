package epsAndes.negocio;

public interface VOMedico {

	public long getIdentificacion(); 
	
	public String getNombre(); 
	
	public long getNumRegistroMed();
	
	public String getEspecialidad();
	
	public long getIdTipoDocumento();
	
	public long getIdRol();
	
	@Override
	public String toString(); 
}
