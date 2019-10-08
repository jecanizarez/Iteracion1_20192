package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import epsAndes.negocio.IPS;
import epsAndes.negocio.Usuario;

class SQLIPS {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLIPS(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarIPS(PersistenceManager pm, long id, String nombre, String localizacion)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaIPS() + "(id, nombre, localizacion) values (?, ?, ?) ");
		q.setParameters(id, nombre, localizacion);
		return (long) q.executeUnique();
	}
	public IPS buscarIPSPorNombre(PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIPS() + " WHERE nombre = ?");
		q.setResultClass(IPS.class);
		q.setParameters(nombre);
		return (IPS) q.executeUnique();
	}
}
