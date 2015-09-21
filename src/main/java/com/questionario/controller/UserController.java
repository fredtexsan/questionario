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
 * Classe que realiza o controle da criação de usuários Esta aplicação apenas
 * realiza a criação de usuários Não está incluso as funcionalidades de
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
	 * Objeto de serviço que auxiliará no controle do Model/DAO de usuários
	 */
	@Autowired
	private UserService userService;

	/**
	 * Método que direciona para a página de criação de usuários
	 * 
	 * @return ModelAndView contendo a página de criação de usuários
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public ModelAndView addUser() {
		logger.info("Iniciando o processo de criação de usuário...");
		ModelAndView modelAndView = new ModelAndView("add-user");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	/**
	 * Método que cria um usuário na aplicação
	 * 
	 * @param user usuário a ser criado
	 * @return ModelAndView redirecionando para a tela de login
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public ModelAndView addingUser(@ModelAttribute User user) {
		logger.debug("Email: " + user.getEmail() + "-----" + "Senha: " + user.getPassword());
		
		// apenas salva o usuário e redireciona para a tela de login
		userService.addUser(user);

		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("message", "Usuário adicionado com sucesso!");
		
		logger.info("Usuário adicionado com sucesso!!!");

		return modelAndView;
	}
}
