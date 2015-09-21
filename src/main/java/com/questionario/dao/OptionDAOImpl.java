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
 * Classe que realiza o CRUD das op��es
 * Implementa a interface OptionDAO
 * Representa um reposit�rio do spring
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
	 * Construtor padr�o
	 * O comportamento padr�o deste objeto s�o todos os elementos vazios
	 * 
	 * @author Alan Arantes Souza
	 */
	public OptionDAOImpl() {
		
	}
	
	/**
	 * Construtor
	 * @param sessionFactory f�brica de sess�es
	 * 
	 * @author Alan Arantes Souza
	 */
	public OptionDAOImpl(SessionFactory sessionFactory) {
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
	 * Salva uma op��o 
	 * 
	 * @param option op��o a ser adicionada
	 * @return id da op��o criada
	 * @author Alan Arantes Souza
	 */
	@Override
	public int addOption(Option option) {
		return (int) getCurrentSession().save(option);
	}

	/**
	 * Recupera uma op��o
	 * 
	 * @param id id da op��o a ser recuperada
	 * @return Option op��o
	 * @author Alan Arantes Souza
	 */
	@Override
	public Option getOption(int id) {
		return (Option) getCurrentSession().get(Option.class, id);
	}

	/**
	 * Recupera todas as op��es
	 * 
	 * @return List<Option> lista de op��es
	 * @author Alan Arantes Souza
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Option> getOptions() {
		return getCurrentSession().createQuery("from Option").list();
	}

	/**
	 * Retorna as op��es pertencentes a pergunta
	 * referenciada pelo id
	 * 
	 * @param questionId id da op��o
	 * @return List<Option> lista de op��es
	 * @author Alan Arantes Souza
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Option> getOptionByQuestionId(int id) {
		Criteria criteria = getCurrentSession().createCriteria(Option.class).createAlias("question", "q");
		return (List<Option>) criteria.add(Restrictions.eq("q.id", id)).list();
	}

}
