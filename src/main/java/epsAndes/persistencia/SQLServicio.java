package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLServicio {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLServicio(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarServicio(PersistenceManager pm, long id, int capacidad, int horaInicio, int horaFinal, long idTipoServicio)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicio() + "(capacidad, horaInicio, horaFinal, TipoServicio) values (?, ?, ? ,?) ");
		q.setParameters(capacidad, horaInicio, horaFinal, idTipoServicio);
		return (long) q.executeUnique();
	}
}
