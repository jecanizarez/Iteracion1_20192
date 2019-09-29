package epsAndes.negocio;

public class TipoDocumento implements VOTipoDocumento {

	private long id;
	
	private String tipoDocumento;

	public TipoDocumento(long id, String tipoDocumento)
	{
		this.id = id; 
		this.tipoDocumento = tipoDocumento; 
	}
	
	public TipoDocumento()
	{
		id = 0; 
		tipoDocumento = "";
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
}
