package com.questionario.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.questionario.model.Answer;

/**
 * Classe que realiza o CRUD das respostas
 * Implementa a interface AnswerDAO
 * Representa um reposit�rio do spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Repository
public class AnswerDAOImpl implements AnswerDAO {
	
	/*
	 * Objetos de banco
	 */
	@Autowired
	DataSource dataSource;

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Construtor padr�o
	 * O comportamento padr�o deste objeto s�o todos os elementos vazios
	 * 
	 * @author Alan Arantes Souza
	 */
	public AnswerDAOImpl() {
		
	}
	
	/**
	 * Construtor
	 * @param sessionFactory f�brica de sess�es
	 * 
	 * @author Alan Arantes Souza
	 */
	public AnswerDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Recupera a sess�o atual com o banco
	 * @return Session sess�o atual
	 * 
	 * @author Alan Arantes Souza
	 */
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Salva uma resposta 
	 * 
	 * @param answer resposta a ser adicionada
	 * @author Alan Arantes Souza
	 */
	@Override
	public void addAnswer(Answer answer) {
		getCurrentSession().save(answer);
	}

	/**
	 * Recupera uma resposta
	 * 
	 * @param id id da resposta a ser recuperada
	 * @return Answer resposta
	 * @author Alan Arantes Souza
	 */
	@Override
	public Answer getAnswer(int id) {
		return (Answer) getCurrentSession().get(Answer.class, id);
	}

	/**
	 * Recupera todas as resposta
	 * 
	 * @return List<Answer> lista de respostas
	 * @author Alan Arantes Souza
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Answer> getAnswers() {
		return getCurrentSession().createQuery("from Answer").list();
	}
	
	/**
	 * Verifica se o email informado j� respondeu o question�rio
	 * referenciado pela pergunta
	 * 
	 * @param questionId id da pergunta
	 * @param email email
	 * @return verdadeiro se o email informado j� tiver respondido, falso caso contr�rio
	 * @author Alan Arantes Souza
	 */
	@Override
	public boolean hasAnswer(int questionId, String email) {
		Criteria criteria = getCurrentSession().createCriteria(Answer.class);
		Answer answer = (Answer) criteria.add(Restrictions.eq("email", email)).add(Restrictions.eq("question.id", questionId)).uniqueResult();
		
		return (answer != null);
	}

}
