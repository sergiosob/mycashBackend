package br.fuctura.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id //informa ao banco qual é a chave primaria
	private	Long id;
	
	@Column(name = "nome", nullable = false, length = 60)
	private	String nome;
	@Column(name = "cpf", nullable = false, length = 15)
	private String cpf;
	@Column(name = "sexo", nullable = false, length = 2)
	private String sexo;
	@Column(name = "ano_nasci", nullable = false, length = 10)
	private String anoNasci;
	
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getAnoNasci() {
		return anoNasci;
	}
	public void setAnoNasci(String dataNasci) {
		this.anoNasci = dataNasci;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", anoNasci=" + anoNasci
				+ "]";
	}
	
	
}