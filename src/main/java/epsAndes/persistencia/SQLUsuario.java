 package epsAndes.persistencia;

 import javax.jdo.PersistenceManager;
 import javax.jdo.Query;

import epsAndes.negocio.Usuario;
import uniandes.isis2304.parranderos.negocio.Bar;
 
class SQLUsuario {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLUsuario(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarUsuario(PersistenceManager pm, long id, String login, long idRol, long idTipoDocumento, String nombre, String correoElectronico)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaUsuario() + "(Login, Rol, Documento, TipoDocumento, Nombre) values (?, ?, ?, ?, ?) ");
		q.setParameters(login, idRol, id, idTipoDocumento, nombre);
		return (long) q.executeUnique();
	}
	
	public Usuario buscarUsuarioPorLogin(PersistenceManager pm,String login)
	{
		System.out.println(pp.darTablaUsuario());
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario() + " WHERE login = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(login);
		return (Usuario) q.executeUnique();
	}
}
