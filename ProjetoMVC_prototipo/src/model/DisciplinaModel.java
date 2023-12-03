package model;

public class DisciplinaModel {
	private int idDisciplina;
	private int idCurso;
	private String rgm;
	private String nomeDisciplina;
	private String semestre;
	private double notas;
	private int faltas;
	
	public int getIdDisciplina() {
		return idDisciplina;
	}
	
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
	public int getIdCurso() {
		return idCurso;
	}
	
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
	public String getRgm() {
		return rgm;
	}
	
	public void setRgm(String rgm) {
		this.rgm = rgm;
	}
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public String getSemestre() {
		return semestre;
	}
	
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	public double getNotas() {
		return notas;
	}
	
	public void setNotas(double notas) {
		this.notas = notas;
	}
	
	public int getFaltas() {
		return faltas;
	}
	
	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public DisciplinaModel() {}

	public DisciplinaModel(int idDisciplina, int idCurso, String rgm, String nomeDisciplina, String semestre,
			double notas, int faltas) {
		this.idDisciplina = idDisciplina;
		this.idCurso = idCurso;
		this.rgm = rgm;
		this.nomeDisciplina = nomeDisciplina;
		this.semestre = semestre;
		this.notas = notas;
		this.faltas = faltas;
	}
	
}
