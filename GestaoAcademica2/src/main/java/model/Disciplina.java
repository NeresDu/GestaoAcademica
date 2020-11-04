package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import DAO.EntidadeBase;

@Entity
@Table(name = "Disciplinas")
public class Disciplina implements EntidadeBase{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String Nome;
	private String Periodo;
	@Override
	
	public Serializable getId() {
		return codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getPeriodo() {
		return Periodo;
	}
	public void setPeriodo(String periodo) {
		Periodo = periodo;
	}
	public Disciplina(int codigo, String nome, String periodo) {
		super();
		this.codigo = codigo;
		Nome = nome;
		Periodo = periodo;
	}
	public Disciplina() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
