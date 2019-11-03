package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import epsAndes.negocio.Cita;
import epsAndes.negocio.Fecha;
import epsAndes.negocio.Rol;

class SQLFecha {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLFecha(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long AdicionarFecha(PersistenceManager pm, String fecha)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaFecha() + " (Fecha) values (?) ");
		q.setParameters(fecha);
		return (long) q.executeUnique();
	}
	
	public Fecha buscarFecha(PersistenceManager pm, String fecha)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaFecha() + " WHERE FECHA = ?");
		q.setResultClass(Fecha.class);
		q.setParameters(fecha);
		return (Fecha) q.executeUnique();
	}
	
	public Fecha buscarFechaId(PersistenceManager pm, long id)
	{

		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaFecha() + " WHERE id = ?");
		q.setResultClass(Fecha.class);
		q.setParameters(id);
		return (Fecha) q.executeUnique();
	}
	
	public Fecha darUltFecha(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT *"
				+ " FROM " + pp.darTablaFecha()
		        + " WHERE ID = (SELECT MAX(ID) FROM FECHA)");
		q.setResultClass(Fecha.class);
		return (Fecha)q.executeUnique();
	}
}
