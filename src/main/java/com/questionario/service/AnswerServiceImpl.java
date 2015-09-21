package com.questionario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.questionario.dao.AnswerDAO;
import com.questionario.model.Answer;

/**
 * Classe que auxilia no controle do Model/DAO das respostas
 * Implementa a interface AnswerService
 * Representa um servi�o do spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService{
	
	/*
	 * Objeto DAO da reposta
	 */
	@Autowired
	private AnswerDAO answerDAO;

	/**
	 * Salva uma resposta 
	 * 
	 * @param answer resposta a ser adicionada
	 * @author Alan Arantes Souza
	 */
	@Override
	public void addAnswer(Answer answer) {
		answerDAO.addAnswer(answer);
	}

	/**
	 * Verifica se o email informado j� respondeu o question�rio
	 * referenciado pela pergunta
	 * 
	 * @param questionId id da pergunta
	 * @param email email
	 * @return verdadeiro se o email informado j� tiver respondido, falso caso contr�rio
	 * @author Alan Arantes Souza
	 */
	@Override
	public boolean hasAnswer(int questionId, String email) {
		return answerDAO.hasAnswer(questionId, email);
	}
	
}
