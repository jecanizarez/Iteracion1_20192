package epsAndes.persistencia;

import epsAndes.negocio.Medico;

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
	
	public Medico buscaMedicoPorDocumento(PersistenceManager pm, long documento)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMedico() + " WHERE DOCUMENTO = ?");
		q.setResultClass(Medico.class);
		q.setParameters(documento);
		return (Medico) q.executeUnique();
	}
	
	public Medico buscaMedicoPorRegistroMed(PersistenceManager pm, long registroMed)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMedico() + " WHERE NUMREGISTROMED = ?");
		q.setResultClass(Medico.class);
		q.setParameters(registroMed);
		return (Medico) q.executeUnique();
	}
	
}
