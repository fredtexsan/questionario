package com.questionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.questionario.dao.QuestionnarieDAO;
import com.questionario.model.Questionnarie;

/**
 * Classe que auxilia no controle do Model/DAO dos question�rios
 * Implementa a interface QuestionnarieService
 * Representa um servi�o do spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Service
@Transactional
public class QuestionnarieServiceImpl implements QuestionnarieService{
	
	/*
	 * Objeto DAO do question�rio
	 */
	@Autowired
	private QuestionnarieDAO questionnarieDAO;
	
	/**
	 * Salva uma op��o
	 * 
	 * @param questionnarie question�rio a ser adiconado
	 * @return id id do question�rio salvo
	 * @author Alan Arantes Souza
	 */
	@Override
	public int addQuestionnarie(Questionnarie questionnarie) {
		return questionnarieDAO.addQuestionnarie(questionnarie);
	}

	/**
	 * Recupera um question�rio pelo seu id
	 * 
	 * @param id id do question�rio
	 * @return Questionnarie question�rio
	 * @author Alan Arantes Souza
	 */
	@Override
	public Questionnarie getQuestionnarie(int id) {
		return questionnarieDAO.getQuestionnarie(id);
	}

	/**
	 * Recupera um question�rio pelo seu id
	 * 
	 * @return List<Questionnarie> lista de question�rios
	 * @author Alan Arantes Souza
	 */
	@Override
	public List<Questionnarie> getQuestionnaries() {
		return questionnarieDAO.getQuestionnaries();
	}

}
