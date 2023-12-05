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
			String sql = "INSERT INTO disciplina (rgm, nome_disciplina, semestre, notas, faltas, etapa) VALUES (?, ?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, disciplinaModel.getRgm());
			ps.setString(2, disciplinaModel.getNomeDisciplina());
			ps.setString(3, disciplinaModel.getSemestre());
			ps.setDouble(4, disciplinaModel.getMediaNotas());
			ps.setInt(5, disciplinaModel.getFaltas());
			ps.setString(6, disciplinaModel.getEtapa());
			
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public boolean existeDisciplina(String rgm, String nomeDisciplina, String semestre) throws SQLException {
        String sql = "SELECT COUNT(*) AS total FROM disciplina WHERE rgm = ? AND nome_disciplina = ? AND semestre = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, rgm);
            ps.setString(2, nomeDisciplina);
            ps.setString(3, semestre);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int total = rs.getInt("total");
                return total > 0;
            }

            return false;
        } finally {
            closeResources();
        }
    }

    public void atualizarDisciplina(DisciplinaModel disciplina) throws SQLException {
        String sql = "UPDATE disciplina SET notas = ?, faltas = ?, etapa = ? WHERE rgm = ? AND nome_disciplina = ? AND semestre = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, disciplina.getMediaNotas());
            ps.setInt(2, disciplina.getFaltas());
            ps.setString(3, disciplina.getEtapa());
            ps.setString(4, disciplina.getRgm());
            ps.setString(5, disciplina.getNomeDisciplina());
            ps.setString(6, disciplina.getSemestre());
            ps.executeUpdate();
        } finally {
            closeResources();
        }
    }

    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public DisciplinaModel consultarDisciplina(String rgm) throws SQLException {
        String sql = "SELECT * FROM disciplina WHERE rgm = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, rgm);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return new DisciplinaModel(
                    rs.getInt("id_disciplina"),
                    rs.getString("rgm"),
                    rs.getString("nome_disciplina"),
                    rs.getString("semestre"),
                    rs.getDouble("notas"),
                    rs.getInt("faltas"),
                    rs.getString("etapa")
                );
            }

            return null;
        } finally {
            closeResources();
        }
    }

    public String consultarNomeAluno(String rgm) throws SQLException {
        String sql = "SELECT nome FROM aluno WHERE rgm = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, rgm);
            rs = ps.executeQuery();
            return rs.next() ? rs.getString("nome") : "";
        } finally {
            closeResources();
        }
    }

    public String consultarCursoAluno(String rgm) throws SQLException {
        String sql = "SELECT nome_curso FROM curso WHERE rgm = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, rgm);
            rs = ps.executeQuery();
            return rs.next() ? rs.getString("nome_curso") : "";
        } finally {
            closeResources();
        }
    
    }
    
    public void excluirDisciplina(String rgm) throws SQLException {
        String sql = "DELETE FROM disciplina WHERE rgm = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, rgm);
            ps.executeUpdate();
        }
    }
    
}