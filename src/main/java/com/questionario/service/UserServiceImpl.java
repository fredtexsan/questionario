package com.questionario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.questionario.dao.UserDAO;
import com.questionario.model.User;

/**
 * Classe que auxilia no controle do Model/DAO dos usuários
 * Implementa a interface UserService
 * Representa um serviço do spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	/*
	 * Objeto DAO do usuário
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Salva um usuário
	 * 
	 * @param user usuário a ser adicionado
	 * @return id do usuário adicionado
	 * @author Alan Arantes Souza
	 */
	@Override
	public int addUser(User user) {
		return userDAO.addUser(user);
	}

	/**
	 * Recupera um usuário pelo email referenciado
	 * 
	 * @param email email
	 * @return User usuário
	 * @author Alan Arantes Souza
	 */
	@Override
	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
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
		return userDAO.isValidUser(email, password);
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
		return userDAO.isValidUser(email);
	}
	
}
