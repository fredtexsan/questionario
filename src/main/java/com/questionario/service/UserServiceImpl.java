package com.questionario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.questionario.dao.UserDAO;
import com.questionario.model.User;

/**
 * Classe que auxilia no controle do Model/DAO dos usu�rios
 * Implementa a interface UserService
 * Representa um servi�o do spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	/*
	 * Objeto DAO do usu�rio
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Salva um usu�rio
	 * 
	 * @param user usu�rio a ser adicionado
	 * @return id do usu�rio adicionado
	 * @author Alan Arantes Souza
	 */
	@Override
	public int addUser(User user) {
		return userDAO.addUser(user);
	}

	/**
	 * Recupera um usu�rio pelo email referenciado
	 * 
	 * @param email email
	 * @return User usu�rio
	 * @author Alan Arantes Souza
	 */
	@Override
	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
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
		return userDAO.isValidUser(email, password);
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
		return userDAO.isValidUser(email);
	}
	
}
