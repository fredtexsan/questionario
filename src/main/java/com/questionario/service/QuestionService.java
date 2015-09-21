package com.questionario.service;

import java.util.List;

import com.questionario.model.Question;

/**
 * Interface que auxilia no controle do Model/DAO das perguntas
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public interface QuestionService {
	
	/**
	 * Salva uma pergunta
	 * 
	 * @param question pergunta a ser adicionada
	 * @return id id da pergunta salva
	 * @author Alan Arantes Souza
	 */
	public int addQuestion(Question question);
	
	/**
	 * Recupera uma pergunta pelo seu id
	 * 
	 * @param int id pergunta
	 * @return Question pergunta
	 * @author Alan Arantes Souza
	 */
	public Question getQuestion(int id);
	
	/**
	 * Recupera todas as perguntas pertencentes
	 * ao questionário referenciado pelo id
	 * 
	 * @param id id do questionário
	 * @return List<Question> lista de perguntas
	 * @author Alan Arantes Souza
	 */
	public List<Question> getQuestionsByQuestionnarieId(int id);
	
}
