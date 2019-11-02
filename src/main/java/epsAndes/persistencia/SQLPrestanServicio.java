package epsAndes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.sun.org.apache.bcel.internal.generic.IDIV;

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

	public List<Object> darCantidadDeServiciosPrestadorPorUnaIps(PersistenceManager pm, String fechaInicial, String fechaFinal)
	{
		Query q = pm.newQuery(SQL, "SELECT IPS, COUNT(idTipoServicio)"
				+ " FROM "+ pp.darTablaServiciosAfiliado() + ", " + pp.darTablaServicio()
				+ " WHERE"
				+ " TO_DATE(fechaAsistida, 'YYYY-MM-DD') >= TO_DATE(?, 'YYYY-MM-DD')"
				+ " AND TO_DATE(fechaAsistida, 'YYYY-MM-DD') <= TO_DATE(?, 'YYYY-MM-DD')"
				+ " GROUP BY IPS");
		q.setParameters(fechaInicial,fechaFinal);
		return q.executeList();

	}
	public List<Object> darLos20ServiciosMasSolicitados(PersistenceManager pm, String fechaInicial, String fechaFinal)
	{

		Query q = pm.newQuery(SQL, "SELECT idTipoServicio, COUNT(idAfiliado) "
				+ "FROM "+ pp.darTablaServiciosAfiliado()
				+ " WHERE TO_DATE(fechaAsistida, 'YYYY-MM-DD') >= TO_DATE(?, 'YYYY-MM-DD')"
				+ " AND TO_DATE(fechaAsistida, 'YYYY-MM-DD') <= TO_DATE(?, 'YYYY-MM-DD')"
				+ " GROUP BY idTipoServicio"
				+ " ORDER BY COUNT(idAfiliado) DESC"
				+ " FETCH NEXT 20 ROWS ONLY");
		q.setParameters(fechaInicial,fechaFinal);
		return q.executeList();

	}
	public List<Object> darServiciosAfiliado(PersistenceManager pm, long idAfiliado, String fechaInicial, String fechaFinal)
	{
		Query q = pm.newQuery(SQL, "SELECT DISTINCT idTipoServicio, COUNT(idAfiliado) "
				+ "FROM "+ pp.darTablaServiciosAfiliado()
				+ " WHERE idAfiliado = ?"
				+ " AND TO_DATE(fechaAsistida, 'YYYY-MM-DD') >= TO_DATE(?, 'YYYY-MM-DD')"
				+ " AND TO_DATE(fechaAsistida, 'YYYY-MM-DD') <= TO_DATE(?, 'YYYY-MM-DD')"
				+ " GROUP BY idTipoServicio");
		q.setParameters(idAfiliado, fechaInicial, fechaFinal);
		return q.executeList();
	}
	public List<Object> darCantidadDeServicios(PersistenceManager pm)
	{

		Query q = pm.newQuery(SQL, "SELECT TipoServicio, SUM(capacidad)"
				+ " FROM " + pp.darTablaServicio()
				+ " GROUP BY TipoServicio");
		return q.executeList();

	}

	public List<Object> darCantidadServiciosPrestados(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT idTipoServicio, COUNT(idAfiliado)"
				+ " FROM " + pp.darTablaServiciosAfiliado()
				+ " GROUP BY idTipoServicio");
		return q.executeList();

	}


}
