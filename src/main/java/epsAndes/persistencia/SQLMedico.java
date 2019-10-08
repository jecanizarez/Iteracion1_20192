package epsAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLMedico {

	private final static String SQL = PersistenciaEpsAndes.SQL;
	
	private PersistenciaEpsAndes pp;
	
	public SQLMedico(PersistenciaEpsAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarMedico(PersistenceManager pm, long idUsuario, long numRegistroMed, String especialidad, long idIPS)
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaMedico() + "(numRegistroMed, documento, especialidad, IPS) values (?, ?, ?, ?) ");
		q.setParameters(numRegistroMed,idUsuario, especialidad, idIPS);
		return (long) q.executeUnique();
	}
}
