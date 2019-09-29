package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLTipoDocumento {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLTipoDocumento(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarTipoDocumento(PersistenceManager pm, long id, String tipo)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pp.darTablaTipoDocumento() + "(Id, tipoDocumento) values (?, ?) ");
		q.setParameters(id, tipo);
		return (long) q.executeUnique();
	}
}
