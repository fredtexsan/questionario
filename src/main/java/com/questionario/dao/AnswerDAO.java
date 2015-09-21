package com.questionario.dao;

import java.util.List;

import com.questionario.model.Answer;

/**
 * Interface que realiza o CRUD das respostas
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public interface AnswerDAO {
	
	/**
	 * Salva uma resposta 
	 * 
	 * @param answer resposta a ser adicionada
	 * @author Alan Arantes Souza
	 */
	public void addAnswer(Answer answer);
	
	/**
	 * Recupera uma resposta
	 * 
	 * @param id id da resposta a ser recuperada
	 * @return Answer resposta
	 * @author Alan Arantes Souza
	 */
	public Answer getAnswer(int id);
	
	/**
	 * Recupera todas as resposta
	 * 
	 * @return List<Answer> lista de respostas
	 * @author Alan Arantes Souza
	 */
	public List<Answer> getAnswers();
	
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
