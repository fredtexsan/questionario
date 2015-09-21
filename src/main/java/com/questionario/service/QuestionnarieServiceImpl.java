package com.questionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.questionario.dao.QuestionnarieDAO;
import com.questionario.model.Questionnarie;

/**
 * Classe que auxilia no controle do Model/DAO dos questionários
 * Implementa a interface QuestionnarieService
 * Representa um serviço do spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Service
@Transactional
public class QuestionnarieServiceImpl implements QuestionnarieService{
	
	/*
	 * Objeto DAO do questionário
	 */
	@Autowired
	private QuestionnarieDAO questionnarieDAO;
	
	/**
	 * Salva uma opção
	 * 
	 * @param questionnarie questionário a ser adiconado
	 * @return id id do questionário salvo
	 * @author Alan Arantes Souza
	 */
	@Override
	public int addQuestionnarie(Questionnarie questionnarie) {
		return questionnarieDAO.addQuestionnarie(questionnarie);
	}

	/**
	 * Recupera um questionário pelo seu id
	 * 
	 * @param id id do questionário
	 * @return Questionnarie questionário
	 * @author Alan Arantes Souza
	 */
	@Override
	public Questionnarie getQuestionnarie(int id) {
		return questionnarieDAO.getQuestionnarie(id);
	}

	/**
	 * Recupera um questionário pelo seu id
	 * 
	 * @return List<Questionnarie> lista de questionários
	 * @author Alan Arantes Souza
	 */
	@Override
	public List<Questionnarie> getQuestionnaries() {
		return questionnarieDAO.getQuestionnaries();
	}

}
