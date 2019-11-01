package epsAndes.persistencia;


import java.math.BigDecimal;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import epsAndes.negocio.Servicio;


class SQLServicio {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLServicio(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarServicio(PersistenceManager pm, int capacidad, int horaInicio, int horaFinal, long idTipoServicio)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicio() + "(capacidad, horaInicio, horaFinal, TipoServicio) values (?, ?, ? ,?) ");
		q.setParameters(capacidad, horaInicio, horaFinal, idTipoServicio);
		return (long) q.executeUnique();
	}
	

	public long darIdUltimoServicio(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT MAX(id) FROM " + pp.darTablaServicio());
		return ((BigDecimal) q.executeUnique()).longValue();
	}


	public List<Servicio> darServiciosConCapacidadMayorA(PersistenceManager pm, int capacidad)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + " WHERE capacidad > " +capacidad);
		q.setResultClass(Servicio.class);
		q.setParameters(capacidad);
		return (List<Servicio>) q.executeList();
	}
}
