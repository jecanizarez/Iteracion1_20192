package epsAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.sun.xml.internal.bind.v2.model.core.ID;

import epsAndes.negocio.Cita;

class SQLCita {

		private final static String SQL = PersistenciaEpsAndes.SQL;
		
		private PersistenciaEpsAndes pp;
		
		public SQLCita(PersistenciaEpsAndes pp)
		{
			this.pp = pp;
		}
		
		public long adicionarCita(PersistenceManager pm, int hora, long idFecha, long idServicio, long idAfiliado, long idRecepcionista ) 
		{
			Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCita() + " (hora, Fecha, idServicio, idAfiliado, idRecepcionista) values (?, ?, ?, ?, ?) ");
			q.setParameters(hora, idFecha, idServicio, idAfiliado, idRecepcionista);
			return (long) q.executeUnique();
		}
		
		public void eliminarCitas(PersistenceManager pm, Long idAfiliado, Long idTipoServicio)
		{
			Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCita() + " WHERE idAfiliado = ? "
					+ " AND idServicio = ?");
			q.setParameters(idAfiliado, idTipoServicio);
            q.executeUnique();
		}
		
		public List<Object> darUltFechaYHoraDeTipoServicio(PersistenceManager pm, Long idTipoServicio)
		{
			String disponible = "Disponible";
			Query q = pm.newQuery(SQL, "SELECT SERVICIO.ID,FECHA, HORA, MAX(CITAS.ID)"
					+ " FROM " + pp.darTablaCita()
					+ ", " + pp.darTablaServicio()
					+ " WHERE SERVICIO.ID = CITAS.IDSERVICIO "
					+ " AND SERVICIO.TipoServicio = ?"
					+ " AND SERVICIO.Estado = ?"
					+ " GROUP BY SERVICIO.ID, FECHA, hora");
			q.setParameters(idTipoServicio, disponible);
			return q.executeList();
		}
		public void eliminarCitaPorId(PersistenceManager pm, Long idCita)
		{
			Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCita() + " WHERE id = ? ");
			q.setParameters(idCita);
            q.executeUnique();
		}
		public Cita darCitaPorId(PersistenceManager pm, Long idCita)
		{
			Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCita() + " WHERE id = ? ");
			q.setParameters(idCita);
		    q.setResultClass(Cita.class);
            return (Cita)q.executeUnique();
		}
		public List<Object> darServiciosMasSolicitadorPorAño(PersistenceManager pm, Long idTipoServicio	)
		{
			Query q = pm.newQuery(SQL, "SELECT to_number(to_char(TO_DATE(FECHA.FECHA,'YYYY-MM-DD'), 'YY')), tipoServicio, COUNT(idServicio) "
					+ " FROM " + pp.darTablaCita() + ", " + pp.darTablaFecha() + ", " + pp.darTablaServicio()
					+ " WHERE CITAS.idServicio = SERVICIO.ID"
					+ " AND CITAS.FECHA = FECHA.ID"
					+ " AND TipoServicio = ?"
					+ " GROUP BY TipoServicio, to_number(to_char(TO_DATE(FECHA.FECHA,'YYYY-MM-DD'), 'YY'))"
					+ " ORDER BY COUNT(idServicio) DESC");
			q.setParameters(idTipoServicio);
			return q.executeList();
		}
		public List<Object> darServiciosMenosSolicitadorPorAño(PersistenceManager pm, Long idTipoServicio	)
		{
			Query q = pm.newQuery(SQL, "SELECT to_number(to_char(TO_DATE(FECHA.FECHA,'YYYY-MM-DD'), 'YY')), tipoServicio, COUNT(idServicio) "
					+ " FROM " + pp.darTablaCita() + ", " + pp.darTablaFecha() + ", " + pp.darTablaServicio()
					+ " WHERE CITAS.idServicio = SERVICIO.ID"
					+ " AND CITAS.FECHA = FECHA.ID"
					+ " AND TipoServicio = ?"
					+ " GROUP BY TipoServicio, to_number(to_char(TO_DATE(FECHA.FECHA,'YYYY-MM-DD'), 'YY'))"
					+ " ORDER BY COUNT(idServicio) ASC");
			q.setParameters(idTipoServicio);
			return q.executeList();
		}
		public List<Object> darServiciosMasPrestadosPorAño(PersistenceManager pm, Long idTipoServicio)
		{
			Query q = pm.newQuery(SQL, "SELECT to_number(to_char(TO_DATE(fechaAsistida,'YYYY-MM-DD'), 'YY')), idtipoServicio, COUNT(idafiliado)"
					+ " FROM " + pp.darTablaServiciosAfiliado()
					+ " WHERE idtiposervicio = ?"
					+ " GROUP BY idtiposervicio  , to_number(to_char(TO_DATE(fechaasistida,'YYYY-MM-DD'), 'YY'))"
					+ " ORDER COUNT(idafiliado) DESC");
			q.setParameters(idTipoServicio);
			return q.executeList();
		}
		
		
		public List<Object> darServiciosMasSolicitadorPorMes(PersistenceManager pm, Long idTipoServicio	)
		{
			Query q = pm.newQuery(SQL, "SELECT to_number(to_char(TO_DATE(FECHA.FECHA,'YYYY-MM-DD'), 'MM')), tipoServicio, COUNT(idServicio) "
					+ " FROM " + pp.darTablaCita() + ", " + pp.darTablaFecha() + ", " + pp.darTablaServicio()
					+ " WHERE CITAS.idServicio = SERVICIO.ID"
					+ " AND CITAS.FECHA = FECHA.ID"
					+ " AND TipoServicio = ?"
					+ " GROUP BY TipoServicio, to_number(to_char(TO_DATE(FECHA.FECHA,'YYYY-MM-DD'), 'MM'))"
					+ " ORDER BY COUNT(idServicio) DESC");
			q.setParameters(idTipoServicio);
			return q.executeList();
		}
		public List<Object> darServiciosMenosSolicitadorPorMes(PersistenceManager pm, Long idTipoServicio	)
		{
			Query q = pm.newQuery(SQL, "SELECT to_number(to_char(TO_DATE(FECHA.FECHA,'YYYY-MM-DD'), 'MM')), tipoServicio, COUNT(idServicio) "
					+ " FROM " + pp.darTablaCita() + ", " + pp.darTablaFecha() + ", " + pp.darTablaServicio()
					+ " WHERE CITAS.idServicio = SERVICIO.ID"
					+ " AND CITAS.FECHA = FECHA.ID"
					+ " AND TipoServicio = ?"
					+ " GROUP BY TipoServicio, to_number(to_char(TO_DATE(FECHA.FECHA,'YYYY-MM-DD'), 'MM'))"
					+ " ORDER BY COUNT(idServicio) ASC");
			q.setParameters(idTipoServicio);
			return q.executeList();
		}
		public List<Object> darServiciosMasPrestadosPorMes(PersistenceManager pm, Long idTipoServicio)
		{
			Query q = pm.newQuery(SQL, "SELECT to_number(to_char(TO_DATE(fechaAsistida,'YYYY-MM-DD'), 'MM')), idtipoServicio, COUNT(idafiliado)"
					+ " FROM " + pp.darTablaServiciosAfiliado()
					+ " WHERE idtiposervicio = ?"
					+ " GROUP BY idtiposervicio  , to_number(to_char(TO_DATE(fechaasistida,'YYYY-MM-DD'), 'MM'))"
					+ " ORDER COUNT(idafiliado) DESC");
			q.setParameters(idTipoServicio);
			return q.executeList();
		}
		
		public List<Object> darServiciosMasSolicitadorPorDia(PersistenceManager pm, Long idTipoServicio	)
		{
			Query q = pm.newQuery(SQL, "SELECT to_number(to_char(TO_DATE(FECHA.FECHA,'YYYY-MM-DD'), 'DD')), tipoServicio, COUNT(idServicio) "
					+ " FROM " + pp.darTablaCita() + ", " + pp.darTablaFecha() + ", " + pp.darTablaServicio()
					+ " WHERE CITAS.idServicio = SERVICIO.ID"
					+ " AND CITAS.FECHA = FECHA.ID"
					+ " AND TipoServicio = ?"
					+ " GROUP BY TipoServicio, to_number(to_char(TO_DATE(FECHA.FECHA,'YYYY-MM-DD'), 'DD'))"
					+ " ORDER BY COUNT(idServicio) DESC");
			q.setParameters(idTipoServicio);
			return q.executeList();
		}
		public List<Object> darServiciosMenosSolicitadorPorDia(PersistenceManager pm, Long idTipoServicio	)
		{
			Query q = pm.newQuery(SQL, "SELECT to_number(to_char(TO_DATE(FECHA.FECHA,'YYYY-MM-DD'), 'DD')), tipoServicio, COUNT(idServicio) "
					+ " FROM " + pp.darTablaCita() + ", " + pp.darTablaFecha() + ", " + pp.darTablaServicio()
					+ " WHERE CITAS.idServicio = SERVICIO.ID"
					+ " AND CITAS.FECHA = FECHA.ID"
					+ " AND TipoServicio = ?"
					+ " GROUP BY TipoServicio, to_number(to_char(TO_DATE(FECHA.FECHA,'YYYY-MM-DD'), 'DD'))"
					+ " ORDER BY COUNT(idServicio) ASC");
			q.setParameters(idTipoServicio);
			return q.executeList();
		}
		public List<Object> darServiciosMasPrestadosPorDia(PersistenceManager pm, Long idTipoServicio)
		{
			Query q = pm.newQuery(SQL, "SELECT to_number(to_char(TO_DATE(fechaAsistida,'YYYY-MM-DD'), 'DD')), idtipoServicio, COUNT(idafiliado)"
					+ " FROM " + pp.darTablaServiciosAfiliado()
					+ " WHERE idtiposervicio = ?"
					+ " GROUP BY idtiposervicio  , to_number(to_char(TO_DATE(fechaasistida,'YYYY-MM-DD'), 'DD'))"
					+ " ORDER COUNT(idafiliado) DESC");
			q.setParameters(idTipoServicio);
			return q.executeList();
		}
		
		
		
		
		
		
		
		
}
