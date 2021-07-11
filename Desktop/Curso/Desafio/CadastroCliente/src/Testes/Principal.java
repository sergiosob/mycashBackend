package Testes;

import Dao.ClienteDao;
import Model.Cliente;

public class Principal {
	public static void main(String[] args) throws ClassNotFoundException {
		Cliente cliente = new Cliente();
		cliente.setCPF("620.413.044-74");
		cliente.setNome("Sérgio Brito");
		cliente.setSexo("M");
		cliente.setAnoNasci("1964");
		
		ClienteDao clienteDao = new ClienteDao();
		
		clienteDao.salvar(cliente);
		
	}
}