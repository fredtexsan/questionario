package com.questionario.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.questionario.service.UserService;

/**
 * Classe respons�vel por auxiliar na l�gina de login
 * Representa um componente do Spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Component
public class LoginDelegate {
	/*
	 * Objeto de servi�o que auxiliar� no controle do Model/DAO de usu�rios
	 */
	@Autowired
	private UserService userService;

	/**
	 * M�todo que verifica se o usu�rio e senha informados s�o v�lidos
	 * 
	 * @param email email do usu�rio a ser logado
	 * @param password senha do usu�rio a ser logado
	 * @return verdadeiro se a combina��o estiver ok ou falso em caso contr�rio
	 * @author Alan Arantes Souza
	 */
	public boolean isValidUser(String email, String password) {
		return userService.isValidUser(email, password);
	}

}
