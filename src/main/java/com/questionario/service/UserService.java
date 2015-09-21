package com.questionario.service;

import com.questionario.model.User;

/**
 * Interface que auxilia no controle do Model/DAO dos usuários
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public interface UserService {
	
	/**
	 * Salva um usuário
	 * 
	 * @param user usuário a ser adicionado
	 * @return id id do usuário adiconado
	 * @author Alan Arantes Souza
	 */
	public int addUser(User user);
	
	/**
	 * Recupera um usuário pelo email referenciado
	 * 
	 * @param email email
	 * @return User usuário
	 * @author Alan Arantes Souza
	 */
	public User getUserByEmail(String email);
	
	/**
	 * Verifica se existe algum usuário com o email e senha informados
	 * 
	 * @param email email
	 * @param password senha
	 * @return verdadeiro se o usuário existir, falso caso contrário
	 * @author Alan Arantes Souza
	 */
	public boolean isValidUser(String email, String password);
	
	/**
	 * Verifica se existe algum usuário com o email informado
	 * 
	 * @param email email
	 * @return verdadeiro se o usuário existir, falso caso contrário
	 * @author Alan Arantes Souza
	 */
	public boolean isValidUser(String email);
}
