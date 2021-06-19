package application;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		VendedorDao vendedorDao = FabricaDao.criarVendedorDao();
		
		System.out.println("=== Teste 1: vendedor buscarPorId ===");
		Vendedor vendedor = vendedorDao.buscarPorId(3);
		
		System.out.println(vendedor);
	}

}
