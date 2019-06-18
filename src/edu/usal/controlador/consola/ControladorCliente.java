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
	
	public ControladorCliente(VistaCliente vista) {
		super();
		this.vista = vista;
		this.clienteDAO = ClienteFactory.GetImplementation("Archivo");
		
	}
	
	public void AgregarCliente() throws IOException{
		
		this.clienteDAO.AgregarCliente(vista.AltaCliente());
		
	}
	public void EliminarCliente() throws IOException{
		vista.eliminarCliente(0);
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
				fin = true;
				break;
			default:
				System.out.println("Opcion no válida.");
			}
			
		}
		
	}
	
	
}
