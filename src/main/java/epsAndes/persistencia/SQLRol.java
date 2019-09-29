package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLRol {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLRol(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarRol(PersistenceManager pm, long id, String rol)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pp.darTablaRol() + "(id, rol) values (?, ?) ");
		q.setParameters(id, rol);
		return (long) q.executeUnique();
	}
}
