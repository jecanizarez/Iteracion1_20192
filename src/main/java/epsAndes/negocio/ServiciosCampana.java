package epsAndes.negocio;

public class ServiciosCampana {

	
	private Long idTipoServicio; 
	
	private Long idCampaña;
	
	private Long cantidadReservada;
	
	public ServiciosCampana(Long idTipoServicio, Long idCampana, Long cantidadReservada)
	{
		this.cantidadReservada  = cantidadReservada;
		this.idCampaña = idCampana;
		this.cantidadReservada = cantidadReservada;
	}

	public Long getIdTipoServicio() {
		return idTipoServicio;
	}

	public void setIdTipoServicio(Long idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}

	public Long getIdCampaña() {
		return idCampaña;
	}

	public void setIdCampana(Long idCampaña) {
		this.idCampaña = idCampaña;
	}

	public Long getCantidadReservada() {
		return cantidadReservada;
	}

	public void setCantidadReservada(Long cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
}
