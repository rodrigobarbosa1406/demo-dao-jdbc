package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DepartamentoDao;
import model.dao.FabricaDao;
import model.entities.Departamento;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartamentoDao departamentoDao = FabricaDao.criarDepartamentoDao();
		
		System.out.println("=== Teste 1: departamento buscarPorId ===");
		Departamento departamento = departamentoDao.buscarPorId(3);
		System.out.println(departamento);
		
		System.out.println("\n=== Teste 2: departamento buscarTudo ===");
		List<Departamento> lstDepartamento = departamentoDao.buscarTudo();
		
		for (Departamento obj : lstDepartamento) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 3: departamento incluir ===");
		Departamento novoDepartamento = new Departamento(null, "Music");
		departamentoDao.incluir(novoDepartamento);
		System.out.println("Inserido! Novo id = " + novoDepartamento.getId());
		
		System.out.println("\n=== Teste 4: departamento atualizar ===");
		departamento = departamentoDao.buscarPorId(1);
		departamento.setNome("Computers");
		departamentoDao.atualizar(departamento);
		System.out.println("Atualização concluída!");
		
		System.out.println("\n=== Teste 5: departamento excluirPorId ===");
		System.out.println("Informe um id para excluir: ");
		int id = sc.nextInt();
		departamentoDao.excluirPorId(id);
		System.out.println("Exclusão concluída!");
		
		sc.close();
	}
}
