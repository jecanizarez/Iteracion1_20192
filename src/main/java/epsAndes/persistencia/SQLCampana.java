package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

class SQLCampana{

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLCampana(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarCampaña(PersistenceManager pm, String nombre, Long idOrganizador )
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCampaña() + " (nombre, idOrganizador) values (?, ?) ");
		q.setParameters(nombre, idOrganizador);
		return (long) q.executeUnique();
	}
	
	public List<Object> buscarCampañaPorNombre(PersistenceManager pm, String nombre )
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampaña() + " WHERE nombre = ?");
		q.setParameters(nombre);
		return q.executeList();
	}
}
