package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLTrabajan {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLTrabajan(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarTrabajan(PersistenceManager pm, long idEPS, long idIPS)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pp.darTablaTrabajan() + "(idEPS, idIPS) values (?, ?) ");
		q.setParameters(idEPS, idIPS);
		return (long) q.executeUnique();
	}
}
