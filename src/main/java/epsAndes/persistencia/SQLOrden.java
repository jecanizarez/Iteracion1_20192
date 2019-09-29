package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLOrden {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLOrden(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarOrden(PersistenceManager pm, long idAfiliado, long idMedico, long idTipoServicio)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pp.darTablaOrden() + "(idAfiliado, idMedico, TipoServicio) values (?, ?, ?) ");
		q.setParameters(idAfiliado, idMedico, idTipoServicio);
		return (long) q.executeUnique();
	}
}
