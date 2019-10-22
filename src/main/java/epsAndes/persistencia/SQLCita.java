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
		
		public long adicionarCita(PersistenceManager pm, long id, int hora, long idFecha, long idServicio, long idAfiliado ) 
		{
			Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCita() + "(hora, Fecha, idServicio, idAfiliado) values (?, ?, ?, ?) ");
			q.setParameters(hora, idFecha, idServicio, idAfiliado);
			return (long) q.executeUnique();
		}
}
