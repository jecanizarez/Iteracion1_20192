package epsAndes.persistencia;

import epsAndes.negocio.Rol;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLRol {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLRol(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	/**
	 * Metodo para registrar un rol
	 * @param pm
	 * @param rol
	 * @return
	 */
	public long adicionarRol(PersistenceManager pm, String rol)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaRol() + "(rol) values (?) ");
		q.setParameters(rol);
		// Arreglo para manejo del error:
		return (long) q.executeUnique();
	}
	
	public Rol buscaRolNombre(PersistenceManager pm, String rol)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRol() + " WHERE ROL = ?");
		q.setResultClass(Rol.class);
		q.setParameters(rol);
		return (Rol) q.executeUnique();
	}
	
	
}