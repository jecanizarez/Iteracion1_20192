package epsAndes.negocio;

public class TipoServicio implements VOTipoServicio{

	private long id; 
	
	private String tipo;
	
	public TipoServicio(long id , String tipo)
	{
		this.id = id;
		this.tipo = tipo; 
	}
	
	public TipoServicio()
	{
		id = 0;
		tipo = "";
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	} 
	
}
