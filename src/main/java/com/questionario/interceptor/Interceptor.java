package com.questionario.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Classe respons�vel por interceptar as chamadas da URL da aplica�ao
 * Pois algumas URL's s� podem ser acessadas por usu�rio autenticados
 * Implmenta o m�todo 'preHandle' do Spring
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
	 * M�todo chamado antes do acesso de cada URL
	 * respons�vel por verificar se o usu�rio possui permiss�o para acessar a URL desejada ou n�o
	 * 
	 * @param email email do usu�rio a ser logado
	 * @param password senha do usu�rio a ser logado
	 * @return verdadeiro se a combina��o estiver ok ou falso em caso contr�rio
	 * @author Alan Arantes Souza
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) {
		logger.debug("Interceptando requisi��o...");

		//recupera a URL acessada
		String uri = request.getRequestURI();
		
		//A �nica URL pro�bida para n�o usu�rios � a de cria��o de Formul�rios
		if (uri.endsWith("create")) {
			logger.debug("Interceptando URL de cria��o de question�rios...");
			
			//caso o usu�rio n�o esteja inclu�do na sess�o, deixa acessar
			if (request.getSession().getAttribute("loggedInUser") == null) {
				logger.debug("Usu�rio n�o logado!!!");
				
				try {
					//redireciona para a lista de question�rios
					response.sendRedirect(request.getContextPath() + "/list");
				} catch (IOException e) {
					e.printStackTrace();
					
					logger.error("Ocorreu um erro inesperado ao interceptar a requisi��o!!!");
				}
				
				return false;
			}
		}

		//para todas as outras p�ginas, sempre retorna true
		return true;
	}
}