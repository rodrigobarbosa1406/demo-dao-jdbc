package application;

import java.util.Date;
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
		
		System.out.println("\n=== Teste 3: vendedor buscarTudo ===");
		lstVendedor = vendedorDao.buscarTudo();
		
		for (Vendedor obj : lstVendedor) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 4: vendedor incluir ===");
		Vendedor novoVendedor = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departamento);
		vendedorDao.incluir(novoVendedor);
		System.out.println("Inserido! Novo id = " + novoVendedor.getId());
		
		System.out.println("\n=== Teste 5: vendedor atualizar ===");
		vendedor = vendedorDao.buscarPorId(1);
		vendedor.setNome("Martha Waine");
		vendedorDao.atualizar(vendedor);
		System.out.println("Atualização concluída!");
	}

}
