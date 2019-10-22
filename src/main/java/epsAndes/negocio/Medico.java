package epsAndes.negocio;

public class Medico implements VOMedico {
	
	
	private long numRegistroMed; 
	
	private long documento; 
	
	private String especialidad; 
	
	private long IPS;
	
	public Medico(long numRegistroMed, long documento,String especialidad, long IPS) 
	{
		
	    this.numRegistroMed = numRegistroMed; 
	    this.documento = documento;
	    this.especialidad = especialidad; 
	    this.IPS = IPS; 
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
	public long getDocumento() {
		return documento;
	}
	public void setDocumento(long documento) {
		this.documento = documento;
	}
	public long getIPS() {
		return IPS;
	}
	public void setIPS(long iPS) {
		IPS = iPS;
	}
	
}
