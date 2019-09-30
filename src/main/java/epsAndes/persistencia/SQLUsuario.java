 package epsAndes.persistencia;

 import javax.jdo.PersistenceManager;
 import javax.jdo.Query;
 
class SQLUsuario {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLUsuario(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarUsuario(PersistenceManager pm, long id, String login, long idRol, long idTipoDocumento, String nombre, String correoElectronico)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO" + pp.darTablaAfiliado() + "(Login, Rol, Documento, TipoDocumento, Nombre) values (?, ?, ?, ?, ?) ");
		q.setParameters(login, idRol, id, idTipoDocumento, nombre);
		return (long) q.executeUnique();
	}
}
