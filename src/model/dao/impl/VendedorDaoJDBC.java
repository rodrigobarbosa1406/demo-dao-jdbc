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
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
						"SELECT seller.*, department.Name as DepName "
								+ "FROM seller "
								+ "INNER JOIN deparment "
								+ "ON seller.DepartmentId = department.Id "
								+ "WHERE seller.id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				return new Vendedor(rs.getInt("Id"), rs.getString("Name"), rs.getString("Email"), rs.getDate("BirthDate"), rs.getDouble("BaseSalary"), new Departamento(rs.getInt("DepartmentId"), rs.getString("DepName")));
			}
			
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Vendedor> buscarTudo() {
		// TODO Auto-generated method stub
		return null;
	}

}
