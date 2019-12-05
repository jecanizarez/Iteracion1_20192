package epsAndes.persistencia;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import epsAndes.negocio.*;
import org.apache.log4j.Logger;

import javax.jdo.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

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

	private SQLServiciosAfiliado sqlServiciosAfiliado;

	private SQLCampana sqlCampaña;

	private SQLServiciosCampana sqlServiciosCampaña;

	public PersistenciaEpsAndes()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("Iteracion1");	
		crearClasesSQL();


		tablas = new LinkedList<String>();
		tablas.add("EPS_sequence");
		tablas.add("AFILIADO");
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
		tablas.add("SERVICIOSAFILIADO");
		tablas.add("CAMPANA");
		tablas.add("SERVICIOSCAMPANA");

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
		sqlCampaña = new SQLCampana(this);
		sqlServiciosCampaña = new SQLServiciosCampana(this);
		sqlServiciosAfiliado = new SQLServiciosAfiliado(this);
		sqlTrabajan = new SQLTrabajan(this);
		sqlTipoDocumento = new SQLTipoDocumento(this);
		sqlServicioMedico = new SQLServicioMedico(this);
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
	public String darTablaServiciosAfiliado()
	{
		return tablas.get(18);
	}
	public String darTablaCampaña()
	{

		return tablas.get(19);
	}
	public String darTablaServiciosCampaña()
	{
		return tablas.get(20);
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

			log.trace ("Insercion de un rol: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
			//ARREGLAR
			return darRolPorNombre(nombre);

		}
		catch (Exception e)
		{
			System.out.println("Error adicionado el rol.");
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
			//          	e.printStackTrace();
			//        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			System.out.println("Error al adicional el usuario: el usuario ya existe.");
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

			return new Medico( numRegistroMed,documento, especialidad, idIPS);
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			//        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			System.out.println("Error al adicional el medico: el medico ya existe.");
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

			return new Afiliado(documento, idFecha, idEPS);
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

			log.trace ("Insercion de un rol: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

			return new IPS(localizacion, nombre, idIPS);
		}
		catch (Exception e)
		{
			//        	e.printStackTrace();
			//        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			System.out.println("Error al adicionar la IPS.");
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
	public Recepcionista adicionarRecepcionista(long documento, long idIPS) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = sqlRecepcionista.adicionarRecepcionista(pm, documento, idIPS);
			tx.commit();

			log.trace ("Insercion de un usuario: " + ": " + tuplasInsertadas + " tuplas insertadas");

			return new Recepcionista( documento, idIPS);
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

	public Cita adicionarCita(int hora, long idFecha, long idServicio, long idAfiliado, long idRecepcionista) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long idCita = nextval ();
			long tuplasInsertadas = sqlCita.adicionarCita(pm, hora, idFecha, idServicio, idAfiliado, idRecepcionista);
			tx.commit();

			Cita cita = darUltCita();
			log.trace ("InserciÃ³n de una cita: " + ": " + tuplasInsertadas + " tuplas insertadas");
			System.out.println("Se adiciono la cita.");
			return new Cita(cita.getId(), hora, idFecha, idServicio, idAfiliado, idRecepcionista);
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
			long tuplasInsertadas = sqlFecha.AdicionarFecha(pm, fecha);
			tx.commit();
			log.trace ("Insercion de una fecha: " + fecha + ": " + tuplasInsertadas + " tuplas insertadas");

			return darFecha(fecha);
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


	public Servicio adicionarServicio(int capacidad, int horaInicio, int horaFinal, long idTipoServicio, long IPS)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			sqlServicio.adicionarServicio(pm, capacidad, horaInicio, horaFinal, idTipoServicio, IPS);
			tx.commit();

			long idServicio = sqlServicio.darIdUltimoServicio(pm);
			log.trace ("Insercion de un servicio: " + ": " + idServicio + " tuplas insertadas");

			return new Servicio(idServicio, capacidad, horaInicio, horaFinal, idTipoServicio, IPS, "Disponible", capacidad);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			//        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			System.out.println("Error al adicionar el servicio.");
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
	public PrestanServicio adicionarPrestanServicio(long idIPS, long idServicio)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long tuplasInsertadas = sqlPrestanServicio.adicionarPrestanServicio(pm, idIPS,idServicio );
			tx.commit();
			log.trace ("Insercion de un servicio: " + ": " + tuplasInsertadas + " tuplas insertadas");
			System.out.println("Se ha adicionado correctamente");
			return new PrestanServicio(idIPS, idServicio);
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
	public ServiciosAfiliado adicionarServiciosAfiliado(long idTipoServicio, long idAfiliado, String fecha, long IPS)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = sqlServiciosAfiliado.adicionarServiciosAfiliado(pm, idTipoServicio, idAfiliado, fecha, IPS);
			tx.commit();

			log.trace ("Insercion de un fservicio: " + ": " + tuplasInsertadas + " tuplas insertadas");

			return new ServiciosAfiliado(idTipoServicio, idAfiliado, fecha, IPS);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			System.out.println("Transaction rollback.");
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
	public Campana adicionarCampaña(String nombre, long idOrganizador)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = sqlCampaña.adicionarCampaña(pmf.getPersistenceManager(), nombre, idOrganizador);
			tx.commit();

			log.trace ("Insercion de un fservicio: " + ": " + tuplasInsertadas + " tuplas insertadas");

			Object[] datos = (Object[]) darCampañaPorNombre(nombre).get(0);

			return new Campana(((BigDecimal)datos[0]).longValue(), (String)datos[1], idOrganizador);
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
	public ServiciosCampana adicionarServiciosCampaña(Long idTipoServicio, Long idCampaña, int cantidad) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			long tuplasInsertadas = sqlServiciosCampaña.adicionarCampaña(pmf.getPersistenceManager(), idTipoServicio, idCampaña, cantidad);
			tx.commit();
			System.out.println("Se añadio");
			log.trace ("Insercion de un fservicio: " + ": " + tuplasInsertadas + " tuplas insertadas");


			return sqlServiciosCampaña.darServiciosCampana(pmf.getPersistenceManager());
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

	public Usuario darUsuarioPorLogin(String login)
	{
		return sqlUsuario.buscarUsuarioPorLogin(pmf.getPersistenceManager(), login);
	}

	public IPS darIPSPorNombre(String nombre)
	{
		return sqlIPS.buscarIPSPorNombre(pmf.getPersistenceManager(), nombre);
	}

	public IPS darIPSPorId(long id)
	{
		return sqlIPS.buscarTipoServicioPorNombre(pmf.getPersistenceManager(), id);
	}

	public Rol darRolPorNombre(String rol)
	{
		return sqlRol.buscaRolNombre(pmf.getPersistenceManager(), rol);
	}

	public Usuario darUsuarioPorDocumento(long documento)
	{
		return sqlUsuario.buscarUsuarioPorDocumento(pmf.getPersistenceManager(), documento);
	}
	public Medico darMedicoPorDocumento(long documento)
	{
		return sqlMedico.buscaMedicoPorDocumento(pmf.getPersistenceManager(), documento);
	}

	public Medico darMedicoPorRegistroMed(long registroMed)
	{
		return sqlMedico.buscaMedicoPorRegistroMed(pmf.getPersistenceManager(), registroMed);
	}

	public Fecha darFecha(String fecha)
	{
		return sqlFecha.buscarFecha(pmf.getPersistenceManager(), fecha);
	}
	public Fecha darFechaPorId(long id)
	{
		return sqlFecha.buscarFechaId(pmf.getPersistenceManager(), id);
	}
	public TipoServicio darTipoServicioPorNombre(String nombre)
	{
		return sqlTipoServicio.buscarTipoServicioPorNombre(pmf.getPersistenceManager(), nombre);
	}

	public TipoServicio darTipoServicioPorId(Long id)
	{
		return sqlTipoServicio.buscarTipoServicioPorId(pmf.getPersistenceManager(), id);
	}
	public Long darCapacidadDisponiblePorTipoServicio(Long idTipoServicio)
	{
		return sqlPrestanServicio.darCapacidadDisponiblePorTipoServicio(pmf.getPersistenceManager(), idTipoServicio);
	}
	public Long darCuantasIPSDanServicio(Long idTipoServicio)
	{
		return sqlPrestanServicio.darCuantasIPSDanServicio(pmf.getPersistenceManager(), idTipoServicio);
	}
	public List<Object> darIPSYCantidadActualServicio(Long idTipoServicio)
	{
		return sqlPrestanServicio.darIPSYDisponibilidadDelServicio(pmf.getPersistenceManager(), idTipoServicio);
	}
	public Cita darUltCita() 
	{
		return sqlPrestanServicio.darUltCita(pmf.getPersistenceManager());	
	}
	public Fecha darUltFecha()
	{
		return sqlFecha.darUltFecha(pmf.getPersistenceManager());
	}
	public Servicio darServicioPorId(Long id)
	{
		return sqlServicio.darServicioPorId(pmf.getPersistenceManager(), id);
	}

	public List<Object> darServicioPorIdTipo(long id)
	{
		return sqlServicio.darServiciosPorTipo(pmf.getPersistenceManager(), id);
	}

	public void disminuirCapacidadServicio(Long id)
	{
		sqlServicio.actualizarCapacidadActualServicio(pmf.getPersistenceManager(), id);
	}
	public void aumentarCapacidadServicio(Long id, int cantidad)
	{

		sqlServicio.aumentarCapacidadActualServicio(pmf.getPersistenceManager(), id, cantidad);
	}
	public List<Object> darCampañaPorNombre(String nombre)
	{
		return sqlCampaña.buscarCampañaPorNombre(pmf.getPersistenceManager(), nombre);
	}
	public List<Object> darCantidadServiciosPorAfiliado(Long idAfiliado)
	{
		return sqlPrestanServicio.darNumeroServiciosReservadorPorAfiliado(pmf.getPersistenceManager(), idAfiliado);
	}
	public void eliminarCitas(Long idAfiliado, Long idServicio)
	{
		sqlCita.eliminarCitas(pmf.getPersistenceManager(), idAfiliado, idServicio);
	}
	public List<Object> darUltFechaIdYHoraServicio(Long idTipoServicio)
	{
		return sqlCita.darUltFechaYHoraDeTipoServicio(pmf.getPersistenceManager(), idTipoServicio);
	}
	public long darServicioDiferente(Long idServicio, Long idTipoServicio)
	{
		return sqlPrestanServicio.darIdServicioDiferente(pmf.getPersistenceManager(), idServicio, idTipoServicio);
	}
	public List<Object> darServicioRangoFecha(String fechaInicial, String fechaFinal, Long idIPS, Long idTipoServicio)
	{
		return sqlPrestanServicio.darServiciosRangoFechas(pmf.getPersistenceManager(), fechaInicial, fechaFinal, idIPS, idTipoServicio);
	}
	public void eliminarCitaPorId(Long idCita)
	{
		sqlCita.eliminarCitaPorId(pmf.getPersistenceManager(), idCita);
	}
	public Cita darCitaPorId(Long idCita)
	{
		return sqlCita.darCitaPorId(pmf.getPersistenceManager(), idCita);
	}
	public List<Object> darServiciosMasSolicitadosPorAño(Long idTipoServicio)
	{
		return sqlCita.darServiciosMasSolicitadorPorAño(pmf.getPersistenceManager(), idTipoServicio);
	}
	public List<Object> darServiciosMenosSolicitadosPorAño(Long idTipoServicio)
	{
		return sqlCita.darServiciosMenosSolicitadorPorAño(pmf.getPersistenceManager(), idTipoServicio);
	}
	public List<Object> darServiciosMasPrestadosPorAño(Long idTipoServicio)
	{
		return sqlCita.darServiciosMasPrestadosPorAño(pmf.getPersistenceManager(), idTipoServicio);
	}
	public List<Object> darServiciosMasSolicitadosPorMes(Long idTipoServicio)
	{
		return sqlCita.darServiciosMasSolicitadorPorMes(pmf.getPersistenceManager(), idTipoServicio);
	}
	public List<Object> darServiciosMenosSolicitadosPorMes(Long idTipoServicio)
	{
		return sqlCita.darServiciosMenosSolicitadorPorMes(pmf.getPersistenceManager(), idTipoServicio);
	}
	public List<Object> darServiciosMasPrestadosPorMes(Long idTipoServicio)
	{
		return sqlCita.darServiciosMasPrestadosPorMes(pmf.getPersistenceManager(), idTipoServicio);
	}
	public List<Object> darServiciosMasSolicitadosPorDia(Long idTipoServicio)
	{
		return sqlCita.darServiciosMasSolicitadorPorDia(pmf.getPersistenceManager(), idTipoServicio);
	}
	public List<Object> darServiciosMenosSolicitadosPorDia(Long idTipoServicio)
	{
		return sqlCita.darServiciosMenosSolicitadorPorDia(pmf.getPersistenceManager(), idTipoServicio);
	}
	public List<Object> darServiciosMasPrestadosPorDia(Long idTipoServicio)
	{
		return sqlCita.darServiciosMasPrestadosPorDia(pmf.getPersistenceManager(), idTipoServicio);
	}
	public List<Object> darAfiliadosExigentes()
	{
		return sqlServiciosAfiliado.darAfiliadosExigentes(pmf.getPersistenceManager());
	}
	public List<Object> darServiciosSinDemanda()
	{
		//return sqlCita.darServiciosSinDemanda(pmf.getPersistenceManager());
		return null;
	}


	public void requerimientoConsulta1(String fechaInicial, String fechaFinal)
	{
		List<Object> lista = sqlPrestanServicio.darCantidadDeServiciosPrestadorPorUnaIps(pmf.getPersistenceManager(), fechaInicial, fechaFinal);
		if(!lista.isEmpty())
		{
			for(Object e: lista)
			{

				Object[] datos = (Object[]) e;

				Long id = ((BigDecimal) datos[0]).longValue();
				Long repeticiones  = ((BigDecimal) datos[1]).longValue();
				IPS tipo = darIPSPorId(id);
				System.out.println("IPS: " + tipo.getNombre()+ " Solicitudes: " + repeticiones);

			}
		}
		else
		{
			System.out.println("No se ha prestado ningun servicio en las fechas indicadas");
		}

	}





	public void requerimientoConsulta2(String fechaInicial, String fechaFinal)
	{
		List<Object> lista = sqlPrestanServicio.darLos20ServiciosMasSolicitados(pmf.getPersistenceManager(), fechaInicial, fechaFinal);
		if(!lista.isEmpty())
		{
			for(Object e: lista)
			{

				Object[] datos = (Object[]) e;

				Long idTipoServicio = ((BigDecimal) datos[0]).longValue();
				Long repeticiones  = ((BigDecimal) datos[1]).longValue();
				TipoServicio tipo = darTipoServicioPorId(idTipoServicio);
				System.out.println("Servicio: " + tipo.getTipo()+ " Solicitudes: " + repeticiones);
			}
		}
		else
		{
			System.out.println("No se ha prestado ningun servicio en las fechas indicadas");
		}
	}

	public void requerimientoConsulta5(Long idAfiliado, String fechaInicial, String fechaFinal)
	{
		List<Object> lista = sqlPrestanServicio.darServiciosAfiliado(pmf.getPersistenceManager(), idAfiliado, fechaInicial, fechaFinal);
		System.out.println("El usuario ha tomado los siguientes servicios:");
		if(!lista.isEmpty())
		{
			for(Object e: lista)
			{
				Object[] datos = (Object[]) e;

				Long idTipoServicio = ((BigDecimal) datos[0]).longValue();
				Long repeticiones  = ((BigDecimal) datos[1]).longValue();
				TipoServicio tipo = darTipoServicioPorId(idTipoServicio);
				System.out.println("Servicio: " + tipo.getTipo()+ ", Solicitudes: " + repeticiones);
			}
		}
		else
		{
			System.out.println("El usuario no ha tomado ningun servicio en las fechas indicadas");
		}
	}

	public void requerimientoConsulta4(int capacidad)
	{
		List<Object> lista = sqlServicio.darServiciosConCapacidadMayorA(pmf.getPersistenceManager(), capacidad);
		if(!lista.isEmpty())
		{
			for(Object e: lista)
			{
				Object[] datos = (Object[]) e;

				Long id = ((BigDecimal) datos[0]).longValue();
				System.out.print("id: " + id + " ");
				Long capacidadServicio = ((BigDecimal) datos[1]).longValue();
				System.out.print("Capacidad: " + capacidadServicio+ " ");
				Long horaInicial = ((BigDecimal) datos[2]).longValue();
				System.out.print("hora de inicio: " + horaInicial + " ");
				Long horaFinal = ((BigDecimal) datos[3]).longValue();
				System.out.print("hora de cierre: " + horaFinal + " ");
				Long idTipoServicio = ((BigDecimal) datos[4]).longValue();
				TipoServicio tipo = darTipoServicioPorId(idTipoServicio);
				System.out.println("Tipo de servicio: " + tipo.getTipo());
			}
		}
		else
		{
			System.out.println("No existe ningun servicio con más capacidad a la indicada");
		}
	}
	public void requerimientoConsulta3()
	{
		List<Object> listaCapacidadTotal = sqlPrestanServicio.darCantidadDeServicios(pmf.getPersistenceManager());
		List<Object> listaCapacidadActual = sqlPrestanServicio.darCantidadServiciosPrestados(pmf.getPersistenceManager());

		for(int i = 0; i < listaCapacidadActual.size(); i++)
		{
			Object[] actual = (Object[]) listaCapacidadActual.get(i);
			Object[] total = (Object[]) listaCapacidadTotal.get(i);
			Long idTipo = ((BigDecimal)actual[0]).longValue();
			Long usoActual = ((BigDecimal)actual[1]).longValue();
			Long cantidad = ((BigDecimal)total[1]).longValue();

			TipoServicio tipo = darTipoServicioPorId(idTipo);
			long ind = Math.round((double) usoActual*100/cantidad);
			System.out.println("Indice de uso de " + tipo.getTipo() + " es: " + ind + "%");

		}
	}
	public void registrarCampania(long idOrganizador, String nombre)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try
		{
			tx.begin();
			sqlCampaña.adicionarCampaña(pm, nombre, idOrganizador);
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
	}

	public void registrarCampaña(int cantidadConsultasEspecialista, int cantidadTerapias, int cantidadExamenes, long idOrganizadorCampaña, String nombreCampaña)
	{

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();

		try
		{
			tx.begin();
			int cantidadConsultasEspecialistaFinal = cantidadConsultasEspecialista;
			int cantidadTerapiasFinal = cantidadTerapias;
			int cantidadExamenesFinal = cantidadExamenes;
			System.out.println("registre la campaña");
			sqlCampaña.adicionarCampaña(pmf.getPersistenceManager(), nombreCampaña, idOrganizadorCampaña);
			Cita cita = darUltCita();
			System.out.println("Consegui la ultima cita");
			Fecha fecha = darFechaPorId(cita.getIdFecha());
			System.out.println("Fecha esta bien" + fecha != null);
			String fechaNormal = fecha.getFecha();
			String[] fechas = fechaNormal.split("-");
			String año = fechas[0];
			System.out.println(año);
			String mes = fechas[1];
			System.out.println(mes);
			String dia = fechas[2];
			System.out.println(dia);
			System.out.println("Organice la fecha");
			int hora = cita.getHora();
			System.out.println("Hora de la cita: " + hora);

			List<Object> listaIPSCap = darIPSYCantidadActualServicio((long)2);
			System.out.println("Obtuve las ips que dan el servicio y la capacidad actual");
			for( int i = 0; i < listaIPSCap.size(); i++)
			{
				Object[] datos = (Object[])listaIPSCap.get(i);

				Long capacidadActual = ((BigDecimal)datos[1]).longValue();
				System.out.println(capacidadActual);

				Long idServicio = ((BigDecimal)datos[2]).longValue();
				System.out.println(idServicio);

				Servicio servicio = darServicioPorId(idServicio);
				System.out.println("Obtuve el servicio y "  + servicio != null);

				while(capacidadActual-1 != 0 && cantidadConsultasEspecialista != 0)
				{
					hora += 1;
					System.out.println("hora + 1: " +hora);
					System.out.println("hora final: " + servicio.getHoraFinal());
					if(hora > servicio.getHoraFinal())
					{

						hora = servicio.getHoraInicio();
						if(Integer.parseInt(dia) + 1 < 10)
						{
							dia = "0" +(Integer.parseInt(dia) + 1) + "";
						}
						else
						{
							dia = (Integer.parseInt(dia) + 1) + "";
						}
						if(dia.equals("31"))
						{
							dia = "01";
						}
						if(Integer.parseInt(mes) + 1 < 10)
						{
							mes = "0" + (Integer.parseInt(mes) + 1) + "";
						}
						else
						{
							mes = (Integer.parseInt(mes) + 1) + "";
						}
						if(mes.equals("13"))
						{
							mes = "01";
						}
					}

					String fechaTemp = año+"-"+mes+"-"+dia;
					System.out.println(fechaTemp);
					System.out.println(fechaNormal);
					if(!fechaNormal.equals(fechaTemp))
					{
						System.out.println("Voy a adicionar la fecha");
						//sqlFecha.AdicionarFecha(pmf.getPersistenceManager(),fechaTemp);
						//System.out.println("ADICIONE LA FECHA HPTA");
					}
					//System.out.println("Voy a conseguir la puta fecha");
					Fecha fechaf = darFecha(fechaTemp);
					//System.out.println("La agarre");
					//sqlCita.adicionarCita(pmf.getPersistenceManager(), hora, fechaf.getId(), idServicio, idOrganizadorCampaña, 2);
					cantidadConsultasEspecialista--;
					sqlServicio.actualizarCapacidadActualServicio(pmf.getPersistenceManager(), idServicio);
					//System.out.println("AÑADI HPTA!!!!!");
				}  
			}
			Object[] campaña =(Object[]) sqlCampaña.buscarCampañaPorNombre(pmf.getPersistenceManager(), nombreCampaña).get(0);
			Long idCampaña = ((BigDecimal)campaña[0]).longValue();
			System.out.println(idCampaña);
			sqlServiciosCampaña.adicionarCampaña(pmf.getPersistenceManager(), (long)2, idCampaña, cantidadConsultasEspecialistaFinal);
			//System.out.println("YEII");
			listaIPSCap = darIPSYCantidadActualServicio((long)3);
			for( int i = 0; i < listaIPSCap.size(); i++)
			{
				Object[] datos = (Object[])listaIPSCap.get(i);

				Long capacidadActual = ((BigDecimal)datos[1]).longValue();

				Long idServicio = ((BigDecimal)datos[2]).longValue();

				Servicio servicio = darServicioPorId(idServicio);

				while(capacidadActual-1 != 0 && cantidadTerapias != 0)
				{

					hora += 1; 
					if(hora > servicio.getHoraFinal())
					{

						hora = servicio.getHoraInicio();
						if(Integer.parseInt(dia) + 1 < 10)
						{
							dia = "0" +(Integer.parseInt(dia) + 1) + "";
						}
						else
						{
							dia = (Integer.parseInt(dia) + 1) + "";
						}
						if(dia.equals("31"))
						{
							dia = "01";
						}
						if(Integer.parseInt(mes) + 1 < 10)
						{
							mes = "0" + (Integer.parseInt(mes) + 1) + "";
						}
						else
						{
							mes = (Integer.parseInt(mes) + 1) + "";
						}
						if(mes.equals("13"))
						{
							mes = "01";
						}
					}
					String fechaTemp = año+"-"+mes+"-"+dia;
					if(!fechaNormal.equals(fechaTemp))
					{
						//sqlFecha.AdicionarFecha(pmf.getPersistenceManager(),fechaTemp);
					}
					Fecha fechaf = darFecha(fechaTemp);
					//sqlCita.adicionarCita(pmf.getPersistenceManager(), hora, fechaf.getId(), idServicio, idOrganizadorCampaña, 2);
					sqlServicio.actualizarCapacidadActualServicio(pmf.getPersistenceManager(), idServicio);
					cantidadTerapias--;
				}

			}

			sqlServiciosCampaña.adicionarCampaña(pmf.getPersistenceManager(), (long)3, idCampaña, cantidadTerapiasFinal);

			listaIPSCap = darIPSYCantidadActualServicio((long)5);
			for( int i = 0; i < listaIPSCap.size(); i++)
			{
				Object[] datos = (Object[])listaIPSCap.get(i);

				Long capacidadActual = ((BigDecimal)datos[1]).longValue();

				Long idServicio = ((BigDecimal)datos[2]).longValue();

				Servicio servicio = darServicioPorId(idServicio);

				while(capacidadActual-1 != 0 && cantidadExamenes != 0)
				{

					hora += 1; 
					if(hora > servicio.getHoraFinal())
					{

						hora = servicio.getHoraInicio();
						if(Integer.parseInt(dia) + 1 < 10)
						{
							dia = "0" +(Integer.parseInt(dia) + 1) + "";
						}
						else
						{
							dia = (Integer.parseInt(dia) + 1) + "";
						}
						if(dia.equals("31"))
						{
							dia = "01";
						}
						if(Integer.parseInt(mes) + 1 < 10)
						{
							mes = "0" + (Integer.parseInt(mes) + 1) + "";
						}
						else
						{
							mes = (Integer.parseInt(mes) + 1) + "";
						}
						if(mes.equals("13"))
						{
							mes = "01";
						}
					}
					String fechaTemp = año+"-"+mes+"-"+dia;
					if(!fechaNormal.equals(fechaTemp))
					{
						//sqlFecha.AdicionarFecha(pmf.getPersistenceManager(),fechaTemp);
					}
					Fecha fechaf = darFecha(fechaTemp);
					//sqlCita.adicionarCita(pmf.getPersistenceManager(), hora, fechaf.getId(), idServicio, idOrganizadorCampaña, 2);
					sqlServicio.actualizarCapacidadActualServicio(pmf.getPersistenceManager(), idServicio);
					cantidadExamenes--;
				}  

				sqlServiciosCampaña.adicionarCampaña(pmf.getPersistenceManager(), (long)5, idCampaña, cantidadExamenesFinal);
			}
			System.out.println("Termine");





			tx.commit();




		}
		catch (Exception e)	
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
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

	public List<Object> RFC9()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Query q = pm.newQuery(SQL, "SELECT u.Nombre, ts.Tipo, sa.FechaAsistida, i.Nombre FROM " +
				"Afiliado a, Usuario u, ServiciosAfiliado sa, TipoServicio ts, IPS i " +
				"WHERE a.Documento = u.Documento AND sa.IdAfiliado = a.Documento AND sa.IdTipoServicio = ts.Id;");
		return  q.executeList();
	}

	public void cancelarServiciosCampaña(Long idOrganizador)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			List<Object> listaServicios = darCantidadServiciosPorAfiliado(idOrganizador);
			for(int i = 0; i < listaServicios.size(); i++)
			{
				Object[] datos = (Object[]) listaServicios.get(i);
				Long idServicio = ((BigDecimal)datos[0]).longValue();
				int cantidad = ((BigDecimal)datos[1]).intValue();

				eliminarCitas(idOrganizador, idServicio);
				aumentarCapacidadServicio(idServicio, cantidad);	
			}
			tx.commit();
		}
		catch (Exception e)	
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
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

	public void DeshabilitarServiciosSalud(Long fechaInicio, Long fechaFinal, Long idIPS, List<String>tipoServicio)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			for(int e = 0; e < tipoServicio.size(); e++)
			{
				System.out.println("Busco las fechas");
				Fecha fechaInicioF = darFechaPorId(fechaInicio);
				Fecha fechaFinalF = darFechaPorId(fechaFinal);
				TipoServicio tipoServicioActual = darTipoServicioPorNombre(tipoServicio.get(e));
				System.out.println("Busco los servicios que estan en el rango y son de dicha fecha");
				List<Object> lista = darServicioRangoFecha(fechaInicioF.getFecha(), fechaFinalF.getFecha(),  idIPS, tipoServicioActual.getId());
				if(!lista.isEmpty())
				{
					for(int i = 0; i < lista.size(); i++)
					{
						System.out.println("Hay por lo menos un servicio");
						Object[] datos = (Object[])lista.get(i);
						Long idServicio = ((BigDecimal)datos[0]).longValue();
						Long idTipoServicio = ((BigDecimal)datos[1]).longValue(); 
						Long idCita = ((BigDecimal)datos[2]).longValue(); 
						Long idAfiliado = ((BigDecimal)datos[3]).longValue(); 
						sqlServicio.deshabilitarServicioDeSalud(pmf.getPersistenceManager(), idServicio);
						System.out.println("Busco los servicios diferentes que sean del mismo tipo");
						Long respuesta = darServicioDiferente(idServicio, idTipoServicio);
						System.out.println("Candidato a reemplazar" + respuesta);
						Servicio servicio = sqlServicio.darServicioPorId(pmf.getPersistenceManager(), respuesta);
						if(respuesta == -1)
						{
							System.out.println("No se puede reasignar la cita para el servicio con ID: "+ idServicio+ " Ya que no se presta otro servicio del mismo tipo" );
						}
						else
						{
							System.out.println("Voy a eliminar la cita anterior");
							eliminarCitaPorId(idCita);
							System.out.println("Deshabilito el servicio");
							System.out.println("Reviso la disponabilidad del candidato");
							List<Object> listaDisponibilidad = darUltFechaIdYHoraServicio(respuesta);
							if(!listaDisponibilidad.isEmpty())
							{
								Object[] datosO = (Object[])listaDisponibilidad.get(0);
								System.out.println("Busco la ultima fecha");
								Fecha fecha = darFechaPorId(((BigDecimal)datos[1]).longValue());
								String fechaS = fecha.getFecha();
								String[] fechaDatos = fecha.getFecha().split("-");
								String año = fechaDatos[0];
								String mes = fechaDatos[1];
								String dia = fechaDatos[2];
								int hora = ((BigDecimal)datos[2]).intValue();
								hora += 1;
								if(hora > servicio.getHoraFinal())
								{

									hora = servicio.getHoraInicio();
									if(Integer.parseInt(dia) + 1 < 10)
									{
										dia = "0" +(Integer.parseInt(dia) + 1) + "";
									}
									else
									{
										dia = (Integer.parseInt(dia) + 1) + "";
									}
									if(dia.equals("31"))
									{
										dia = "01";
									}
									if(Integer.parseInt(mes) + 1 < 10)
									{
										mes = "0" + (Integer.parseInt(mes) + 1) + "";
									}
									else
									{
										mes = (Integer.parseInt(mes) + 1) + "";
									}
									if(mes.equals("13"))
									{
										mes = "01";
									}
								}
								String fechaTemp = año+"-"+mes+"-"+dia;
								if(!fechaS.equals(fechaTemp))
								{
									System.out.println("Adiciono la fecha ya que no existe");
									sqlFecha.AdicionarFecha(pmf.getPersistenceManager(),fechaTemp);

								}
								Fecha fechaf = darFecha(fechaTemp);
								System.out.println("Adiciono la cita");
								sqlCita.adicionarCita(pmf.getPersistenceManager(), hora, fechaf.getId(), respuesta,idAfiliado , 2);
								System.out.println("Se reprogramo la cita: " + idCita );
							}

							int hora = servicio.getHoraFinal();

							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
							LocalDateTime now = LocalDateTime.now();  
							String fechaI = dtf.format(now);
							System.out.println("Adicione la fecha");
							sqlFecha.AdicionarFecha(pmf.getPersistenceManager(), fechaI);
							Fecha fecha = darFecha(fechaI);
							sqlCita.adicionarCita(pmf.getPersistenceManager(), hora, fecha.getId(), respuesta, idAfiliado, 2);
						}
					}
				}
				else
				{
					sqlServicio.deshabilitarServicioDeSaludIDYIPS(pmf.getPersistenceManager(), idIPS,tipoServicioActual.getId() );
				}
			}
			tx.commit();
		}
		catch (Exception e)	
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			System.out.println("Ocurrio un error deshabilitando los servicios");
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
	public void rehabilitarServicios(Long idTipoServicio, Long idIPS) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			sqlServicio.habilitarServicioDeSalud(pmf.getPersistenceManager(), idTipoServicio, idIPS);
			tx.commit();
		}
		catch (Exception e)	
		{
			e.printStackTrace();
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			System.out.println("Ocurrio un error deshabilitando los servicios");
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

	public void requerimientoConsulta6(int medida, Long idTipoServicio)
	{
		if(medida == 1)
		{


			List<Object> lista = darServiciosMasSolicitadosPorAño(idTipoServicio);
			for(int i = 0; i <3 && i < lista.size(); i++)
			{
				Object[] datose = (Object[]) lista.get(i);
				Long año = ((BigDecimal)datose[0]).longValue();
				Long idTipoServicioR = ((BigDecimal)datose[1]).longValue();
				TipoServicio servicio = darTipoServicioPorId(idTipoServicio);
				Long solicitudes = ((BigDecimal)datose[2]).longValue();


				System.out.println("El año donde más se solicitaron + "+ servicio.getTipo() + "fue: " + año+ " El numero de solicitudes fue: " + solicitudes);
			}


			lista = darServiciosMenosSolicitadosPorAño(idTipoServicio);
			for(int i = 0; i<3 && i < lista.size(); i++)
			{

				Object[] datose = (Object[]) lista.get(i);
				Long año = ((BigDecimal)datose[0]).longValue();
				Long idTipoServicioR = ((BigDecimal)datose[1]).longValue();
				TipoServicio servicio = darTipoServicioPorId(idTipoServicio);
				Long solicitudes = ((BigDecimal)datose[2]).longValue();

				System.out.println("El año donde menos se solicitaron + "+ servicio.getTipo() + "fue: " + año+" El numero de solicitudes fue: " + solicitudes);
			}

			lista = darServiciosMasPrestadosPorAño(idTipoServicio);
			for(int i = 0; i<3 && i < lista.size(); i++)
			{

				Object[] datose = (Object[]) lista.get(i);
				Long año = ((BigDecimal)datose[0]).longValue();
				Long idTipoServicioR = ((BigDecimal)datose[1]).longValue();
				TipoServicio servicio = darTipoServicioPorId(idTipoServicio);
				Long solicitudes = ((BigDecimal)datose[2]).longValue();

				System.out.println("El año donde menos se solicitaron + "+ servicio.getTipo() + "fue: " + año+" El numero de solicitudes fue: " + solicitudes);
			}


		}
		else if( medida == 2)
		{
			List<Object> lista = darServiciosMasSolicitadosPorMes(idTipoServicio);
			for(int i = 0; i <3 && i < lista.size(); i++)
			{
				Object[] datose = (Object[]) lista.get(i);
				Long año = ((BigDecimal)datose[0]).longValue();
				Long idTipoServicioR = ((BigDecimal)datose[1]).longValue();
				TipoServicio servicio = darTipoServicioPorId(idTipoServicio);
				Long solicitudes = ((BigDecimal)datose[2]).longValue();


				System.out.println("El Mes donde más se solicitaron + "+ servicio.getTipo() + "fue: " + año+ " El numero de solicitudes fue: " + solicitudes);
			}


			lista = darServiciosMenosSolicitadosPorMes(idTipoServicio);
			for(int i = 0; i<3 && i < lista.size(); i++)
			{

				Object[] datose = (Object[]) lista.get(i);
				Long año = ((BigDecimal)datose[0]).longValue();
				Long idTipoServicioR = ((BigDecimal)datose[1]).longValue();
				TipoServicio servicio = darTipoServicioPorId(idTipoServicio);
				Long solicitudes = ((BigDecimal)datose[2]).longValue();

				System.out.println("El mes donde menos se solicitaron + "+ servicio.getTipo() + "fue: " + año+" El numero de solicitudes fue: " + solicitudes);
			}

			lista = darServiciosMasPrestadosPorMes(idTipoServicio);
			for(int i = 0; i<3 && i < lista.size(); i++)
			{

				Object[] datose = (Object[]) lista.get(i);
				Long año = ((BigDecimal)datose[0]).longValue();
				Long idTipoServicioR = ((BigDecimal)datose[1]).longValue();
				TipoServicio servicio = darTipoServicioPorId(idTipoServicio);
				Long solicitudes = ((BigDecimal)datose[2]).longValue();

				System.out.println("El Mes donde menos se solicitaron + "+ servicio.getTipo() + "fue: " + año+" El numero de solicitudes fue: " + solicitudes);
			}
		}
		else if(medida 	 == 3)
		{
			List<Object> lista = darServiciosMasSolicitadosPorDia(idTipoServicio);
			for(int i = 0; i <3 && i < lista.size(); i++)
			{
				Object[] datose = (Object[]) lista.get(i);
				Long año = ((BigDecimal)datose[0]).longValue();
				Long idTipoServicioR = ((BigDecimal)datose[1]).longValue();
				TipoServicio servicio = darTipoServicioPorId(idTipoServicio);
				Long solicitudes = ((BigDecimal)datose[2]).longValue();


				System.out.println("El Dia donde más se solicitaron + "+ servicio.getTipo() + "fue: " + año+ " El numero de solicitudes fue: " + solicitudes);
			}


			lista = darServiciosMenosSolicitadosPorDia(idTipoServicio);
			for(int i = 0; i<3 && i < lista.size(); i++)
			{

				Object[] datose = (Object[]) lista.get(i);
				Long año = ((BigDecimal)datose[0]).longValue();
				Long idTipoServicioR = ((BigDecimal)datose[1]).longValue();
				TipoServicio servicio = darTipoServicioPorId(idTipoServicio);
				Long solicitudes = ((BigDecimal)datose[2]).longValue();

				System.out.println("El Dia donde menos se solicitaron + "+ servicio.getTipo() + "fue: " + año+" El numero de solicitudes fue: " + solicitudes);
			}

			lista = darServiciosMasPrestadosPorDia(idTipoServicio);
			for(int i = 0; i<3 && i < lista.size(); i++)
			{

				Object[] datose = (Object[]) lista.get(i);
				Long año = ((BigDecimal)datose[0]).longValue();
				Long idTipoServicioR = ((BigDecimal)datose[1]).longValue();
				TipoServicio servicio = darTipoServicioPorId(idTipoServicio);
				Long solicitudes = ((BigDecimal)datose[2]).longValue();

				System.out.println("El Dia donde menos se solicitaron + "+ servicio.getTipo() + "fue: " + año+" El numero de solicitudes fue: " + solicitudes);
			}
		}
	}
	public void requerimientoConsulta7()
	{
		List<Object> listaAfiliados = darAfiliadosExigentes();

		if(listaAfiliados != null && !listaAfiliados.isEmpty())
		{
			for(int i = 0; i < listaAfiliados.size(); i++)
			{
				Object[] datosA = (Object[])listaAfiliados.get(i);
				Long idAfiliado = ((BigDecimal)datosA[0]).longValue();
				Usuario usuario = darUsuarioPorDocumento(idAfiliado);
				System.out.println(usuario.getNombre());
			}
		}
		else
		{
			System.out.println("no existen afiliados exigentes");
		}
	}
	public void requerimientoConsulta8()
	{
		List<Object> lista = darServiciosSinDemanda();
		if(lista != null && !lista.isEmpty())
		{
			for(int i = 0; i < lista.size(); i++)
			{
				Object[] datos = (Object[])lista.get(i);
				Long idServicio = ((BigDecimal)datos[0]).longValue();
				System.out.println("El servicio con Id: " + idServicio + " es un servicio sin demanda");
			}
		}
		else
		{
			System.out.println("No existe ningun servicio con poca demanda");
		}
	}



}
