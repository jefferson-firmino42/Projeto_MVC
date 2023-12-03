package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.AlunoModel;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;

public class DAO {
	
	private Connection conn;   
	private PreparedStatement ps;  
	private ResultSet rs;  
	
	private AlunoModel alunoModel;

	public DAO() throws Exception {
		
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
	
	public void salvar(AlunoModel alunoModel) throws Exception {
		if (alunoModel == null) throw new Exception("Os valores não podem ser nulos");
		
		try {
			String sql = "INSERT INTO aluno (rgm, nome, cpf, email, endereco, "
					+ "municipio, uf, celular, nascimento, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, alunoModel.getRgm());
			ps.setString(2, alunoModel.getNome());
			ps.setString(3, alunoModel.getCpf());
			ps.setString(4, alunoModel.getEmail());
			ps.setString(5, alunoModel.getEndereco());
			ps.setString(6, alunoModel.getMunicipio());
			ps.setString(7, alunoModel.getUf());
			ps.setString(8, alunoModel.getCelular());
			ps.setString(9, alunoModel.getNascimento());
			ps.setString(10, alunoModel.getFoto());
				
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public void excluir(AlunoModel alunoModel) throws Exception {
		if (alunoModel == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE from aluno WHERE rgm=?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, alunoModel.getRgm());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
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
	
	public boolean cpfExiste(String cpf) throws SQLException {
	    String SQL = "SELECT cpf FROM aluno WHERE cpf=?";
	    ps = conn.prepareStatement(SQL);
	    ps.setString(1, cpf);
	    rs = ps.executeQuery();
	    return rs.next();
	}
	
	public AlunoModel consultar(String rgmAluno) throws Exception {

		try {
			String SQL = "SELECT  * FROM aluno WHERE rgm=?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, rgmAluno);			
			rs = ps.executeQuery();
			if (rs.next()) {
				String rgm = rs.getString("rgm");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				String municipio = rs.getString("municipio");
				String uf = rs.getString("uf");
				String celular = rs.getString("celular");
				String nascimento = rs.getString("nascimento");
				String foto = rs.getString("foto");
				
				alunoModel = new AlunoModel(rgm, nome, cpf, email, endereco, municipio, uf, celular, nascimento, foto);
			}
			return alunoModel;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	public void alterar(AlunoModel alunoModel) throws Exception {
	    if (alunoModel == null) {
	        throw new Exception("Os valores não podem ser nulos");
	    }

	    try (PreparedStatement ps = conn.prepareStatement(
	            "UPDATE aluno SET nome=?, cpf=?, email=?, endereco=?, "
	                    + "municipio=?, uf=?, celular=?, nascimento=?, foto=? WHERE rgm=?")) {

	        ps.setString(1, alunoModel.getNome());
	        ps.setString(2, alunoModel.getCpf());
	        ps.setString(3, alunoModel.getEmail());
	        ps.setString(4, alunoModel.getEndereco());
	        ps.setString(5, alunoModel.getMunicipio());
	        ps.setString(6, alunoModel.getUf());
	        ps.setString(7, alunoModel.getCelular());
	        ps.setString(8, alunoModel.getNascimento());
	        ps.setString(9, alunoModel.getFoto());
	        ps.setString(10, alunoModel.getRgm());

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

}
