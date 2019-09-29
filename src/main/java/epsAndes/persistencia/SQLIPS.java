package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLIPS {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLIPS(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarIPS(PersistenceManager pm, long id, String nombre, String localizacion)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pp.darTablaIPS() + "(id, nombre, localizacion) values (?, ?, ?) ");
		q.setParameters(id, nombre, localizacion);
		return (long) q.executeUnique();
	}
}
