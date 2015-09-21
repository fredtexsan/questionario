package com.questionario.dao;

import java.util.List;

import com.questionario.model.Option;

/**
 * Interface que realiza o CRUD das opções
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public interface OptionDAO {
	
	/**
	 * Salva uma opção 
	 * 
	 * @param option opção a ser adicionada
	 * @return id da opção criada
	 * @author Alan Arantes Souza
	 */
	public int addOption(Option option);
	
	/**
	 * Recupera uma opção
	 * 
	 * @param id id da opção a ser recuperada
	 * @return Option opção
	 * @author Alan Arantes Souza
	 */
	public Option getOption(int id);
	
	/**
	 * Recupera todas as opções
	 * 
	 * @return List<Option> lista de opções
	 * @author Alan Arantes Souza
	 */
	public List<Option> getOptions();
	
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
