package epsAndes.persistencia;

import epsAndes.negocio.IPS;

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
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaIPS() + "(nombre, localizacion) values (?, ?) ");
		q.setParameters(nombre, localizacion);
		return (long) q.executeUnique();
	}
	public IPS buscarIPSPorNombre(PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIPS() + " WHERE nombre = ?");
		q.setResultClass(IPS.class);
		q.setParameters(nombre);
		return (IPS) q.executeUnique();
	}
	
	public IPS buscarTipoServicioPorNombre(PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIPS() + " WHERE id = ?");
		q.setResultClass(IPS.class);
		q.setParameters(id);
		return (IPS) q.executeUnique();
	}
}
