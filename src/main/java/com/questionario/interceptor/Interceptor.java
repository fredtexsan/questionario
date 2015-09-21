package com.questionario.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Classe responsável por interceptar as chamadas da URL da aplicaçao
 * Pois algumas URL's só podem ser acessadas por usuário autenticados
 * Implmenta o método 'preHandle' do Spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public class Interceptor extends HandlerInterceptorAdapter {
	
	/*
	 * Log
	 */
	final static Logger logger = Logger.getLogger(Interceptor.class);

	/**
	 * Método chamado antes do acesso de cada URL
	 * responsável por verificar se o usuário possui permissão para acessar a URL desejada ou não
	 * 
	 * @param email email do usuário a ser logado
	 * @param password senha do usuário a ser logado
	 * @return verdadeiro se a combinação estiver ok ou falso em caso contrário
	 * @author Alan Arantes Souza
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) {
		logger.debug("Interceptando requisição...");

		//recupera a URL acessada
		String uri = request.getRequestURI();
		
		//A única URL proíbida para não usuários é a de criação de Formulários
		if (uri.endsWith("create")) {
			logger.debug("Interceptando URL de criação de questionários...");
			
			//caso o usuário não esteja incluído na sessão, deixa acessar
			if (request.getSession().getAttribute("loggedInUser") == null) {
				logger.debug("Usuário não logado!!!");
				
				try {
					//redireciona para a lista de questionários
					response.sendRedirect(request.getContextPath() + "/list");
				} catch (IOException e) {
					e.printStackTrace();
					
					logger.error("Ocorreu um erro inesperado ao interceptar a requisição!!!");
				}
				
				return false;
			}
		}

		//para todas as outras páginas, sempre retorna true
		return true;
	}
}