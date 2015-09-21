package com.questionario.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.questionario.model.Question;

/**
 * Classe que realiza o CRUD das perguntas
 * Implementa a interface QuestionDAO
 * Representa um repositório do spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Repository
public class QuestionDAOImpl implements QuestionDAO {
	
	/*
	 * Objetos de banco
	 */
	@Autowired
	DataSource dataSource;

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Construtor padrão
	 * O comportamento padrão deste objeto são todos os elementos vazios
	 * 
	 * @author Alan Arantes Souza
	 */
	public QuestionDAOImpl() {
		
	}
	
	/**
	 * Construtor
	 * @param sessionFactory fábrica de sessões
	 * 
	 * @author Alan Arantes Souza
	 */
	public QuestionDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Recupera a sessão atual com o banco
	 * @return Session sessão atual
	 * 
	 * @author Alan Arantes Souza
	 */
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Salva uma pergunta
	 * 
	 * @param question pergunta a ser adicionada
	 * @return id id da pergunta salva
	 * @author Alan Arantes Souza
	 */
	@Override
	public int addQuestion(Question question) {
		return (int) getCurrentSession().save(question);
	}

	/**
	 * Recupera uma pergunta pelo seu id
	 * 
	 * @param int id pergunta
	 * @return Question pergunta
	 * @author Alan Arantes Souza
	 */
	@Override
	public Question getQuestion(int id) {
		return (Question) getCurrentSession().get(Question.class, id);
	}

	/**
	 * Recupera todas as perguntas
	 * 
	 * @return List<Question> lista de perguntas
	 * @author Alan Arantes Souza
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Question> getQuestions() {
		return getCurrentSession().createQuery("from Question").list();
	}

	/**
	 * Recupera todas as perguntas pertencentes
	 * ao questionário referenciado pelo id
	 * 
	 * @param id id do questionário
	 * @return List<Question> lista de perguntas
	 * @author Alan Arantes Souza
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Question> getQuestionsByQuestionnarieId(int id) {
		Criteria criteria = getCurrentSession().createCriteria(Question.class).createAlias("questionnarie", "q");
		
		return (List<Question>) criteria.add(Restrictions.eq("q.id", id)).list();
	}
	
}
