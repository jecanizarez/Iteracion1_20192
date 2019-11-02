package epsAndes.main;

import java.util.Scanner;

import epsAndes.negocio.*;
import epsAndes.persistencia.PersistenciaEpsAndes;

public class Controller 
{
	// Attributes

	// Methods

	/**
	 * Method that runs the project's console input and output.
	 */
	public static void run()
	{
		Scanner sc = new Scanner(System.in);
		boolean end = false;
		PersistenciaEpsAndes persistencia = new PersistenciaEpsAndes();
		while(!end)
		{

			persistencia.requerimientoConsulta4(0);
		
			String login = sc.nextLine();
			Usuario usuario = persistencia.darUsuarioPorLogin(login);
			if(usuario == null)
			{
				ControllerView.print("El usuario no existe.");
				// TODO
			}
			else if(usuario.getRol() == 1) // Case: afiliado.
			{
				ControllerView.print("Bienvenido afiliado.");
				while(!end)
				{
					ControllerView.printMenuAfiliado();
					String num = sc.nextLine();
					int action = -1;
					if(validateNum(num))
						action = Integer.parseInt(num);
					if(action != -1 && (action == 0 || action == 1 ))
					{
						if(action == 0)
							end = true;
						else if(action == 1)
						{
							// TODO reservar una cita de servicio de salud.
						}
					}
					else
						ControllerView.print("Numero invalido, por favor intentelo de nuevo.");
				}
			}
			else if(usuario.getRol() == 2) // Case: medico
			{
				ControllerView.print("Bienvenido medico.");
				while(!end)
				{
					ControllerView.printMenuMedico();
					String num = sc.nextLine();
					int action = -1;
					if(validateNum(num))
						action = Integer.parseInt(num);
					if(action != -1 && (action == 0 || action == 1))
					{
						if(action == 0)
							end = true;
						else if(action == 1)
						{
							// TODO registrar una orden de servicio de salud.
							System.out.println("Ingrese el documento del afiliado");
							long idAfiliado = Long.parseLong(sc.nextLine());
							System.out.println("Ingrese el tipo de servicio Ej: (ConsultaEmergencia, ConsultaEspecialista, Terapia, ConsultaControl, " + "\n" + 
									"Examenes,Hospitalizacion, ProcesoMedicoEspecializado ");
							String NombreServicio = sc.nextLine();
							TipoServicio tipoServicio = persistencia.darTipoServicioPorNombre(NombreServicio);
							if(tipoServicio == null)
							{
								System.out.println("El tipo de servicio no existe");
							}
							long idTipoServicio = tipoServicio.getId();
							persistencia.adicionarOrden(idAfiliado, usuario.getDocumento(), idTipoServicio);

						}
					}
					else
						ControllerView.print("Numero invalido, por favor intentelo de nuevo.");
				}
			}
			else if(usuario.getRol() == 3) // Case: recepcionista
			{
				ControllerView.print("Bienvenido recepcionista.");
				while(!end)
				{
					ControllerView.printMenuRecepcionista();
					String num = sc.nextLine();
					int action = -1;
					if(validateNum(num))
						action = Integer.parseInt(num);
					if(action != -1 && (action == 0 || action == 1))
					{
						if(action == 0)
							end = true;
						else if(action == 1)
						{
							// TODO registrar la prestación de un servicio de salud.
							System.out.println("Ingrese el documento del paciente");
							long idPaciente = Long.parseLong(sc.nextLine());
							System.out.println("Ingrese el tipo de servicio ");
							String nombreTipoServicio = sc.nextLine();
							TipoServicio tipoServicio = persistencia.darTipoServicioPorNombre(nombreTipoServicio);
							if(tipoServicio == null)
							{
								System.out.println("Nombre incorrecto");
							}
							persistencia.adicionarPrestanServicio(tipoServicio.getId(), idPaciente);


						}
					}
					else
						ControllerView.print("Numero invalido, por favor intentelo de nuevo.");
				}
			}
			else if(usuario.getRol() == 4) // Case: admin.
			{
				ControllerView.print("Bienvenido administrador.");
				while(!end)
				{
					ControllerView.printMenuAdministrador();
					String num = sc.nextLine();
					int action = -1;
					if(validateNum(num))
						action = Integer.parseInt(num);
					if(action != -1 && (action == 0 || action == 1 || action == 2 || action == 3

							|| action == 4 || action == 5 || action == 6|| action == 7 ))

					{
						if(action == 0)
							end = true;
						else if(action == 1)
						{
							// TODO registrar roles.
							System.out.println("Ingrese nombre del rol");
							String nombre = sc.nextLine(); 
							Rol rolTest = persistencia.darRolPorNombre(nombre);
							if(rolTest != null)
							{
								System.out.println("Ya existe un rol con ese nombre, accion terminada.");
								continue;
							}
							Rol result = persistencia.adicionarRol(nombre);
							if(result != null)
								System.out.println("Rol adicionado.");
						}
						else if(action == 2)
						{
							// TODO registrar IPS.
							System.out.println("Ingrese nombre de la IPS (e.g., SaludAndes)");
							String nombre = sc.nextLine(); 
							IPS ipsTest = persistencia.darIPSPorNombre(nombre);
							if(ipsTest != null)
							{
								System.out.println("Ya existe una IPS con ese nombre, accion terminada.");
								continue;
							}
							System.out.println("Ingrese la localización (e.g., Calle 69 #4-20)");
							String localizacion = sc.nextLine();
							IPS result = persistencia.adicionarIPS(nombre, localizacion);
							if(result != null)
								System.out.println("IPS adicionada.");
						}
						else if(action == 3) 
						{
							//Registrar Medico
							int rolMed = 2;
							System.out.println("Ingrese el numero de documento (e.g., numero de C.C.)");
							int documento = Integer.parseInt(sc.nextLine()); 
							Usuario test1 = persistencia.darUsuarioPorDocumento(documento);
							if(test1 != null)
							{
								System.out.println("Ya existe un usuario con ese documento, accion terminada.");
								continue;
							}
							System.out.println("Ingrese un login (e.g., d.delcastillo)");
							String loginMedico = sc.nextLine();
							Usuario test2 = persistencia.darUsuarioPorLogin(loginMedico);
							if(test2 != null)
							{
								System.out.println("Ya existe un usuario con ese login, accion terminada.");
								continue;
							}
							System.out.println("Ingrese un tipo de documento (TI, CC o CE)");
							String tipoDocumento = sc.nextLine();
							int IdtipoDocumento = 0;
							if(tipoDocumento.equalsIgnoreCase("CC"))
								IdtipoDocumento = 1;
							else if(tipoDocumento.equalsIgnoreCase("TI"))
								IdtipoDocumento = 3;
							else if(tipoDocumento.equalsIgnoreCase("CE"))
								IdtipoDocumento = 2;
							else
							{
								System.out.println("Tipo de documento invalido, accion terminada.");
								continue;
							}
							System.out.println("Ingrese el nombre del medico (e.g., Daniel del Castillo)");
							String nombreMedico =  sc.nextLine();
							System.out.println("Ingrese numero del registro medico (e.g., 87960)");
							long numRegistroMed = Long.parseLong(sc.nextLine());
							Medico medicoTest = persistencia.darMedicoPorRegistroMed(numRegistroMed);
							if(medicoTest != null)
							{
								System.out.println("Ya existe un medico con ese registro, accion terminada.");
								continue;
							}
							System.out.println("Ingrese especialidad (e.g., Neurocirugia)");
							String especialidad = sc.nextLine(); 
							System.out.println("Ingrese nombre IPS (e.g., Fundacion Santa Fe de Bogota)");
							String IPS = sc.nextLine(); 
							IPS ips = persistencia.darIPSPorNombre(IPS);
							long idIPS = 0;
							if (ips != null)
								idIPS = ips.getId();
							else
							{
								System.out.println("La IPS no existe, accion terminada.");
								continue;
							}
							Usuario usuarioMedico = persistencia.adicionarUsuario(loginMedico, documento, rolMed, IdtipoDocumento, nombreMedico, "");
							if(usuarioMedico != null)
							{
								Medico result = persistencia.adicionarMedico(loginMedico, documento, rolMed, IdtipoDocumento, nombreMedico, "", numRegistroMed, especialidad, idIPS);
								if(result != null)
									System.out.println("Se ha adicionado el medico correctamente.");
							}
						}
						else if(action == 4)
						{
							// TODO registrar afiliado.
							int rolAfiliado = 1;
							System.out.println("Ingrese el numero de documento (e.g., numero de CC)");
							int documento = Integer.parseInt(sc.nextLine()); 
							Usuario test1 = persistencia.darUsuarioPorDocumento(documento);
							if(test1 != null)
							{
								System.out.println("Ya existe un usuario con ese documento, accion terminada.");
								continue;
							}
							System.out.println("Ingrese un login (e.g., je.canizarez)");
							String loginAfiliado = sc.nextLine();
							Usuario test2 = persistencia.darUsuarioPorLogin(loginAfiliado);
							if(test2 != null)
							{
								System.out.println("Ya existe un usuario con ese login, accion terminada.");
								continue;
							}
							System.out.println("Ingrese un tipo de documento (TI, CC, CE)");
							String tipoDocumento = sc.nextLine();
							int IdtipoDocumento = 0;
							if(tipoDocumento.equalsIgnoreCase("CC"))
								IdtipoDocumento = 1;
							else if(tipoDocumento.equalsIgnoreCase("TI"))
								IdtipoDocumento = 3;
							else if(tipoDocumento.equalsIgnoreCase("CE"))
								IdtipoDocumento = 2;
							else
							{
								System.out.println("Tipo de documento invalido, accion terminada.");
								continue;
							}
							System.out.println("Ingrese el nombre del afiliado (e.g., Juan Cañizarez)");
							String nombreAfiliado =  sc.nextLine();
							System.out.println("Ingrese la fecha de nacimiento con el siguiente formato: dd-MM-yyyy (e.g., 15-12-1997)");
							String fecha = sc.nextLine();
							Fecha fechaBuscada = persistencia.darFecha(fecha);
							long idFecha = 0;
							if(fechaBuscada == null)
								idFecha = persistencia.adicionarFecha(fecha).getId();
							else
								idFecha = fechaBuscada.getId();
							long idEPS = 1; 
							Usuario usuarioMedico = persistencia.adicionarUsuario(loginAfiliado, documento, rolAfiliado, IdtipoDocumento, nombreAfiliado, "");
							Afiliado result = persistencia.adicionarAfiliado(loginAfiliado, documento, rolAfiliado, IdtipoDocumento, nombreAfiliado, "", idFecha, idEPS);
							if(result != null)
								System.out.println("Se ha adicionado la fecha.");
						}
						else if(action == 5)
						{
							// TODO registrar servicio de salud.
							System.out.println("Ingrese el nombre de la IPS la cual desea registrar el servicio de salud (e.g., Fundacion Santa Fe de Bogota)");
							String nombreIPS = sc.nextLine();
							IPS ips = persistencia.darIPSPorNombre(nombreIPS);
							if(ips == null)
							{
								System.out.println("La IPS no existe, accion terminada.");
								continue;
							}
							System.out.println("Ingrese el documento del medico a cargo (e.g., numero de CC)");
							long idMedico = Long.parseLong(sc.nextLine());
							Usuario userTest = persistencia.darUsuarioPorDocumento(idMedico);
							if(userTest != null)
							{
								long rolId = userTest.getRol();
								if(rolId != 2)
								{
									System.out.println("El documento no corresponde a un medico, accion terminada.");
									continue;
								}
							}
							else
							{
								System.out.println("No hay usuario con ese documento, accion terminada.");
								continue;
							}

							System.out.println("Ingrese la capacidad del servicio de salud (e.g., 20)");
							int capacidad = Integer.parseInt(sc.nextLine());
							if(capacidad <= 0)
							{
								System.out.println("Capacidad invalida, accion terminada.");
								continue;
							}
							System.out.println("Ingrese la hora de inicio del servicio de salud (entre 0 y 24)");
							int horaInicio = Integer.parseInt(sc.nextLine());
							if(horaInicio < 0 || horaInicio > 24)
							{
								System.out.println("Hora de inicio invalida, accion terminada.");
								continue;
							}
							System.out.println("Ingrese la hora de cierre (entre hora inicio y 24)");
							int horaFinal = Integer.parseInt(sc.nextLine());
							if(horaFinal <= horaInicio || horaFinal > 24)
							{
								System.out.println("Hora de cierre invalida, accion terminada.");
								continue;
							}
							System.out.println("Ingrese el tipo de servicio (ConsultaEmergencia, ConsultaEspecialista, Terapia, ConsultaControl, " +
									"Examenes, Hospitalizacion, ProcesoMedicoEspecializado).");
							String NombreServicio = sc.nextLine();
							TipoServicio tipoServicio = persistencia.darTipoServicioPorNombre(NombreServicio);
							if(tipoServicio == null)
							{
								System.out.println("El tipo de servicio es invalido, accion terminada.");
								continue;
							}
							long idTipoServicio = tipoServicio.getId();
							Servicio servicio = persistencia.adicionarServicio(capacidad, horaInicio, horaFinal, idTipoServicio);
							if(servicio != null)
							{
								PrestanServicio result = persistencia.adicionarPrestanServicio(ips.getId(), servicio.getId());
								if(servicio != null && result != null)
									System.out.println("Servicio agregado correctamente.");	
							}
						}
						else if(action == 6)
						{

							System.out.println("Ingrese la feche de inicio que desea (e.g. 2012-06-05)");
							String fechaInicio = sc.nextLine();
							System.out.println("Ingrese la fecha limite que desea (e.g. 2012-06-08)");
							String fechaFinal = sc.nextLine();
							persistencia.requerimientoConsulta2(fechaInicio, fechaFinal);
						}
						else if(action == 7)
						{
							System.out.println("Ingrese el nombre de la IPS");
							String ips = sc.nextLine();
							Long idIPS = persistencia.darIPSPorNombre(ips).getId();
							System.out.println("Ingrese la fecha de inicio de la busqueda (e.g. 2012-06-05) ");
							String fechaInicial = sc.nextLine();
							System.out.println("Ingrese la fecha limite que desea (e.g. 2012-06-08)");
							String fechaFinal = sc.nextLine();
							System.out.println("El numero de servicios prestador por la IPS es: ");
							System.out.println(persistencia.requerimientoConsulta1(idIPS, fechaInicial, fechaFinal));
						}
					}
					else
						ControllerView.print("Numero invalido, por favor intentelo de nuevo.");
				}
			}
		}
		ControllerView.print("¡Hasta luego!");
	}

	public static boolean validateNum(String string)
	{
		try
		{
			Integer.parseInt(string);
			return true;
		}
		catch(Exception e)
		{ return false; }
	}
}