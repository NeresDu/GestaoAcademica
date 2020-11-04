package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Disciplina;
import util.Hibernate;

public class DisciplinaDAO extends GenericoDAO{
	public Disciplina DeleteDisciplina(int id) {
		Transaction trans = null;
		Disciplina d = null;

		try (Session Session = Hibernate.getSessionFactory().openSession()){
			trans = Session.beginTransaction();

			d = Session.get(Disciplina.class, id);
			Session.remove(d);

			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}
		return d;
	}
	
	public Disciplina GetDisciplinaById(int Codigo) {
		//Iniciar nova Transação banco
		Transaction trans = null;

		Disciplina d = null;

		//CONTROLE DE SESSÃO COM UMA SESSÃO QUE VIRÁ DO SERVIDOR
		try (Session Session = Hibernate.getSessionFactory().openSession()){
			trans = Session.beginTransaction();

			d = Session.get(Disciplina.class, Codigo);


			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}
		return d;
	}
}
