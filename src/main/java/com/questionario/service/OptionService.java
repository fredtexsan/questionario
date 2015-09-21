package com.questionario.service;

import java.util.List;

import com.questionario.model.Option;

/**
 * Interface que auxilia no controle do Model/DAO das opções
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public interface OptionService {
	
	/**
	 * Salva uma opção 
	 * 
	 * @param option opção a ser adicionada
	 * @return id da opção criada
	 * @author Alan Arantes Souza
	 */
	public int addOption(Option option);
	
	/**
	 * Retorna as opções pertencentes a pergunta
	 * referenciada pelo id
	 * 
	 * @param questionId id da opção
	 * @return List<Option> lista de opções
	 * @author Alan Arantes Souza
	 */
	public List<Option> getOptionByQuestionId(int questionId);
}
