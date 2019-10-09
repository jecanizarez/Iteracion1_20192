package epsAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import epsAndes.negocio.Servicio;
import uniandes.isis2304.parranderos.negocio.Bebedor;

class SQLServicio {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLServicio(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarServicio(PersistenceManager pm, long id, int capacidad, int horaInicio, int horaFinal, long idTipoServicio)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicio() + "(capacidad, horaInicio, horaFinal, TipoServicio) values (?, ?, ? ,?) ");
		q.setParameters(capacidad, horaInicio, horaFinal, idTipoServicio);
		return (long) q.executeUnique();
	}
	
	public List<Servicio> darServiciosConCapacidadMayorA(PersistenceManager pm, int capacidad)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + " WHERE capacidad > " +capacidad);
		q.setResultClass(Bebedor.class);
		q.setParameters(capacidad);
		return (List<Servicio>) q.executeList();
	}
}
