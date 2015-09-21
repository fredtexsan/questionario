package com.questionario.service;

import com.questionario.model.User;

/**
 * Interface que auxilia no controle do Model/DAO dos usu�rios
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public interface UserService {
	
	/**
	 * Salva um usu�rio
	 * 
	 * @param user usu�rio a ser adicionado
	 * @return id id do usu�rio adiconado
	 * @author Alan Arantes Souza
	 */
	public int addUser(User user);
	
	/**
	 * Recupera um usu�rio pelo email referenciado
	 * 
	 * @param email email
	 * @return User usu�rio
	 * @author Alan Arantes Souza
	 */
	public User getUserByEmail(String email);
	
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
