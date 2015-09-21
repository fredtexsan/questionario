package com.questionario.service;

import java.util.List;

import com.questionario.model.Questionnarie;

/**
 * Interface que auxilia no controle do Model/DAO dos question�rios
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public interface QuestionnarieService {
	
	/**
	 * Salva um question�rio
	 * 
	 * @param questionnarie question�rio a ser adicionado
	 * @author Alan Arantes Souza
	 */
	public int addQuestionnarie(Questionnarie questionnarie);
	
	/**
	 * Recupera um question�rio
	 * 
	 * @param id id do question�rio a ser recuperado
	 * @return Questionnarie question�rio
	 * @author Alan Arantes Souza
	 */
	public Questionnarie getQuestionnarie(int id);
	
	/**
	 * Recupera todos os question�rio
	 * 
	 * @return List<Questionnarie> lista de question�rios
	 * @author Alan Arantes Souza
	 */
	public List<Questionnarie> getQuestionnaries();
}
