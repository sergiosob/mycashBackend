package Model;

public class Cliente {
	
	private Long id;
	private String nome;
	private String anoNasci;
	private String sexo;
	private String CPF;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAnoNasci() {
		return anoNasci;
	}
	public void setAnoNasci(String anoNasci) {
		this.anoNasci = anoNasci;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		this.CPF = cPF;
	}
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", anoNasci=" + anoNasci + ", sexo=" + sexo + ", CPF=" + CPF
				+ "]";
	}
	
	
	
	
}
