package epsAndes.negocio;

public class Campana {
 
	private Long id;
	
	private String nombre;
	
	private Long idOrganizador;
	


	public Campana(Long id, String nombre, Long idOrganizador)
	{
		this.id = id;
		this.nombre = nombre;
		this.idOrganizador = idOrganizador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Long getIdOrganizador() {
		return idOrganizador;
	}

	public void setIdOrganizador(Long idOrganizador) {
		this.idOrganizador = idOrganizador;
	}
	
	
	
}
