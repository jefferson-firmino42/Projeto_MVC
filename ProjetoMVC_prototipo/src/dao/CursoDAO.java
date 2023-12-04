package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.AlunoModel;
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
	
	public CursoModel consultar(String rgmAluno) throws Exception {

		try {
			String SQL = "SELECT  * FROM curso WHERE rgm=?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, rgmAluno);			
			rs = ps.executeQuery();
			if (rs.next()) {
				String rgm = rs.getString("rgm");
				int idCurso = rs.getInt("id_curso");
				String nomeCurso = rs.getString("nome_curso");
				String campus = rs.getString("campus");
				String periodo = rs.getString("periodo");
				
				cursoModel = new CursoModel(rgm, idCurso, nomeCurso, campus, periodo);
			}
			return cursoModel;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	public void alterar(CursoModel cursoModel) throws Exception {
	    if (cursoModel == null) {
	        throw new Exception("Os valores não podem ser nulos");
	    }

	    try (PreparedStatement ps = conn.prepareStatement("UPDATE curso SET nome_curso=?, campus=?, periodo=? WHERE rgm=?")) {
	        ps.setString(1, cursoModel.getNomeCurso());
	        ps.setString(2, cursoModel.getCampus());
	        ps.setString(3, cursoModel.getPeriodo());
	        ps.setString(4, cursoModel.getRgm()); 

	        int rowsAffected = ps.executeUpdate();

	        if (rowsAffected == 0) {
	            throw new Exception("Nenhum registro foi alterado. RGM não encontrado.");
	        }

	    } catch (SQLException sqle) {
	        throw new Exception("Erro ao alterar dados: " + sqle.getMessage());
	    } finally {
	        ConnectionFactory.closeConnection(conn);
	    }
	}




	
	public boolean rgmExiste(String rgm) throws SQLException {
	    String SQL = "SELECT rgm FROM curso WHERE rgm=?";
	    ps = conn.prepareStatement(SQL);
	    ps.setString(1, rgm);
	    rs = ps.executeQuery();
	    return rs.next();
	}
}
