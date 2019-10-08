package epsAndes.persistencia;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import epsAndes.negocio.*;
import epsAndes.persistencia.*;
import uniandes.isis2304.parranderos.negocio.TipoBebida;
import uniandes.isis2304.parranderos.persistencia.PersistenciaParranderos;

public class PersistenciaEpsAndes {
 
	private static Logger log = Logger.getLogger(PersistenciaEpsAndes.class.getName());
	
	public final static String SQL = "javax.jdo.query.SQL";
	
	private static PersistenciaEpsAndes instance; 
	
	private PersistenceManagerFactory pmf;
	
	private List <String> tablas;
	
	private SQLUtil sqlUtil;
	
	private SQLAfiliado sqlAfiliado; 
	
	private SQLCita sqlCita;
	
	private SQLEPS sqlEPS; 
	
	private SQLFecha sqlFecha;
	
	private SQLIPS sqlIPS;
	
	private SQLMedico sqlMedico; 
	
	private SQLOrden sqlOrden;
	
	private SQLPrestanServicio sqlPrestanServicio;
	
	private SQLRecepcionista sqlRecepcionista;
	
	private SQLReceta sqlReceta;
	
	private SQLRol sqlRol;
	
	private SQLServicio sqlServicio;
	
	private SQLServicioMedico sqlServicioMedico;
	
	private SQLTipoDocumento sqlTipoDocumento;
	
	private SQLTipoServicio sqlTipoServicio;
	
	private SQLTrabajan sqlTrabajan;
	
	private SQLUsuario sqlUsuario;
	
