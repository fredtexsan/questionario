package com.questionario.dao;

import java.util.List;

import com.questionario.model.User;

/**
 * Interface que realiza o CRUD dos usu�rios
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public interface UserDAO {
	
	/**
	 * Salva um usu�rio
	 * 
	 * @param user usu�rio a ser adicionado
	 * @return id id do usu�rio adicionado
	 * @author Alan Arantes Souza
	 */
	public int addUser(User user);
	
	/**
	 * Recupera um usu�rio pelo id referenciado
	 * 
	 * @param id id do usu�rio
	 * @return User usu�rio
	 * @author Alan Arantes Souza
	 */
	public User getUser(int id);
	
	/**
	 * Recupera um usu�rio pelo email referenciado
	 * 
	 * @param email email do usu�rio
	 * @return User usu�rio
	 * @author Alan Arantes Souza
	 */
	public User getUserByEmail(String email);
	
	/**
	 * Recupera todos os usu�rios
	 * 
	 * @return List<User> lista de usu�rios
	 * @author Alan Arantes Souza
	 */
	public List<User> getUsers();
	
	/**
	 * Verifica se existe algum usu�rio com o email e senha informados
	 * 
	 * @param email email
	 * @param password senha
	 * @return verdadeiro se o usu�rio existir, falso caso contr�rio
	 * @author Alan Arantes Souza
	 */
	public boolean isValidUser(String email, String password);
	
	/**
	 * Verifica se existe algum usu�rio com o email informado
	 * 
	 * @param email email
	 * @return verdadeiro se o usu�rio existir, falso caso contr�rio
	 * @author Alan Arantes Souza
	 */
	public boolean isValidUser(String email);
}
