package com.questionario.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.questionario.service.UserService;

/**
 * Classe responsável por auxiliar na lógina de login
 * Representa um componente do Spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Component
public class LoginDelegate {
	/*
	 * Objeto de serviço que auxiliará no controle do Model/DAO de usuários
	 */
	@Autowired
	private UserService userService;

	/**
	 * Método que verifica se o usuário e senha informados são válidos
	 * 
	 * @param email email do usuário a ser logado
	 * @param password senha do usuário a ser logado
	 * @return verdadeiro se a combinação estiver ok ou falso em caso contrário
	 * @author Alan Arantes Souza
	 */
	public boolean isValidUser(String email, String password) {
		return userService.isValidUser(email, password);
	}

}
