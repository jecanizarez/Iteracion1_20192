package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLFecha {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLFecha(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long AdicionarFecha(PersistenceManager pm,long id, String fecha)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaFecha() + "(id, Fecha) values (?, ?) ");
		q.setParameters(id, fecha);
		return (long) q.executeUnique();
	}
}
