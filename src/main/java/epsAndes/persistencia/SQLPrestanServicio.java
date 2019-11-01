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
	
	public long darCantidadDeServiciosPrestadorPorUnaIps(PersistenceManager pm, String fechaInicial, long IPS, String fechaFinal)
	{
		Query q = pm.newQuery(SQL, "SELECT COUNT(idTipoServicio)"
				+ " FROM "+ pp.darTablaServiciosAfiliado()
				+ " WHERE IPS = ?"
				+ " AND TO_DATE(fechaAsistida, 'YYYY-MM-DD') >= TO_DATE(?, 'YYYY-MM-DD')"
				+ " AND TO_DATE(fechaAsistida, 'YYYY-MM-DD') <= TO_DATE(?, 'YYYY-MM-DD')"
			    + " GROUP BY IPS");
		q.setParameters(IPS,fechaInicial,fechaFinal);
		return ((BigDecimal) q.executeUnique()).longValue();

	}
	public List<Object> darLos20ServiciosMasSolicitados(PersistenceManager pm, String fechaInicial, String fechaFinal)
	{
		
		Query q = pm.newQuery(SQL, "SELECT idTipoServicio, COUNT(idAfiliado) "
				+ "FROM "+ pp.darTablaServiciosAfiliado()
<<<<<<< HEAD
				+ " WHERE CAST(fechaAsistida AS date) >= CAST("+ fechaInicial+ " AS date) ?"
				+ " AND CAST(fechaAsistida AS date) <= CAST("+fechaFinal  +" AS date)"
			    + " GROUP BY idTipoServicio"
				+ " ORDER BY COUNT(idAfiliado) DESC"
			    + " FETCH NEXT 20 ROWS ONLY");
		
=======
				+ " WHERE TO_DATE(fechaAsistida, 'YYYY-MM-DD') >= TO_DATE(?, 'YYYY-MM-DD')"
				+ " AND TO_DATE(fechaAsistida, 'YYYY-MM-DD') <= TO_DATE(?, 'YYYY-MM-DD')"
			    + " GROUP BY idTipoServicio"
				+ " ORDER BY COUNT(idAfiliado) DESC"
			    + " FETCH NEXT 20 ROWS ONLY");
		q.setParameters(fechaInicial,fechaFinal);
>>>>>>> 8b8a37ce94481c0f04fc30b05fe1dc2ae055354a
		return q.executeList();

	}
	public List<Object> darServiciosAfiliado(PersistenceManager pm, long idAfiliado, String fechaInicial, String fechaFinal)
	{
		Query q = pm.newQuery(SQL, "SELECT idTipoServicio "
				+ "FROM "+ pp.darTablaServiciosAfiliado()
				+ "WHERE idAfiliado = ?"
				+ " AND CAST(fechaAsistida AS date) >= CAST("+ fechaInicial+ " AS date) ?"
				+ " AND CAST(fechaAsistida AS date) <= CAST("+fechaFinal  +" AS date)");
		q.setParameters(idAfiliado);
		return q.executeList();
	}
	
}
