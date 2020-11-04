package Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import DAO.EntidadeBase;
import DAO.GenericoDAO;
import model.Professor;


@RestController
public class ControllerProfessor {
	GenericoDAO gDAO = new GenericoDAO();
	
	@RequestMapping("/salvarprofessor")
	public Professor salvaProfessor(@RequestBody String professor) {
		Gson gson = new Gson();
		Professor p = null;
		p = gson.fromJson(professor, Professor.class);
		gDAO.Save(p);
		return p;
		
	}
	@RequestMapping("/deleteprofessor")
	public Professor updateProfessor(@RequestBody String Professor) {
		Gson gson = new Gson();
		Professor p = null;
		p = gson.fromJson(Professor, Professor.class);
		gDAO.Delete(Professor.class, p.getIdString());
		return p;
		
	}
	@RequestMapping("/getprofessor")
	public EntidadeBase getProfessor(@RequestBody String Professor) {
		Gson gson = new Gson();
		Professor p = null;
	p = gson.fromJson(Professor, Professor.class);
		return gDAO.GetById(Professor.class, p.getIdString());
	
		
	}
	@RequestMapping("/getallprofessores")
	public List<EntidadeBase> getAllProfessor() {
		Gson gson = new Gson();
		List<EntidadeBase> Professores = new ArrayList<EntidadeBase>();
		Professores = gDAO.GetAll(Professor.class);
		return Professores;
	
		
	}
	

}
