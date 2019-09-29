package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLTipoServicio {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLTipoServicio(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarTipoServicio(PersistenceManager pm, long id, String tipo)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pp.darTablaAfiliado() + "(id, tipo) values (?, ?) ");
		q.setParameters(id, tipo);
		return (long) q.executeUnique();
	}
}
