package com.questionario.service;

import com.questionario.model.Answer;

/**
 * Interface que auxilia no controle do Model/DAO das respostas
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public interface AnswerService {
	
	/**
	 * Salva uma resposta 
	 * 
	 * @param answer resposta a ser adicionada
	 * @author Alan Arantes Souza
	 */
	public void addAnswer(Answer answer);
	
	/**
	 * Verifica se o email informado já respondeu o questionário
	 * referenciado pela pergunta
	 * 
	 * @param questionId id da pergunta
	 * @param email email
	 * @return verdadeiro se o email informado já tiver respondido, falso caso contrário
	 * @author Alan Arantes Souza
	 */
	public boolean hasAnswer(int questionId, String email);
}
