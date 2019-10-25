package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import epsAndes.negocio.Rol;
import epsAndes.negocio.TipoServicio;

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
	
	public TipoServicio buscarTipoServicioPorNombre(PersistenceManager pm, String nombre)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipoServicio() + " WHERE TIPO = ?");
		q.setResultClass(TipoServicio.class);
		q.setParameters(nombre);
		return (TipoServicio) q.executeUnique();
	}
	
	public TipoServicio buscarTipoServicioPorId(PersistenceManager pm, Long id)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipoServicio() + " WHERE id = ?");
		q.setResultClass(TipoServicio.class);
		q.setParameters(id);
		return (TipoServicio) q.executeUnique();
	}
	
}
