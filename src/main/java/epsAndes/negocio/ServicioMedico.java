package epsAndes.negocio;

public class ServicioMedico implements VOServicioMedico{
	
    private long idMedico;
    
    private long idServicio;

    
    public ServicioMedico(long idMedico, long idServicio)
    {
    	this.idMedico = idMedico; 
    	this.idServicio = idServicio; 
    }
    
    public ServicioMedico()
    {
    	idMedico = 0;
    	idServicio = 0;
    }
	public long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(long idMedico) {	
		this.idMedico = idMedico;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
    
}
