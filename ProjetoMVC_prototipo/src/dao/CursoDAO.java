package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.CursoModel;
import utils.ConnectionFactory;

public class CursoDAO {
	private Connection conn;   
	private PreparedStatement ps;  
	private ResultSet rs;  
	
	private CursoModel cursoModel;

	public CursoDAO() throws Exception {
		
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
	
	public void salvarCurso(CursoModel cursoModel) throws Exception {
	}
}
