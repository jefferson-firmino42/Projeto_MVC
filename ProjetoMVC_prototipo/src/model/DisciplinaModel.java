package model;

public class DisciplinaModel {
	private int idDisciplina;
	private String rgm;
	private String nomeDisciplina;
	private String semestre;
	private double nota_1;
	private double nota_2;
	private int faltas;
	private String etapa;
	private double mediaNotas;
	
	public int getIdDisciplina() {
		return idDisciplina;
	}
	
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
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
	
	public double getNota_1() {
		return nota_1;
	}
	
	public void setNota_1(double nota_1) {
		this.nota_1 = nota_1;
	}
	public double getNota_2() {
		return nota_2;
	}
	
	public void setNota_2(double nota_2) {
		this.nota_2 = nota_2;
	}
	public int getFaltas() {
		return faltas;
	}
	
	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }
    
    public double getMediaNotas() {
        return mediaNotas;
    }
    
    public void setMediaNotas(double mediaNotas) {
		this.mediaNotas = mediaNotas;
	}
    
    public void calcularMediaNotas() {
        this.mediaNotas = (nota_1 + nota_2) / 2.0;
    }
    
	public DisciplinaModel() {}

	public DisciplinaModel(int idDisciplina, String rgm, String nomeDisciplina, String semestre,
			double mediaNotas, int faltas, String etapa) {
		this.idDisciplina = idDisciplina;
		this.rgm = rgm;
		this.nomeDisciplina = nomeDisciplina;
		this.semestre = semestre;
		this.mediaNotas = mediaNotas;
		this.faltas = faltas;
		this.etapa = etapa;
	}
    
}