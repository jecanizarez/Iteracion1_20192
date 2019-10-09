package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import epsAndes.negocio.Rol;
import uniandes.isis2304.parranderos.negocio.Bebedor;

class SQLServiciosAfiliado {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLServiciosAfiliado(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarServiciosAfiliado(PersistenceManager pm, long idTipoServicio, long idAfiliado)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServiciosAfiliado() + "(idServicio, idAfiliado) values (?,?) ");
		q.setParameters(idTipoServicio, idAfiliado);
		return (long) q.executeUnique();
	}
	
}