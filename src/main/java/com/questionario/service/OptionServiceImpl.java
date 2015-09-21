package com.questionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.questionario.dao.OptionDAO;
import com.questionario.model.Option;

/**
 * Classe que auxilia no controle do Model/DAO das op��es
 * Implementa a interface OptionService
 * Representa um servi�o do spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Service
@Transactional
public class OptionServiceImpl implements OptionService{
	
	/*
	 * Objeto DAO da op��o
	 */
	@Autowired
	private OptionDAO optionDAO;

	/**
	 * Salva uma op��o
	 * 
	 * @param option op��o a ser adicionada
	 * @return id da op��o criada
	 * @author Alan Arantes Souza
	 */
	@Override
	public int addOption(Option option) {
		return optionDAO.addOption(option);
	}

	/**
	 * Retorna as op��es pertencentes a pergunta
	 * referenciada pelo id
	 * 
	 * @param questionId id da pergunta
	 * @return List<Option> lista de op��es
	 * @author Alan Arantes Souza
	 */
	@Override
	public List<Option> getOptionByQuestionId(int questionId) {
		return optionDAO.getOptionByQuestionId(questionId);
	}

}
