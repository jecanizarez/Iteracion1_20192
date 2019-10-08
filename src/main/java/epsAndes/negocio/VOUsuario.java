package epsAndes.negocio;

public interface VOUsuario {

	public long getIdentificacion();
	
	public String getNombre();
	
	public long getIdTipoDocumento();
	
	public long getIdRol();
	
	public String getLogin();
	@Override
	public String toString(); 
}
