package com.questionario.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.questionario.model.User;

/**
 * Classe que realiza o CRUD dos usu�rios
 * Implementa a interface UserDAO
 * Representa um reposit�rio do spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Repository
public class UserDAOImpl implements UserDAO {
	
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
	public UserDAOImpl() {
		
	}
	
	/**
	 * Construtor
	 * @param sessionFactory f�brica de sess�es
	 * 
	 * @author Alan Arantes Souza
	 */
	public UserDAOImpl(SessionFactory sessionFactory) {
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
	 * Salva um usu�rio
	 * 
	 * @param user usu�rio a ser adicionado
	 * @return id do usu�rio adicionado
	 * @author Alan Arantes Souza
	 */
	@Override
	public int addUser(User user) {
		return (int) getCurrentSession().save(user);
	}

	/**
	 * Recupera um usu�rio pelo id referenciado
	 * 
	 * @param id id do usu�rio
	 * @return User usu�rio
	 * @author Alan Arantes Souza
	 */
	@Override
	public User getUser(int id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}
	
	/**
	 * Recupera um usu�rio pelo email referenciado
	 * 
	 * @param email email do usu�rio
	 * @return User usu�rio
	 * @author Alan Arantes Souza
	 */
	@Override
	public User getUserByEmail(String email) {
		Criteria criteria = getCurrentSession().createCriteria(User.class);
		return (User) criteria.add(Restrictions.eq("email", email)).uniqueResult();
	}

	/**
	 * Recupera todos os usu�rios
	 * 
	 * @return List<User> lista de usu�rios
	 * @author Alan Arantes Souza
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User").list();
	}

	/**
	 * Verifica se existe algum usu�rio com o email e senha informados
	 * 
	 * @param email email
	 * @param password senha
	 * @return verdadeiro se o usu�rio existir, falso caso contr�rio
	 * @author Alan Arantes Souza
	 */
	@Override
	public boolean isValidUser(String email, String password) {
		Criteria criteria = getCurrentSession().createCriteria(User.class);
		User user = (User) criteria.add(Restrictions.eq("email", email)).add(Restrictions.eq("password", password)).uniqueResult();
		return (user != null);
		
		/*String query = "Select count(1) from users where email = ? and password = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return (resultSet.getInt(1) > 0);
		else
			return false;*/
	}
	
	/**
	 * Verifica se existe algum usu�rio com o email informado
	 * 
	 * @param email email
	 * @return verdadeiro se o usu�rio existir, falso caso contr�rio
	 * @author Alan Arantes Souza
	 */
	@Override
	public boolean isValidUser(String email){
		return (getUserByEmail(email) != null);
	}

}
