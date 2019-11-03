package epsAndes.persistencia;


import java.math.BigDecimal;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import epsAndes.negocio.Rol;
import epsAndes.negocio.Servicio;


class SQLServicio {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLServicio(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarServicio(PersistenceManager pm, int capacidad, int horaInicio, int horaFinal, long idTipoServicio, long IPS)
	{
		
		String estado = "Disponible";
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicio() + "(capacidad, horaInicio, horaFinal, TipoServicio, idIPS, Estado, CapacidadActual) values (?, ?, ? ,?, ?, ?, ?) ");
		q.setParameters(capacidad, horaInicio, horaFinal, idTipoServicio, IPS, estado, capacidad);
		return (long) q.executeUnique();
	}
	

	public long darIdUltimoServicio(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT MAX(id) FROM " + pp.darTablaServicio());
		return ((BigDecimal) q.executeUnique()).longValue();
	}


	public List<Object> darServiciosConCapacidadMayorA(PersistenceManager pm, int capacidad)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + " WHERE capacidad > " +capacidad);
		q.setParameters(capacidad);
		return q.executeList();
	}
	
	public Servicio darServicioPorId(PersistenceManager pm, Long id)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + " WHERE id = ?");
		q.setResultClass(Servicio.class);
		q.setParameters(id);
		return (Servicio) q.executeUnique();
	}
	
	public void actualizarCapacidadActualServicio(PersistenceManager pm, Long id)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio() + " SET capacidadActual = capacidadActual-1 WHERE id = ?");
		q.setParameters(id);
		q.executeUnique();
	}
	public void aumentarCapacidadActualServicio(PersistenceManager pm, Long id, int cantidad)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio() + " SET capacidadActual = capacidadActual+ " +cantidad+ " WHERE id = ?");
		q.setParameters(id);
		q.executeUnique();
	}
	public void deshabilitarServicioDeSalud(PersistenceManager pm, Long id)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio() + " SET estado = ?  WHERE id = ?");
		q.setParameters("Deshabiliado",id);
		q.executeUnique();
	}
	
	public void habilitarServicioDeSalud(PersistenceManager pm, Long idTipoServicio)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio() + " SET estado = ?  WHERE TipoServicio = ?"
				+ " AND estado = ?");
		q.setParameters("Disponible",idTipoServicio,"Deshabilitado");
		q.executeUnique();
	}
	
	
}
