package Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import DAO.EntidadeBase;
import DAO.GenericoDAO;
import model.Aluno;

@RestController
public class ControllerAluno {
	GenericoDAO gDAO = new GenericoDAO();
	
	/*
	 * @RequestMapping("/aluno") public String salvaAluno(String aluno) { Gson gson
	 * = new Gson(); Aluno a = null; a = gson.fromJson(aluno, Aluno.class);
	 * gDAO.Save(a); return "boa";
	 * 
	 * }
	 */
	@RequestMapping("/salvaraluno")
	public Aluno salvaAluno(@RequestBody String aluno) {
		Gson gson = new Gson();
		Aluno a = null;
		a = gson.fromJson(aluno, Aluno.class);
		gDAO.Save(a);
		return a;
		
	}
	@RequestMapping("/deletealuno")
	public Aluno updateAluno(@RequestBody String aluno) {
		Gson gson = new Gson();
		Aluno a = null;
		a = gson.fromJson(aluno, Aluno.class);
		gDAO.Delete(Aluno.class, a.getIdString());
		return a;
		
	}
	@RequestMapping("/getaluno")
	public EntidadeBase getAluno(@RequestBody String aluno) {
		Gson gson = new Gson();
		Aluno a = null;
		a = gson.fromJson(aluno, Aluno.class);
		return gDAO.GetById(Aluno.class, a.getIdString());
	
		
	}
	@RequestMapping("/getallalunos")
	public List<EntidadeBase> getAllAluno() {
		Gson gson = new Gson();
		List<EntidadeBase> Alunos = new ArrayList<EntidadeBase>();
		Alunos = gDAO.GetAll(Aluno.class);
		return Alunos;
	
		
	}
	

}
