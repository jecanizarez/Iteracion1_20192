package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLRecepcionista {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLRecepcionista(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarRecepcionista(PersistenceManager pm, long idUsuario, long idIPS)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaRecepcionista() + "(documento, IPS) values (?, ?) ");
		q.setParameters(idUsuario, idIPS);
		return (long) q.executeUnique();
	}
}
