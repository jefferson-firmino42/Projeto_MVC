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
					+ "municipio, uf, celular, nascimento, imagem) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, alunoModel.getRgm());
			ps.setString(2, alunoModel.getNome());
			ps.setString(3, alunoModel.getCpf());
			ps.setString(4, alunoModel.getEmail());
			ps.setString(5, alunoModel.getEndereco());
			ps.setString(6, alunoModel.getMunicipio());
			ps.setString(7, alunoModel.getUf());
			ps.setString(8, alunoModel.getCelular());
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String nascimento = dateFormat.format(alunoModel.getNascimento());
			ps.setString(9, nascimento);
			
			ps.setString(10, alunoModel.getImagem());
				
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
}
