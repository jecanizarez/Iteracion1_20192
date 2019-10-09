package epsAndes.negocio;

public interface VOMedico {

	public long getDocumento(); 
	
    public long getIPS();
	
	public long getNumRegistroMed();
	
	public String getEspecialidad();

	
	@Override
	public String toString(); 
}
