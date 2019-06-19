package edu.usal.controlador.consola;

import java.io.IOException;
import java.util.List;

import edu.usal.dao.factory.ClienteFactory;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.vista.consola.VistaCliente;
import edu.usal.negocio.dao.interfaces.ClienteDAO;

public class ControladorCliente {

	private VistaCliente vista;
	private ClienteDAO clienteDAO;
	
	public ControladorCliente(VistaCliente vista) throws IOException {
		super();
		this.vista = vista;
		this.clienteDAO = ClienteFactory.GetImplementation("Archivo");
		
	}
	
	public void AgregarCliente() throws IOException{
		
		this.clienteDAO.AgregarCliente(vista.AltaCliente());
		
	}
	public boolean EliminarCliente() throws IOException{
		String dni = vista.eliminarCliente();
		if(dni.equals("back")){
			return false;

		}
	boolean encontrado = 	this.clienteDAO.EliminarCliente(dni);
	if(encontrado == true){
		vista.mensaje("Se elimino el cliente con DNI " + dni + "\n");
		Todos();
	}
	else{
		vista.mensaje("no se encontro");


	}
	return encontrado;

	}
	
	public void Todos() throws IOException{
		vista.imprimirTodos(this.clienteDAO.GetAll());
	}
	
	public void MostrarMenu() throws IOException {
		boolean fin = false;
		while(!fin) {
			
			int opcion = vista.menu();
			
			switch(opcion){
			case 1:
				this.AgregarCliente();
			break;
			
			case 2:
				this.Todos();
				break;

			case 3:

				this.EliminarCliente();
				break;


				case 4:
					fin = true;
					break;

			default:
				System.out.println("Opcion no v�lida.");
			}
			
		}
		
	}
	
	
}
