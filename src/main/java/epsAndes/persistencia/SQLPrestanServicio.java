package epsAndes.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.sun.org.apache.bcel.internal.generic.IDIV;

import epsAndes.negocio.Cita;
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
	
	public Long darCapacidadDisponiblePorTipoServicio(PersistenceManager pm, long idTipoServicio)
	{
		
		Query q = pm.newQuery(SQL, "SELECT SUM(capacidadActual)"
				+ " FROM " + pp.darTablaServicio()
				+ " WHERE TipoServicio = ?"
				+ " AND estado = ?"
				+ " GROUP BY TipoServicio");
		q.setParameters(idTipoServicio, "Disponible");
		return ((BigDecimal)q.executeUnique()).longValue();
		
	}
	 
	public Long darCuantasIPSDanServicio(PersistenceManager pm, Long idTipoServicio)
	{
		Query q = pm.newQuery(SQL, "SELECT COUNT(PRESTANSERVICIO.idIPS)"
				+ " FROM " + pp.darTablaPrestanServicio() + ", "
				+ pp.darTablaServicio()
				+ " WHERE SERVICIO.id = PRESTANSERVICIO.idServicio"
				+ " AND Servicio.TipoServicio = ?");
		
        q.setParameters(idTipoServicio);
		return ((BigDecimal)q.executeUnique()).longValue();
	}
	
	public List<Object> darIPSYDisponibilidadDelServicio(PersistenceManager pm, long idTipoServicio)
	{
		String disponible = "Disponible";
		Query q = pm.newQuery(SQL, "SELECT idips, capacidadActual, id"
				+ " FROM " + pp.darTablaServicio()
				+ " WHERE tiposervicio = ? "
				+ " AND estado = ?");
		q.setParameters(idTipoServicio, disponible);
		return q.executeList();
	}
	
	public Cita darUltCita(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT *"
				+ " FROM " + pp.darTablaCita()
		        + " WHERE ID = (SELECT MAX(ID) FROM CITAS)");
		q.setResultClass(Cita.class);
		return (Cita)q.executeUnique();
	}
	
	public List<Object> darNumeroServiciosReservadorPorAfiliado(PersistenceManager pm, Long idAfiliado)
	{
		Query q = pm.newQuery(SQL, "SELECT idServicio, COUNT(idServicio)"
				+ " FROM " + pp.darTablaCita()
				+ " WHERE idAfiliado = ? "
				+ " GROUP BY idServicio,idAfiliado");
		q.setParameters(idAfiliado);
		return q.executeList();
	}
	public List<Object> darServiciosRangoFechas(PersistenceManager pm, String FechaInicio, String FechaFinal, Long idiPS, Long idTipoServicio)
	{
		Query q = pm.newQuery(SQL, "SELECT idServicio, SERVICIO.TIPOSERVICIO, CITAS.ID, CITAS.idAfiliado"
				+ " FROM " + pp.darTablaCita() + ", "+pp.darTablaFecha() + ", "+ pp.darTablaServicio()
				+ " WHERE CITAS.FECHA = FECHA.ID"
				+ " AND SERVICIO.idips = ?"
				+ " AND SERVICIO.ID = CITAS.IDSERVICIO"
				+ " AND SERVICIO.TIPOSERVICIO = ? "
				+ " AND TO_DATE(FECHA.FECHA, 'YYYY-MM-DD') >= TO_DATE(?, 'YYYY-MM-DD')"
				+ " AND TO_DATE(FECHA.FECHA, 'YYYY-MM-DD') <= TO_DATE(?, 'YYYY-MM-DD')");
		q.setParameters(idiPS,idTipoServicio,FechaInicio, FechaFinal);
		return q.executeList();
	}
	public long darIdServicioDiferente(PersistenceManager pm, Long idServicio, Long idTipoServicio)
	{
		Query q = pm.newQuery(SQL, "SELECT id"
				+ " FROM " + pp.darTablaServicio()
				+ " WHERE id NOT IN ? "
				+ " AND TIPOSERVICIO IN ? ");
		q.setParameters(idServicio, idTipoServicio);
		Object respuesta = q.executeUnique();
		if(respuesta != null)
		{
		return ((BigDecimal)respuesta).longValue();
		}
		else
		{
			return -1;
		}
	}
	
	


}
