package application;

import java.util.List;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		VendedorDao vendedorDao = FabricaDao.criarVendedorDao();
		
		System.out.println("=== Teste 1: vendedor buscarPorId ===");
		Vendedor vendedor = vendedorDao.buscarPorId(3);
		System.out.println(vendedor);
		
		System.out.println("\n=== Teste 2: vendedor buscarPorDepartamento ===");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> lstVendedor = vendedorDao.buscarPorDepartamento(departamento);
		
		for (Vendedor obj : lstVendedor) {
			System.out.println(obj);
		}
	}

}
