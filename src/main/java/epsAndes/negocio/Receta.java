package epsAndes.negocio;

public class Receta implements VOReceta {

    private long id; 
	
    private long afiliado;
    
	private String medicamentos;

	public Receta(String medicamentos)
	{
		this.medicamentos = medicamentos;
	}
	public Receta()
	{
		medicamentos = "";
	}
	
	public long getAfiliado() {
		return afiliado;
	}
	public void setAfiliado(long afiliado) {
		this.afiliado = afiliado;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

}
