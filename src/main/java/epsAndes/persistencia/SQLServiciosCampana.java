package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import epsAndes.negocio.Cita;
import epsAndes.negocio.ServiciosCampana;

class SQLServiciosCampana{

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLServiciosCampana(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarCampaña(PersistenceManager pm, Long idTipoServicio, Long idCampaña, int cantidad )
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServiciosCampaña() + " (idTipoServicio, idCampana, cantidadReservada) values (?,?,?) ");
		q.setParameters(idTipoServicio, idCampaña, cantidad);
		return (long) q.executeUnique();
	}
	
	public ServiciosCampana darServiciosCampana(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT *"
				+ " FROM " + pp.darTablaServiciosCampaña()
		        + " WHERE ID = (SELECT MAX(ID) FROM SERVICIOSCAMPANA)");
		q.setResultClass(ServiciosCampana.class);
		return (ServiciosCampana)q.executeUnique();
	}
	
	
}
