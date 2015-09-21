package com.questionario.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.questionario.model.Questionnarie;

/**
 * Classe que realiza o CRUD dos questionários
 * Implementa a interface QuestionnarieDAO
 * Representa um repositório do spring
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
	 * Construtor padrão
	 * O comportamento padrão deste objeto são todos os elementos vazios
	 * 
	 * @author Alan Arantes Souza
	 */
	public QuestionnarieDAOImpl() {
		
	}
	
	/**
	 * Construtor
	 * @param sessionFactory fábrica de sessões
	 * 
	 * @author Alan Arantes Souza
	 */
	public QuestionnarieDAOImpl(SessionFactory sessionFactory) {
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
	 * Salva um questionário
	 * 
	 * @param questionnarie questionário a ser adicionado
	 * @author Alan Arantes Souza
	 */
	@Override
	public int addQuestionnarie(Questionnarie questionnarie) {
		return (int) getCurrentSession().save(questionnarie);
	}

	/**
	 * Recupera um questionário
	 * 
	 * @param id id do questionário a ser recuperado
	 * @return Questionnarie questionário
	 * @author Alan Arantes Souza
	 */
	@Override
	public Questionnarie getQuestionnarie(int id) {
		return (Questionnarie) getCurrentSession().get(Questionnarie.class, id);
	}

	/**
	 * Recupera todos os questionário
	 * 
	 * @return List<Questionnarie> lista de questionários
	 * @author Alan Arantes Souza
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Questionnarie> getQuestionnaries() {
		return getCurrentSession().createQuery("from Questionnarie").list();
	}
}
