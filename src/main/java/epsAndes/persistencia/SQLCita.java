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
			Query q = pm.newQuery(SQL, "SELECT FROM " + pp.darTablaCita() + " WHERE id = ? ");
			q.setParameters(idCita);
		    q.setResultClass(Cita.class);
            return (Cita)q.executeUnique();
		}
		
		
		
		
		
		
		
}
