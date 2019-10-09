package epsAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import epsAndes.negocio.ServiciosAfiliado;

class SQLPrestanServicio {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLPrestanServicio(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarPrestanServicio(PersistenceManager pm, long idIPS, long idServicio)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPrestanServicio() + " (idIPS, idServicio) VALUES (?, ?) ");
		q.setParameters(idIPS, idServicio);
		return (long) q.executeUnique();
	}
	
	public long darCantidadDeServiciosPrestadorPorUnaIps(PersistenceManager pm, String fechaInicial, long IPS, String fechaFinal)
	{
		Query q = pm.newQuery(SQL, "SELECT COUNT(idTipoServicio) FROM "+ pp.darTablaServiciosAfiliado()
				+ "WHERE IPS = ?"
				+ " AND CAST(fechaAsistida AS date) >= CAST("+ fechaInicial+ " AS date)+ "
				+ " AND CAST(fechaAsistida AS date) <= CAST("+fechaFinal  +" AS date)"
			    + " GROUP BY IPS");
		q.setParameters(IPS);
		return (long) q.executeUnique();

	}
}
