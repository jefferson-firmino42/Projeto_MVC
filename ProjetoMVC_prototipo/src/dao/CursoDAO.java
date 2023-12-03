package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
		if (cursoModel == null)
			throw new Exception("Os valores não podem ser nulos");

		try {
			String sql = "INSERT INTO curso (rgm, nome_curso, campus, periodo) VALUES (?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, cursoModel.getRgm());
	        ps.setString(2, cursoModel.getNomeCurso());
	        ps.setString(3, cursoModel.getCampus());
	        ps.setString(4, cursoModel.getPeriodo());
			ps.executeUpdate();
			

		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public boolean rgmExiste(String rgm) throws SQLException {
	    String SQL = "SELECT rgm FROM aluno WHERE rgm=?";
	    ps = conn.prepareStatement(SQL);
	    ps.setString(1, rgm);
	    rs = ps.executeQuery();
	    return rs.next();
	}
}
