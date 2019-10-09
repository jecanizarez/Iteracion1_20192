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
			ControllerView.printMenuLogin();
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
							|| action == 4 || action == 5))
					{
						if(action == 0)
							end = true;
						else if(action == 1)
						{
							// TODO registrar roles.
							System.out.println("Ingrese nombre del rol");
							String nombre = sc.nextLine(); 
							Rol result = persistencia.adicionarRol(nombre);
							if(result != null)
								System.out.println("Rol adicionado");
						}
						else if(action == 2)
						{
							// TODO registrar IPS.
							System.out.println("Ingrese nombre de la IPS (e.g., SaludAndes)");
							String nombre = sc.nextLine(); 
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
							System.out.println("Ingrese documento");
							int documento = Integer.parseInt(sc.nextLine()); 
							System.out.println("Ingrese un login");
							String loginMedico = sc.nextLine();
							System.out.println("Ingrese un tipo de documento (TI,CC,CE");
							String tipoDocumento = sc.nextLine();
							int IdtipoDocumento = 0;
							if(tipoDocumento.equalsIgnoreCase("CC"))
							{
								IdtipoDocumento = 1;
							}
							else if(tipoDocumento.equalsIgnoreCase("TI"))
							{
								IdtipoDocumento = 3;
							}
							else if(tipoDocumento.equalsIgnoreCase("CE"))
							{
								IdtipoDocumento = 2;
							}
							else
							{
								System.out.println("Tipo de documento no valido");
							}
							System.out.println("Ingrese un nombre");
							String nombreMedico =  sc.nextLine();

							System.out.println("Ingrese numero del registro medico");
							long numRegistroMed = Long.parseLong(sc.nextLine());
							System.out.println("Ingrese especialidad");
							String especialidad = sc.nextLine(); 
							System.out.println("Ingrese nombre IPS");
							String IPS = sc.nextLine(); 
							IPS ips = persistencia.darIPSPorNombre(IPS);
							long idIPS = 0;
							if (ips != null)
							{
								idIPS = ips.getId();
							}
							else
							{
								System.out.println("La IPS no existe");
							}
							Usuario usuarioMedico = persistencia.adicionarUsuario(loginMedico, documento, rolMed, IdtipoDocumento, nombreMedico, "");
							persistencia.adicionarMedico(loginMedico, documento, rolMed, IdtipoDocumento, nombreMedico, "", numRegistroMed, especialidad, idIPS);
							System.out.println("Se ha adicionado el medico correctamente");
						}
						else if(action == 4)
						{
							// TODO registrar afiliado.
							int rolAfiliado = 1;
							System.out.println("Ingrese documento");
							int documento = Integer.parseInt(sc.nextLine()); 
							System.out.println("Ingrese un login");
							String loginMedico = sc.nextLine();
							System.out.println("Ingrese un tipo de documento (TI,CC,CE)");
							String tipoDocumento = sc.nextLine();
							int IdtipoDocumento = 0;
							if(tipoDocumento.equalsIgnoreCase("CC"))
							{
								IdtipoDocumento = 1;
							}
							else if(tipoDocumento.equalsIgnoreCase("TI"))
							{
								IdtipoDocumento = 3;
							}
							else if(tipoDocumento.equalsIgnoreCase("CE"))
							{
								IdtipoDocumento = 2;
							}
							else
							{
								System.out.println("Tipo de documento no valido");
							}
							System.out.println("Ingrese un nombre");
							String nombreAfiliado =  sc.nextLine();
							System.out.println("Ingrese su fecha de nacimiento con el siguiente formato: dd/MM/yyyy");
							String fecha = sc.nextLine();
							Fecha fechaBuscada = persistencia.darFecha(fecha);
							long idFecha = 0;
							if(fechaBuscada == null)
							{
								idFecha = persistencia.adicionarFecha(fecha).getId();
							}
							else
							{
								idFecha = fechaBuscada.getId();
							}
							long idEPS = 1; 
							Usuario usuarioMedico = persistencia.adicionarUsuario(loginMedico, documento, rolAfiliado, IdtipoDocumento, nombreAfiliado, "");
							persistencia.adicionarAfiliado(loginMedico, documento, rolAfiliado, IdtipoDocumento, nombreAfiliado, "", idFecha, idEPS);
							System.out.println("Se ha adicionado la fecha");


						}
						else if(action == 5)
						{
							// TODO registrar servicio de salud.
							System.out.println("Ingrese el nombre de la IPS la cual desea registrar el servicio de salud");
							String nombreIPS = sc.nextLine();
							IPS ips = persistencia.darIPSPorNombre(nombreIPS);
							if(ips == null)
							{
								System.out.println("La IPS no existe");
							}
							System.out.println("Ingrese el documento del medico a cargo");
							long idMedico = Long.parseLong(sc.nextLine());
							System.out.println("Ingrese la capacidad del servicio de salud");
							int capacidad = Integer.parseInt(sc.nextLine());
							System.out.println("Ingrese la hora de inicio del servicio de salud");
							int horaInicio = Integer.parseInt(sc.nextLine());
							System.out.println("Ingrese la hora de cierre");
							int horaFinal = Integer.parseInt(sc.nextLine());
							System.out.println("Ingrese el tipo de servicio, Ej: (ConsultaEmergencia, ConsultaEspecialista, Terapia, ConsultaControl, " + "\n" +
									"Examenes,Hospitalizacion, ProcesoMedicoEspecializado ");
							String NombreServicio = sc.nextLine();
							TipoServicio tipoServicio = persistencia.darTipoServicioPorNombre(NombreServicio);
							if(tipoServicio == null)
							{
								System.out.println("El tipo de servicio no existe");
							}
							long idTipoServicio = tipoServicio.getId();
							Servicio servicio = persistencia.adicionarServicio(capacidad, horaInicio, horaFinal, idTipoServicio);
							persistencia.adicionarPrestanServicio(ips.getId(), servicio.getId());
							System.out.println("Servicio agregado correctamente");	
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