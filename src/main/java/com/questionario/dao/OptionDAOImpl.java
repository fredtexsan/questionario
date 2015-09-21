package com.questionario.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.questionario.model.Option;

/**
 * Classe que realiza o CRUD das opções
 * Implementa a interface OptionDAO
 * Representa um repositório do spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Repository
public class OptionDAOImpl implements OptionDAO {
	
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
	public OptionDAOImpl() {
		
	}
	
	/**
	 * Construtor
	 * @param sessionFactory fábrica de sessões
	 * 
	 * @author Alan Arantes Souza
	 */
	public OptionDAOImpl(SessionFactory sessionFactory) {
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
	 * Salva uma opção 
	 * 
	 * @param option opção a ser adicionada
	 * @return id da opção criada
	 * @author Alan Arantes Souza
	 */
	@Override
	public int addOption(Option option) {
		return (int) getCurrentSession().save(option);
	}

	/**
	 * Recupera uma opção
	 * 
	 * @param id id da opção a ser recuperada
	 * @return Option opção
	 * @author Alan Arantes Souza
	 */
	@Override
	public Option getOption(int id) {
		return (Option) getCurrentSession().get(Option.class, id);
	}

	/**
	 * Recupera todas as opções
	 * 
	 * @return List<Option> lista de opções
	 * @author Alan Arantes Souza
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Option> getOptions() {
		return getCurrentSession().createQuery("from Option").list();
	}

	/**
	 * Retorna as opções pertencentes a pergunta
	 * referenciada pelo id
	 * 
	 * @param questionId id da opção
	 * @return List<Option> lista de opções
	 * @author Alan Arantes Souza
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Option> getOptionByQuestionId(int id) {
		Criteria criteria = getCurrentSession().createCriteria(Option.class).createAlias("question", "q");
		return (List<Option>) criteria.add(Restrictions.eq("q.id", id)).list();
	}

}
