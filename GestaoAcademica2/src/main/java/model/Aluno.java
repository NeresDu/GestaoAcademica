package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import DAO.EntidadeBase;

@Entity
@Table(name = "Alunos")
public class Aluno implements EntidadeBase{
	@Id
	private String CPF;
	private String Nome;
	private String Telefone;
	private String Email;
	
	@Override
	public Serializable getId() {
		return CPF;
	}
	public String getIdString() {
		return CPF;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Aluno(String cPF, String nome, String telefone, String email) {
		super();
		CPF = cPF;
		Nome = nome;
		Telefone = telefone;
		Email = email;
	}

	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
