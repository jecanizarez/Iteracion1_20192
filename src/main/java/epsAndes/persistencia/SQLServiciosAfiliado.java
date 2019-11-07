package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

class SQLServiciosAfiliado {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLServiciosAfiliado(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarServiciosAfiliado(PersistenceManager pm, long idTipoServicio, long idAfiliado, String fecha, long IPS)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServiciosAfiliado() + "(idTipoServicio, idAfiliado, fechaAsistida, IPS) values (?,?,?,?) ");
		q.setParameters(idTipoServicio, idAfiliado, fecha, IPS);
		return (long) q.executeUnique();
	}
	
	public List<Object> darAfiliadosExigentes(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT idAfiliado, COUNT(DISTINCT idTipoServicio ), COUNT(idTipoServicio)"
				+ " FROM " + pp.darTablaServiciosAfiliado()
				+ " GROUP BY idAfiliado"
				+ " HAVING COUNT(DISTINCT idTipoServicio ) >= 3"
				+ " AND COUNT(idTipoServicio) >= 12 ");
		return q.executeList();
	}
	
	
}