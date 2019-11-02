package epsAndes.negocio;

public class ServiciosCampaña {

	
	private Long idTipoServicio; 
	
	private Long idCampaña;
	
	private Long cantidadReservada;
	
	public ServiciosCampaña(Long idTipoServicio, Long idCampaña, Long cantidadReservada)
	{
		this.cantidadReservada  = cantidadReservada;
		this.idCampaña = idCampaña;
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

	public void setIdCampaña(Long idCampaña) {
		this.idCampaña = idCampaña;
	}

	public Long getCantidadReservada() {
		return cantidadReservada;
	}

	public void setCantidadReservada(Long cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
}
