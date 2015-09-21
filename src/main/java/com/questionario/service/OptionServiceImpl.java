package com.questionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.questionario.dao.OptionDAO;
import com.questionario.model.Option;

/**
 * Classe que auxilia no controle do Model/DAO das opções
 * Implementa a interface OptionService
 * Representa um serviço do spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Service
@Transactional
public class OptionServiceImpl implements OptionService{
	
	/*
	 * Objeto DAO da opção
	 */
	@Autowired
	private OptionDAO optionDAO;

	/**
	 * Salva uma opção
	 * 
	 * @param option opção a ser adicionada
	 * @return id da opção criada
	 * @author Alan Arantes Souza
	 */
	@Override
	public int addOption(Option option) {
		return optionDAO.addOption(option);
	}

	/**
	 * Retorna as opções pertencentes a pergunta
	 * referenciada pelo id
	 * 
	 * @param questionId id da pergunta
	 * @return List<Option> lista de opções
	 * @author Alan Arantes Souza
	 */
	@Override
	public List<Option> getOptionByQuestionId(int questionId) {
		return optionDAO.getOptionByQuestionId(questionId);
	}

}
