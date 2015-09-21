package com.questionario.dao;

import java.util.List;

import com.questionario.model.Option;

/**
 * Interface que realiza o CRUD das op��es
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public interface OptionDAO {
	
	/**
	 * Salva uma op��o 
	 * 
	 * @param option op��o a ser adicionada
	 * @return id da op��o criada
	 * @author Alan Arantes Souza
	 */
	public int addOption(Option option);
	
	/**
	 * Recupera uma op��o
	 * 
	 * @param id id da op��o a ser recuperada
	 * @return Option op��o
	 * @author Alan Arantes Souza
	 */
	public Option getOption(int id);
	
	/**
	 * Recupera todas as op��es
	 * 
	 * @return List<Option> lista de op��es
	 * @author Alan Arantes Souza
	 */
	public List<Option> getOptions();
	
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
