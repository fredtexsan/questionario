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
 * Classe que realiza o CRUD dos usuários
 * Implementa a interface UserDAO
 * Representa um repositório do spring
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
	 * Construtor padrão
	 * O comportamento padrão deste objeto são todos os elementos vazios
	 * 
	 * @author Alan Arantes Souza
	 */
	public UserDAOImpl() {
		
	}
	
	/**
	 * Construtor
	 * @param sessionFactory fábrica de sessões
	 * 
	 * @author Alan Arantes Souza
	 */
	public UserDAOImpl(SessionFactory sessionFactory) {
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
	 * Salva um usuário
	 * 
	 * @param user usuário a ser adicionado
	 * @return id do usuário adicionado
	 * @author Alan Arantes Souza
	 */
	@Override
	public int addUser(User user) {
		return (int) getCurrentSession().save(user);
	}

	/**
	 * Recupera um usuário pelo id referenciado
	 * 
	 * @param id id do usuário
	 * @return User usuário
	 * @author Alan Arantes Souza
	 */
	@Override
	public User getUser(int id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}
	
	/**
	 * Recupera um usuário pelo email referenciado
	 * 
	 * @param email email do usuário
	 * @return User usuário
	 * @author Alan Arantes Souza
	 */
	@Override
	public User getUserByEmail(String email) {
		Criteria criteria = getCurrentSession().createCriteria(User.class);
		return (User) criteria.add(Restrictions.eq("email", email)).uniqueResult();
	}

	/**
	 * Recupera todos os usuários
	 * 
	 * @return List<User> lista de usuários
	 * @author Alan Arantes Souza
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User").list();
	}

	/**
	 * Verifica se existe algum usuário com o email e senha informados
	 * 
	 * @param email email
	 * @param password senha
	 * @return verdadeiro se o usuário existir, falso caso contrário
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
	 * Verifica se existe algum usuário com o email informado
	 * 
	 * @param email email
	 * @return verdadeiro se o usuário existir, falso caso contrário
	 * @author Alan Arantes Souza
	 */
	@Override
	public boolean isValidUser(String email){
		return (getUserByEmail(email) != null);
	}

}
