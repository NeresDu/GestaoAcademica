package Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

import DAO.DisciplinaDAO;
import DAO.EntidadeBase;
import DAO.GenericoDAO;
import model.Disciplina;


@RestController
public class ControllerDisciplina {
	GenericoDAO gDAO = new GenericoDAO();
	DisciplinaDAO dDAO = new DisciplinaDAO();
	
	@RequestMapping("/salvardisciplina")
	public Disciplina salvaDisciplina(@RequestBody String Disciplina) {
		Gson gson = new Gson();
		Disciplina d = null;
		d = gson.fromJson(Disciplina, Disciplina.class);
		gDAO.Save(d);
		return d;
		
	}
	@RequestMapping("/deletedisciplina")
	public Disciplina updateDisciplina(@RequestBody String Disciplina) {
		Gson gson = new Gson();
		Disciplina d = null;
		d = gson.fromJson(Disciplina, Disciplina.class);
		return dDAO.DeleteDisciplina(d.getCodigo());
		
	}
	@RequestMapping("/getdisciplina")
	public EntidadeBase getDisciplina(@RequestBody String Disciplina) {
		Gson gson = new Gson();
		Disciplina d = null;
	d = gson.fromJson(Disciplina, Disciplina.class);
		return dDAO.GetDisciplinaById(d.getCodigo());
	
		
	}
	@RequestMapping("/getalldisciplinas")
	public List<EntidadeBase> getAllDisciplina() {
		Gson gson = new Gson();
		List<EntidadeBase> Disciplinas = new ArrayList<EntidadeBase>();
		Disciplinas = gDAO.GetAll(Disciplina.class);
		return Disciplinas;
	
		
	}
	

}
