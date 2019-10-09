package epsAndes.negocio;

public class Afiliado  implements VOAfiliado{
	
	private long documento;

	private long fechaNacimiento;
	
	private  long eps;

	public Afiliado(long documento, long fechaNacimiento, long eps)
	{
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento; 
		this.eps = eps;
	}
	
	public long getIdEps() {
		return eps;
	}

	public void setIdEps(long idEps) {
		this.eps = idEps;
	}
	    
	public long getIdFecha() {
		return fechaNacimiento;
	}

	public void setIdFecha(long idFecha) {
		this.fechaNacimiento = idFecha;
	}

	public long getDocumento() {
		return documento;
	}

	public void setDocumento(long documento) {
		this.documento = documento;
	}

	public long getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(long fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public long getEps() {
		return eps;
	}

	public void setEps(long eps) {
		this.eps = eps;
	}

	
	
}
