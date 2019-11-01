package epsAndes.persistencia;

<<<<<<< HEAD
import java.math.BigDecimal;
=======
>>>>>>> 8b8a37ce94481c0f04fc30b05fe1dc2ae055354a
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import epsAndes.negocio.Servicio;
<<<<<<< HEAD
=======
import uniandes.isis2304.parranderos.negocio.Bebedor;
>>>>>>> 8b8a37ce94481c0f04fc30b05fe1dc2ae055354a

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
	
<<<<<<< HEAD
	public long darIdUltimoServicio(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT MAX(id) FROM " + pp.darTablaServicio());
		return ((BigDecimal) q.executeUnique()).longValue();
	}
	
	public List<Servicio> darServiciosConCapacidadMayorA(PersistenceManager pm, int capacidad)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + " WHERE capacidad > " +capacidad);
		q.setResultClass(Servicio.class);
=======
	public List<Servicio> darServiciosConCapacidadMayorA(PersistenceManager pm, int capacidad)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + " WHERE capacidad > " +capacidad);
		q.setResultClass(Bebedor.class);
>>>>>>> 8b8a37ce94481c0f04fc30b05fe1dc2ae055354a
		q.setParameters(capacidad);
		return (List<Servicio>) q.executeList();
	}
}
