package epsAndes.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
							System.out.println("Ingrese el tipo de servicio que desea, este debe ser una ConsultaGenereal o una ConsultaEmergencia");
							String tipo = sc.nextLine();
							TipoServicio servicio = persistencia.darTipoServicioPorNombre(tipo);
							if(servicio == null)
							{
								System.out.println("El servicio especificado no existe");
								continue;
							}
							List<Object> listaDisponibilidad = persistencia.darUltFechaIdYHoraServicio(servicio.getId());
							Object[] datos = (Object[])listaDisponibilidad.get(0);
							Fecha fecha = persistencia.darFechaPorId(((BigDecimal)datos[1]).longValue());
							System.out.println("Puedes inscribir desde: " + fecha.getFecha());

							System.out.println("Desde la hora: " +((BigDecimal)datos[2]).longValue());

							System.out.println("Ingrese la fecha que desee");
							String fechaU = sc.nextLine();
							Fecha fechaIndicada = persistencia.darFecha(fechaU);
							if(fechaIndicada == null)
							{
								fechaIndicada = persistencia.adicionarFecha(fechaU);
							}
							System.out.println("Ingrese la hora que desea");
							int hora = Integer.parseInt(sc.nextLine());

							persistencia.adicionarCita(hora, fechaIndicada.getId(), ((BigDecimal)datos[0]).longValue(), usuario.getDocumento(), 2);
							persistencia.disminuirCapacidadServicio(((BigDecimal)datos[0]).longValue());
							System.out.println("Se adiciono la cita");


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

							|| action == 4 || action == 5 || action == 6|| action == 7 || action == 8 || action == 9 || action == 10 || action == 11 

							|| action == 12 || action == 13 || action == 14 || action == 15))
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
							Servicio servicio = persistencia.adicionarServicio(capacidad, horaInicio, horaFinal, idTipoServicio,ips.getId());
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

							System.out.println("Ingrese la fecha de inicio de la busqueda (e.g. 2012-06-05) ");
							String fechaInicial = sc.nextLine();
							System.out.println("Ingrese la fecha limite que desea (e.g. 2012-06-08)");
							String fechaFinal = sc.nextLine();
							persistencia.requerimientoConsulta1(fechaInicial, fechaFinal);

						}
						else if(action == 8)
						{
							persistencia.requerimientoConsulta3();
						}
						else if(action == 9)
						{
							System.out.println("Ingrese la capacidad ");
							int capacidad = Integer.parseInt(sc.nextLine());
							persistencia.requerimientoConsulta4(capacidad);
						}
						else if(action == 10)
						{
							System.out.println("Ingrese el documento de la persona que desea consultar (e.g. 7)");
							Long idAfiliado = Long.parseLong(sc.nextLine());
							System.out.println("Ingrese la fecha de inicio desde la cual desea consultar (e.g.2012-06-05) ");
							String fechaS = sc.nextLine();
							Fecha fechaInicial = persistencia.darFecha(fechaS);
							if(fechaInicial == null)
							{
					           persistencia.adicionarFecha(fechaS);
					           fechaInicial = persistencia.darFecha(fechaS);
							}
							System.out.println("Ingrese la fecha limite para la busqueda (e.g 2012-06-08)");
							fechaS = sc.nextLine();
							Fecha fechaFinal = persistencia.darFecha(fechaS);
							if(fechaFinal == null)
							{
								persistencia.adicionarFecha(fechaS);
						        fechaFinal = persistencia.darFecha(fechaS);
							}
							persistencia.requerimientoConsulta5(idAfiliado, fechaInicial.getFecha(), fechaFinal.getFecha());
						}
						else if (action == 11)
						{
							System.out.println("Ingrese la fecha de inicio");
							String fechaS = sc.nextLine();
							Fecha fechaInicial = persistencia.darFecha(fechaS);
							if(fechaInicial == null)
							{
					           persistencia.adicionarFecha(fechaS);
					           fechaInicial = persistencia.darFecha(fechaS);
							}
							System.out.println("Ingrese la fecha limite para la busqueda ");
							fechaS = sc.nextLine();
							Fecha fechaFinal = persistencia.darFecha(fechaS);
							if(fechaFinal == null)
							{
								persistencia.adicionarFecha(fechaS);
						        fechaFinal = persistencia.darFecha(fechaS);
							}
							System.out.println("Ingrese el nombre de la IPS al cual desea deshabilitar los servicios");
							String nombreIPS = sc.nextLine();
							IPS ips = persistencia.darIPSPorNombre(nombreIPS);
							if(ips == null)
							{
								System.out.println("La ips indicada no existe");
							}
							List<String> tipoServicio = new ArrayList<String>();
							System.out.println("Ingrese el numero de servicios que desea deshabilitar");
							int numServicios = Integer.parseInt(sc.nextLine());
							for(int i = 0; i < numServicios; i++)
							{
								System.out.println("Ingrese el tipo de servicio: ");
								String TipoServicio = sc.nextLine();
								tipoServicio.add(TipoServicio);
							}
							
							persistencia.DeshabilitarServiciosSalud(fechaInicial.getId(), fechaFinal.getId(), ips.getId(), tipoServicio);
							
							System.out.println("Servicios deshabilitados");
						}
						else if(action == 12)
						{
							System.out.println("Ingrese el tipo de servicio que desea rehabilitar");
							String tipoServicio = sc.nextLine();
							TipoServicio servicio = persistencia.darTipoServicioPorNombre(tipoServicio);
							if(servicio == null)
							{
								System.out.println("El tipo de servicio proporcionado no es el correcto");
								continue;
							}
							System.out.println("Ingrese el nombre de la IPS");
							String ipsS = sc.nextLine();
							IPS  ips = persistencia.darIPSPorNombre(ipsS);
							if(ips == null)
							{
								System.out.println("La ips proporcionada no existe");
								continue;
							}
							persistencia.rehabilitarServicios(servicio.getId(), ips.getId());
							System.out.println("Se rehabilitaron los servicios de tipo: " + tipoServicio + " de la ips " + ips.getNombre());
								
							
						}
						else if(action == 13)
						{
							System.out.println("Las medidas de tiempo son año, mes, dia, por favor indica que medida de tiempo prefiere");
							String medida = sc.nextLine();
							int numMedida = 0;
							if(medida.equals("año"))
							{
								numMedida = 1;
							}
							else if(medida.equals("mes"))
							{
								numMedida = 2;
							}
							else
							{
								numMedida = 3;
							}
							System.out.println("Ingrese el tipo del servicio sobre el que desea conocer las estadisticas");
							String tipo = sc.nextLine();
							TipoServicio tipoServicio = persistencia.darTipoServicioPorNombre(tipo);
							if(tipoServicio == null)
							{
								System.out.println("El tipo de servicio proporcionado no existe");
								continue;
							}
							persistencia.requerimientoConsulta6(numMedida, tipoServicio.getId());
						}
						else if(action == 14)
						{
							persistencia.requerimientoConsulta7();
						}
						else if( action == 15)
						{
							persistencia.requerimientoConsulta8();
						}
					}
					
					
					else
						ControllerView.print("Numero invalido, por favor intentelo de nuevo.");
				}
			}
			else if(usuario.getRol() == 6) // caso Organizador
			{

				ControllerView.printMenuOrganizador();
				int opcion = Integer.parseInt(sc.nextLine());
				
				if(opcion == 1)
				{
					System.out.println("Ingrese el nombre de la campaña");

					String nombreCampaña = sc.nextLine();

					String sConsultaEspecialista = "ConsultaEspecialista";

					TipoServicio tipo = persistencia.darTipoServicioPorNombre(sConsultaEspecialista);

					if(tipo == null)
					{
						System.out.println("El tipo especificado no existe");
						continue;
					}
					Long cantidadIPS = persistencia.darCuantasIPSDanServicio(tipo.getId());
					System.out.println("Ingrese la cantidad de Consultas con el especialista que se necesitan: ");
					int cantidadConsultasEspecialista = Integer.parseInt(sc.nextLine());

					Long cantidadDisponible = persistencia.darCapacidadDisponiblePorTipoServicio(tipo.getId());
					if(cantidadConsultasEspecialista > cantidadDisponible - cantidadIPS)
					{
						System.out.println("La cantidad solicitada supera a la canitdad disponible");
						continue;
					}

					String sTerapia = "Terapia"; 
					tipo = persistencia.darTipoServicioPorNombre(sTerapia);
					if(tipo == null)
					{
						System.out.println("El tipo especificado no existe");
						continue;
					}


					System.out.println("Ingrese el numero de terapias que se necesitan");
					int cantidadTerapias = Integer.parseInt(sc.nextLine());
					cantidadDisponible = persistencia.darCapacidadDisponiblePorTipoServicio(tipo.getId());

					if(cantidadTerapias > cantidadDisponible - cantidadIPS)
					{
						System.out.println("La cantidad solicitada supera a la cantidad disponible");
						continue;
					}

					String sExamenes = "Examenes";

					tipo = persistencia.darTipoServicioPorNombre(sExamenes);
					if(tipo == null)
					{
						System.out.println("El tipo especificado no existe");
						continue;
					}

					System.out.println("Ingrese el numero de examenes que se necesitan");
					int cantidadExamenes = Integer.parseInt(sc.nextLine());
					cantidadDisponible = persistencia.darCapacidadDisponiblePorTipoServicio(tipo.getId());

					if(cantidadExamenes > cantidadDisponible - cantidadIPS)
					{
						System.out.println("La cantidad solicitada supera a la cantidad disponible");
						continue;
					}

					persistencia.registrarCampaña(cantidadConsultasEspecialista, cantidadTerapias, cantidadExamenes, usuario.getRol(), nombreCampaña);

					System.out.println("Se registro la campaña");
				}
				else if(opcion == 2)
				{
					persistencia.cancelarServiciosCampaña(usuario.getDocumento());
					System.out.println("Se ha cancelado la campaña");
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