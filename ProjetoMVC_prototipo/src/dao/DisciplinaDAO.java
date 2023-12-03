package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.DisciplinaModel;
import utils.ConnectionFactory;

public class DisciplinaDAO {
	private Connection conn;   
	private PreparedStatement ps;  
	private ResultSet rs;  
	
	private DisciplinaModel disciplinaModel;

	public DisciplinaDAO() throws Exception {
		
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
	
	public void salvar(DisciplinaModel disciplinaModel) throws Exception {
	}
}
