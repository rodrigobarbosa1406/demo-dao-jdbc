package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class VendedorDaoJDBC implements VendedorDao {

	private Connection conn;

	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void incluir(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluirPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor buscarPorId(Integer id) {
		PreparedStatement stBuscaPorId = null;
		ResultSet rsBuscaPorId = null;
		
		try {
			stBuscaPorId = conn.prepareStatement(
						"SELECT seller.*, department.Name as DepName "
								+ "FROM seller "
								+ "INNER JOIN department "
								+ "ON seller.DepartmentId = department.Id "
								+ "WHERE seller.id = ?");
			
			stBuscaPorId.setInt(1, id);
			rsBuscaPorId = stBuscaPorId.executeQuery();
			
			if (rsBuscaPorId.next()) {
				return instanciarVendedor(rsBuscaPorId, instanciarDepartamento(rsBuscaPorId));
			}
			
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(stBuscaPorId);
			DB.closeResultSet(rsBuscaPorId);
		}
	}

	private Vendedor instanciarVendedor(ResultSet rsBuscaPorId, Departamento departamento) throws SQLException {
		return new Vendedor(rsBuscaPorId.getInt("Id"), rsBuscaPorId.getString("Name"), rsBuscaPorId.getString("Email"), rsBuscaPorId.getDate("BirthDate"), rsBuscaPorId.getDouble("BaseSalary"), departamento);
	}

	private Departamento instanciarDepartamento(ResultSet rsBuscaPorId) throws SQLException {
		return new Departamento(rsBuscaPorId.getInt("DepartmentId"), rsBuscaPorId.getString("DepName"));
	}

	@Override
	public List<Vendedor> buscarTudo() {
		// TODO Auto-generated method stub
		return null;
	}

}
