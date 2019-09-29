package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLServicioMedico {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLServicioMedico(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarServicioMedico(PersistenceManager pm, long idMedico, long idServicio)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pp.darTablaServicioMedico() + "(idMedico, idServicio) values (?, ?) ");
		q.setParameters(idMedico, idServicio);
		return (long) q.executeUnique();
	}
}
