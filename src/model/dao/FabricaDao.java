package model.dao;

import db.DB;
import model.dao.impl.VendedorDaoJDBC;

public class FabricaDao {
	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJDBC(DB.getConnection());
	}
}
