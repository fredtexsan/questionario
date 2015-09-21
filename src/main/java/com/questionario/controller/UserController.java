package com.questionario.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.questionario.model.User;
import com.questionario.service.UserService;

/**
 * Classe que realiza o controle da cria��o de usu�rios Esta aplica��o apenas
 * realiza a cria��o de usu�rios N�o est� incluso as funcionalidades de
 * update/delete
 * Representa um controlador do Spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Controller
public class UserController {
	
	/*
	 * Log
	 */
	final static Logger logger = Logger.getLogger(UserController.class);
	
	/*
	 * Objeto de servi�o que auxiliar� no controle do Model/DAO de usu�rios
	 */
	@Autowired
	private UserService userService;

	/**
	 * M�todo que direciona para a p�gina de cria��o de usu�rios
	 * 
	 * @return ModelAndView contendo a p�gina de cria��o de usu�rios
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public ModelAndView addUser() {
		logger.info("Iniciando o processo de cria��o de usu�rio...");
		ModelAndView modelAndView = new ModelAndView("add-user");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	/**
	 * M�todo que cria um usu�rio na aplica��o
	 * 
	 * @param user usu�rio a ser criado
	 * @return ModelAndView redirecionando para a tela de login
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public ModelAndView addingUser(@ModelAttribute User user) {
		logger.debug("Email: " + user.getEmail() + "-----" + "Senha: " + user.getPassword());
		
		// apenas salva o usu�rio e redireciona para a tela de login
		userService.addUser(user);

		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("message", "Usu�rio adicionado com sucesso!");
		
		logger.info("Usu�rio adicionado com sucesso!!!");

		return modelAndView;
	}
}
