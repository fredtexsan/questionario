package com.questionario.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.questionario.delegate.LoginDelegate;
import com.questionario.model.User;

/**
 * Classe que realiza o controle de login na aplicação tanto de usuários como
 * anônimos
 * Representa um controlador do Spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Controller
public class LoginController {
	
	/*
	 * Log
	 */
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	/*
	 * Objeto que será delegado a realizar o processo de login
	 */
	@Autowired
	private LoginDelegate loginDelegate;
	
	/**
	 * Primeira tela a ser chamada pela aplicação
	 * Direciona para a página de login
	 * 
	 * @return ModelAndView redireciona para a página de login
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("redirect:login");
		return modelAndView;
	}

	/**
	 * Direciona para a página de login
	 * 
	 * @return ModelAndView contendo a página de login
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	/**
	 * Primeira tela a ser chamada pela aplicação Direciona para a página de
	 * login
	 * 
	 * @param session
	 *            Sessão atual
	 * @param loginUser
	 *            Usuário a ser logado
	 * @return ModelAndView contendo a página que lista os questionários
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpSession session, @ModelAttribute("user") User loginUser) {
		logger.info("Iniciando o processo de login...");
		logger.debug("Email: " + loginUser.getEmail() + "-----" + "Senha: " + loginUser.getPassword());
		
		ModelAndView modelAndView = new ModelAndView("redirect:login");

		try {
			// Processo simples de login, apenas verifica se o email e senha
			// estão corretos
			boolean isValidUser = loginDelegate.isValidUser(loginUser.getEmail(), loginUser.getPassword());

			if (isValidUser) {
				// caso seja um usuário válido, adicona o email do mesmo na
				// sessão
				session.setAttribute("loggedInUser", loginUser.getEmail());
				// redireciona para a lista de questionários
				modelAndView = new ModelAndView("redirect:list");
				
				logger.info("Login efetuado com sucesso!!!");
			} else {
				// adiciona a mensagem de erro na sessão
				session.setAttribute("message", "Login inválido!");
				logger.info("Login inválido!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro inesperado ao efetuar o login!!!");
			logger.error("Email: " + loginUser.getEmail() + "-----" + "Senha: " + loginUser.getPassword());
		}

		// caso o usuário e senha não estejam corretos, redireciona para a tela
		// de login
		return modelAndView;
	}

	/**
	 * Remove o usuário da sessão Direciona para a página de login
	 * 
	 * @param session
	 *            Sessão atual
	 * @param loginUser
	 *            Usuário a ser deslogado
	 * @return ModelAndView redirecionando para a tela de login
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView executeLogout(HttpSession session, @ModelAttribute("user") User loginUser) {
		logger.info("Iniciando o processo de logout...");
		logger.debug("Email: " + loginUser.getEmail() + "-----" + "Senha: " + loginUser.getPassword());
		
		ModelAndView modelAndView = new ModelAndView("redirect:login");

		try {
			// processo simples de logout, apenas remore o usuário da sessão
			if (session.getAttribute("loggedInUser") != null) {
				session.removeAttribute("loggedInUser");
				logger.info("Logout efetuado com sucesso!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Ocorreu um erro inesperado ao efetuar o login!!!");
			logger.error("Email: " + loginUser.getEmail() + "-----" + "Senha: " + loginUser.getPassword());
		}

		// redireciona para a tela de login
		return modelAndView;
	}

}
