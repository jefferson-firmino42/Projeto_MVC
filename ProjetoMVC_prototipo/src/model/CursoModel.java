package model;

public class CursoModel {
	private String rgm;
	private int idCurso;
	private String nomeCurso;
	private String campus;
	private String periodo;

	public String getRgm() {
		return rgm;
	}

	public void setRgm(String rgm) {
		this.rgm = rgm;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public CursoModel() {
	}

	public CursoModel(String rgm, int idCurso, String nomeCurso, String campus, String periodo) {
		this.rgm = rgm;
		this.idCurso = idCurso;
		this.nomeCurso = nomeCurso;
		this.campus = campus;
		this.periodo = periodo;
	}
}
