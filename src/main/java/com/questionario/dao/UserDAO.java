package com.questionario.dao;

import java.util.List;

import com.questionario.model.User;

/**
 * Interface que realiza o CRUD dos usuários
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public interface UserDAO {
	
	/**
	 * Salva um usuário
	 * 
	 * @param user usuário a ser adicionado
	 * @return id id do usuário adicionado
	 * @author Alan Arantes Souza
	 */
	public int addUser(User user);
	
	/**
	 * Recupera um usuário pelo id referenciado
	 * 
	 * @param id id do usuário
	 * @return User usuário
	 * @author Alan Arantes Souza
	 */
	public User getUser(int id);
	
	/**
	 * Recupera um usuário pelo email referenciado
	 * 
	 * @param email email do usuário
	 * @return User usuário
	 * @author Alan Arantes Souza
	 */
	public User getUserByEmail(String email);
	
	/**
	 * Recupera todos os usuários
	 * 
	 * @return List<User> lista de usuários
	 * @author Alan Arantes Souza
	 */
	public List<User> getUsers();
	
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
