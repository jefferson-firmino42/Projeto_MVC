package model;

public class AlunoModel {
	private String rgm;
	private String nome;
	private String cpf;
	private String email;
	private String endereco;
	private String municipio;
	private String uf;
	private String celular;
	private String nascimento;
	private String foto;
	
	public String getRgm() {
		return rgm;
	}
	
	public void setRgm(String rgm) {
		this.rgm = rgm;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public AlunoModel() {}

	public AlunoModel(String rgm, String nome, String cpf, String email, String endereco, String municipio, String uf,
			String celular, String nascimento, String foto) {
		this.rgm = rgm;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.municipio = municipio;
		this.uf = uf;
		this.celular = celular;
		this.nascimento = nascimento;
		this.foto = foto;
	}
	
	
	
}
