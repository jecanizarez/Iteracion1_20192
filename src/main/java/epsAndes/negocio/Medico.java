package epsAndes.negocio;

public class Medico extends Usuario implements VOMedico {
	
	
	private long numRegistroMed; 
	
	private String especialidad; 
	
	public Medico(String nombre, long identificacion, String correo, long tipoDocumento, long idRol, long login,  long numRegistroMed, String especialidad) {
		super(nombre, identificacion, correo, tipoDocumento, idRol, login);
	    this.numRegistroMed = numRegistroMed; 
	    this.especialidad = especialidad; 
	}
	public Medico()
	{
	   super(); 
	   numRegistroMed = 0; 
	   especialidad = ""; 
	}
	
	public long getNumRegistroMed() {
		return numRegistroMed;
	}


	public void setNumRegistroMed(long numRegistroMed) {
		this.numRegistroMed = numRegistroMed;
	}


	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public long getIdentificacion()
	{
		return super.getIdentificacion(); 
	}
	
	public String getCorreoElectronico()
	{
		return super.getCorreoElectronico();
	}
	
	public long getIdTipoDocumento()
	{
		return super.getIdTipoDocumento();
	}
	
	public String getNombre()
	{
		return super.getNombre();
	}
	
	public long getIdRol()
	{
		return super.getIdRol();
	}
	
	


	

}
