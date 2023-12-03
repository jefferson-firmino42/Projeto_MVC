package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public void salvarDisciplina(DisciplinaModel disciplinaModel) throws Exception {
		if (disciplinaModel == null)
			throw new Exception("Os valores não podem ser nulos");

		try {
			String sql = "INSERT INTO curso (rgm, nome_disciplina, semestre, notas, faltas) VALUES (?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, disciplinaModel.getRgm());
			ps.setString(2, disciplinaModel.getNomeDisciplina());
			ps.setString(3, disciplinaModel.getSemestre());
			ps.setDouble(4, disciplinaModel.getNotas());
			ps.setInt(5, disciplinaModel.getFaltas());
			
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
}