	public PersistenciaEpsAndes()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("Iteracion");	
		crearClasesSQL();
		
		
		tablas = new LinkedList<String>();
		tablas.add("EPS_sequence");
		tablas.add("AFILIADOS");
		tablas.add("CITAS");
		tablas.add("EPS");
		tablas.add("FECHA");
		tablas.add("IPS");
		tablas.add("MEDICO");
		tablas.add("ORDENES");
		tablas.add("PRESTANSERVICIO");
		tablas.add("RECEPCIONISTA");
		tablas.add("RECETA");
		tablas.add("ROL");
		tablas.add("SERVICIO");
		tablas.add("SERVICIOMEDICO");
		tablas.add("TIPODOCUMENTO");
		tablas.add("TIPOSERVICIO");
		tablas.add("TRABAJAN");
		tablas.add("USUARIO");
		
	}
	
	private PersistenciaEpsAndes(JsonObject tableConfig)
	{
		crearClasesSQL();
		
		tablas = leerNombresTablas(tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}
	
	private List<String> leerNombresTablas(JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	public static PersistenciaEpsAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaEpsAndes ();
		}
		return instance;
	}
	
	public static PersistenciaEpsAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaEpsAndes (tableConfig);
		}
		return instance;
	}
	
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	private void crearClasesSQL()
	{
		sqlAfiliado = new SQLAfiliado(this);
		sqlCita = new SQLCita(this);
		sqlEPS = new SQLEPS(this);
		sqlFecha = new SQLFecha(this);
		sqlIPS = new SQLIPS(this);
		sqlMedico = new SQLMedico(this);
		sqlOrden = new SQLOrden(this);
		sqlPrestanServicio= new SQLPrestanServicio(this);
		sqlRecepcionista = new SQLRecepcionista(this);
		sqlReceta = new SQLReceta(this);
		sqlRol = new SQLRol(this);
		sqlServicio = new SQLServicio(this);
		sqlServicioMedico = new SQLServicioMedico(this);
		sqlTipoDocumento = new SQLTipoDocumento(this);
		sqlTipoServicio = new SQLTipoServicio(this);
		sqlTrabajan = new SQLTrabajan(this);
		sqlUsuario = new SQLUsuario(this);
		sqlUtil = new SQLUtil(this);
	}
	
	public String darSeqEpsAndes()
	{
		return tablas.get(0);
	}
	public String darTablaAfiliado()
	{
		return tablas.get(1);
	}
	public String darTablaCita()
	{
		return tablas.get(2);
	}
	public String darTablaEPS()
	{
		return tablas.get(3);
	}
	public String darTablaFecha()
	{
		return tablas.get(4);
	}
	public String darTablaIPS()
	{
		return tablas.get(5);
	}
	public String darTablaMedico()
	{
		return tablas.get(6);
	}
	public String darTablaOrden()
	{
		return tablas.get(7);
	}
	public String darTablaPrestanServicio()
	{
		return tablas.get(8);
	}
	public String darTablaRecepcionista()
	{
		return tablas.get(9);
	}
	public String darTablaReceta()
	{
		return tablas.get(10);
	}
	public String darTablaRol()
	{
		return tablas.get(11);
	}
	public String darTablaServicio()
	{
		return tablas.get(12);
	}
	public String darTablaServicioMedico()
	{
		return tablas.get(13);
	}
	public String darTablaTipoDocumento()
	{
		return tablas.get(14);
	}
	public String darTablaTipoServicio()
	{
		return tablas.get(15);
	}
	public String darTablaTrabajan()
	{
		return tablas.get(16);
	}
	public String darTablaUsuario()
	{
		return tablas.get(17);
	}
	
	private long nextval()
	{
		 long resp = sqlUtil.nextval (pmf.getPersistenceManager());
         log.trace ("Generando secuencia: " + resp);
	     return resp;
	}
	
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	
	public Rol adicionarRol(String nombre)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long idRol = nextval();
            long tuplasInsertadas = sqlRol.adicionarRol(pm, nombre);
            tx.commit();
            
            log.trace ("InserciÃ³n de un rol: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            //ARREGLAR
            return new Rol(idRol, nombre);
        }
        catch (Exception e)
        {

        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	System.out.println("Error adicionado el rol");
        	e.printStackTrace();
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public Usuario adicionarUsuario(String login,long documento, long idRol, long idTipoDocumento, String nombre, String correoElectronico)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlUsuario.adicionarUsuario(pm, documento, login, idRol, idTipoDocumento, nombre, correoElectronico);
            tx.commit();
            
            log.trace ("Insercion de un usuario: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Usuario(nombre, documento,  idTipoDocumento, idRol, login);
        }
        catch (Exception e)
        {
          	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public Medico adicionarMedico(String login,long documento, long idRol, long idTipoDocumento, String nombre, String correoElectronico, long numRegistroMed, String especialidad, long idIPS)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlMedico.adicionarMedico(pm, documento, numRegistroMed, especialidad, idIPS);
            tx.commit();
            
            log.trace ("Insercion de un Medico: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Medico(nombre, documento, idTipoDocumento, idRol, login, numRegistroMed, especialidad);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public Afiliado adicionarAfiliado(String login,long documento, long idRol, long idTipoDocumento, String nombre, String correoElectronico, long idFecha, long idEPS) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlAfiliado.adicionarAfiliado(pm, documento, idFecha, idEPS);
            tx.commit();
            
            log.trace ("Insercion de un usuario: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Afiliado(nombre, documento,  idTipoDocumento, idRol, login, idEPS, idFecha);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public IPS adicionarIPS(String nombre, String localizacion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long idIPS = nextval ();
            long tuplasInsertadas = sqlIPS.adicionarIPS(pm, idIPS, nombre, localizacion);
            tx.commit();
            
            log.trace ("InserciÃ³n de un rol: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new IPS(localizacion, nombre, idIPS);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }  
	}
	public Recepcionista adicionarRecepcionista(String login, long documento, long idRol, long idTipoDocumento, String nombre, String correoElectronico, long idIPS) 
    {
    	PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlRecepcionista.adicionarRecepcionista(pm, documento, idIPS);
            tx.commit();
            
            log.trace ("Insercion de un usuario: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Recepcionista(nombre, documento,  idTipoDocumento, idRol, login, idIPS);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }
	
	public Cita adicionarCita(int hora, long idFecha, long idServicio, long idAfiliado) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long idCita = nextval ();
            long tuplasInsertadas = sqlCita.adicionarCita(pm, idCita, hora, idFecha, idServicio, idAfiliado);
            tx.commit();
            
            log.trace ("InserciÃ³n de una cita: " + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Cita(idCita, idServicio, idAfiliado, idFecha, hora);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }  
	}
	
	public Orden adicionarOrden(long idAfiliado, long idMedico, long idTipoServicio)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlOrden.adicionarOrden(pm, idAfiliado, idMedico, idTipoServicio);
            tx.commit();
            
            log.trace ("Insercion de una Orden: " +  ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Orden(idMedico, idTipoServicio, idAfiliado);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public Fecha adicionarFecha(String fecha) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long idFecha = nextval ();
            long tuplasInsertadas = sqlFecha.AdicionarFecha(pm, idFecha, fecha);
            tx.commit();
            
            log.trace ("Insercion de una fecha: " + fecha + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Fecha(idFecha, fecha);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	

	public Servicio adicionarServicio(int capacidad, int horaInicio, int horaFinal, long idTipoServicio)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        
        try
        {
            tx.begin();
            long idServicio = nextval ();
            long tuplasInsertadas = sqlServicio.adicionarServicio(pm, idServicio, capacidad, horaInicio, horaFinal, idTipoServicio);
            tx.commit();
            
            log.trace ("Insercion de un fservicio: " + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Servicio(idServicio, capacidad, horaInicio, horaFinal, idTipoServicio);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
      
	}
	
	public Usuario darUsuarioPorLogin(String login)
	{
		return sqlUsuario.buscarUsuarioPorLogin(pmf.getPersistenceManager(), login);
	}
	
	public IPS darIPSPorNombre(String nombre)
	{
		return sqlIPS.buscarIPSPorNombre(pmf.getPersistenceManager(), nombre);
	}
	
	public Rol darRolPorNombre(String rol)
	{
		return sqlRol.buscaRolNombre(pmf.getPersistenceManager(), rol);
	}
	
	
	

	

	
	
}