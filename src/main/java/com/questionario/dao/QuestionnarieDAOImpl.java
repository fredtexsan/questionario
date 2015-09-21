package com.questionario.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.questionario.model.Questionnarie;

/**
 * Classe que realiza o CRUD dos question�rios
 * Implementa a interface QuestionnarieDAO
 * Representa um reposit�rio do spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Repository
public class QuestionnarieDAOImpl implements QuestionnarieDAO {
	
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
	public QuestionnarieDAOImpl() {
		
	}
	
	/**
	 * Construtor
	 * @param sessionFactory f�brica de sess�es
	 * 
	 * @author Alan Arantes Souza
	 */
	public QuestionnarieDAOImpl(SessionFactory sessionFactory) {
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
	 * Salva um question�rio
	 * 
	 * @param questionnarie question�rio a ser adicionado
	 * @author Alan Arantes Souza
	 */
	@Override
	public int addQuestionnarie(Questionnarie questionnarie) {
		return (int) getCurrentSession().save(questionnarie);
	}

	/**
	 * Recupera um question�rio
	 * 
	 * @param id id do question�rio a ser recuperado
	 * @return Questionnarie question�rio
	 * @author Alan Arantes Souza
	 */
	@Override
	public Questionnarie getQuestionnarie(int id) {
		return (Questionnarie) getCurrentSession().get(Questionnarie.class, id);
	}

	/**
	 * Recupera todos os question�rio
	 * 
	 * @return List<Questionnarie> lista de question�rios
	 * @author Alan Arantes Souza
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Questionnarie> getQuestionnaries() {
		return getCurrentSession().createQuery("from Questionnarie").list();
	}
}
