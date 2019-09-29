package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLAfiliado {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLAfiliado(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarAfiliado(PersistenceManager pm, long idUsuario,long idFecha, long idEps )
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pp.darTablaAfiliado() + "(DOCUMENTO, FECHANACIMIENTO, EPS) values (?, ?, ?) ");
		q.setParameters(idUsuario, idFecha, idEps);
		return (long) q.executeUnique();
	}
	
}
