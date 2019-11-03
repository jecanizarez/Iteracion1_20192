package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

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
}
