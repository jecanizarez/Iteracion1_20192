package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLEPS {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLEPS(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarEPS(PersistenceManager pm, long id, String nombre)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaEPS() + "(id, nombre) values (?, ?) ");
		q.setParameters(id, nombre);
		return (long) q.executeUnique();
	}
	
}
