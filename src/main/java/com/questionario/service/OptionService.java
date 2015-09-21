package com.questionario.service;

import java.util.List;

import com.questionario.model.Option;

/**
 * Interface que auxilia no controle do Model/DAO das op��es
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public interface OptionService {
	
	/**
	 * Salva uma op��o 
	 * 
	 * @param option op��o a ser adicionada
	 * @return id da op��o criada
	 * @author Alan Arantes Souza
	 */
	public int addOption(Option option);
	
	/**
	 * Retorna as op��es pertencentes a pergunta
	 * referenciada pelo id
	 * 
	 * @param questionId id da op��o
	 * @return List<Option> lista de op��es
	 * @author Alan Arantes Souza
	 */
	public List<Option> getOptionByQuestionId(int questionId);
}
