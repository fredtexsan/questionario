package com.questionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.questionario.dao.QuestionDAO;
import com.questionario.model.Question;

/**
 * Classe que auxilia no controle do Model/DAO das perguntas
 * Implementa a interface QuestionService
 * Representa um serviço do spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
	
	/*
	 * Objeto DAO da pergunta
	 */
	@Autowired
	private QuestionDAO questionDAO;

	/**
	 * Salva uma pergunta
	 * 
	 * @param question pergunta a ser adicionada
	 * @return id id da pergunta salva
	 * @author Alan Arantes Souza
	 */
	
	@Override
	public int addQuestion(Question question) {
		return questionDAO.addQuestion(question);
	}

	/**
	 * Recupera uma pergunta pelo seu id
	 * 
	 * @param int id pergunta
	 * @return Question pergunta
	 * @author Alan Arantes Souza
	 */
	@Override
	public Question getQuestion(int id) {
		return questionDAO.getQuestion(id);
	}

	/**
	 * Recupera todas as perguntas pertencentes
	 * ao questionário referenciado pelo id
	 * 
	 * @param id id do questionário
	 * @return List<Question> lista de perguntas
	 * @author Alan Arantes Souza
	 */
	@Override
	public List<Question> getQuestionsByQuestionnarieId(int id) {
		return questionDAO.getQuestionsByQuestionnarieId(id);
	}
}
