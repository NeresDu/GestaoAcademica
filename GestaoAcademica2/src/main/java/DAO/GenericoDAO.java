package DAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Aluno;
import model.Disciplina;
import model.Professor;
import util.Hibernate;

public class GenericoDAO<T extends EntidadeBase> {
	
	
	public void Save(T t) {
		Transaction trans = null;

		try (Session Session = Hibernate.getSessionFactory().openSession()){

			trans = Session.beginTransaction();

			Session.saveOrUpdate(t);

			trans.commit();

		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}


	
	public void Update(T t) {
		Transaction trans = null;

		try (Session Session = Hibernate.getSessionFactory().openSession()){

			trans = Session.beginTransaction();

			Session.saveOrUpdate(t);

			trans.commit();

		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}

	public T GetById(Class<T> c, String Codigo) {
		//Iniciar nova Transação banco
		Transaction trans = null;

		T t = null;

		//CONTROLE DE SESSÃO COM UMA SESSÃO QUE VIRÁ DO SERVIDOR
		try (Session Session = Hibernate.getSessionFactory().openSession()){
			trans = Session.beginTransaction();

			t = Session.get(c, Codigo);


			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}
		return t;
	}

	public List<T> GetAll(Class<T> c) {
		Transaction trans = null;

		List<T> lista = null;

		try (Session Session = Hibernate.getSessionFactory().openSession()){
			trans = Session.beginTransaction();


			CriteriaBuilder builder = Session.getCriteriaBuilder();
			CriteriaQuery<T> criteryQuery = builder.createQuery(c);
			Root<T> rootEntry = criteryQuery.from(c);
			CriteriaQuery<T> all = criteryQuery.select(rootEntry);

			TypedQuery<T> allQuery = Session.createQuery(all);
			lista = allQuery.getResultList();

		} catch (Exception e) {
			trans.rollback();
		}
		return lista;
	}

	public void Delete(Class<T> c, String id) {
		Transaction trans = null;
		T t = null;

		try (Session Session = Hibernate.getSessionFactory().openSession()){
			trans = Session.beginTransaction();

			t = Session.get(c, id);
			Session.remove(t);

			trans.commit();

		} catch (Exception e) {
			trans.rollback();
		}
	}

}
