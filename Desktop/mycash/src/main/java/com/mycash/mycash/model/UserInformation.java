package com.mycash.mycash.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UserInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int id_autenticacao;
	private String nome;
	private String telefone;
	public Object getId_autentication() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setId_autentication(Object id_autentication) {
		// TODO Auto-generated method stub
		
	}
}