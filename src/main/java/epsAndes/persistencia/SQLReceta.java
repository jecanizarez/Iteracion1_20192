package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLReceta {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLReceta(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarReceta(PersistenceManager pm, long id, String medicamentos)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pp.darTablaReceta() + "(idUsuario, Descripcion) values (?, ?) ");
		q.setParameters(id, medicamentos);
		return (long) q.executeUnique();
	}
}
