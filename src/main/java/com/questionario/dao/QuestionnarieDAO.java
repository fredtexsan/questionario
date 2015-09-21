package com.questionario.dao;

import java.util.List;

import com.questionario.model.Questionnarie;

/**
 * Interface que realiza o CRUD dos questionários
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public interface QuestionnarieDAO {
	
	/**
	 * Salva um questionário
	 * 
	 * @param questionnarie questionário a ser adicionado
	 * @author Alan Arantes Souza
	 */
	public int addQuestionnarie(Questionnarie questionnarie);
	
	/**
	 * Recupera um questionário
	 * 
	 * @param id id do questionário a ser recuperado
	 * @return Questionnarie questionário
	 * @author Alan Arantes Souza
	 */
	public Questionnarie getQuestionnarie(int id);
	
	/**
	 * Recupera todos os questionário
	 * 
	 * @return List<Questionnarie> lista de questionários
	 * @author Alan Arantes Souza
	 */
	public List<Questionnarie> getQuestionnaries();
}
