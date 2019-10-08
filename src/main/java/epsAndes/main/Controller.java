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
			else if(usuario.getIdRol() == 1) // Case: afiliado.
			{
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
			else if(usuario.getIdRol() == 2) // Case: medico
			{
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
						}
					}
					else
						ControllerView.print("Numero invalido, por favor intentelo de nuevo.");
				}
			}
			else if(usuario.getIdRol() == 3) // Case: recepcionista
			{
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
						}
					}
					else
						ControllerView.print("Numero invalido, por favor intentelo de nuevo.");
				}
			}
			else if(usuario.getIdRol() == 4) // Case: admin.
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
//						System.out.println("Ingrese nombre del rol");
//						String nombre = sc.nextLine(); 
//						persistencia.adicionarRol(nombre);
//						System.out.println("Rol adicionado");
					}
					else if(action == 2)
					{
						// TODO registrar IPS.
//						System.out.println("Ingrese nombre del rol");
//						String nombre = sc.nextLine(); 
//						persistencia.adicionarRol(nombre);
//						System.out.println("Rol adicionado");
					}
					else if(action == 3) 
					{
						int rolMed = 2;
						System.out.println("Ingrese documento");
						int documento = sc.nextInt(); 
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
						long numRegistroMed = sc.nextLong();
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
					}
					else if(action == 5)
					{
						// TODO registrar servicio de salud.
					}
				}
				else
					ControllerView.print("Numero invalido, por favor intentelo de nuevo.");
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