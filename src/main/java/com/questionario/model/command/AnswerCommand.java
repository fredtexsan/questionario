package com.questionario.model.command;

import java.util.List;

import com.questionario.model.Answer;

/**
 * Classe que representa um wrapper para as repostas dos questionários
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public class AnswerCommand {
	/*
	 * Lista de respostas
	 */
	List<Answer> answers;
	
	/**
	 * Construtor padrão
	 * O comportamento padrão deste objeto é uma lista de respostas vazias
	 * 
	 * @author Alan Arantes Souza
	 */
	public AnswerCommand() {
		
	}

	/**
	 * Construtor onde é informado uma lista de respostas
	 * @param answers seta a lista de respostas
	 * 
	 * @author Alan Arantes Souza
	 */
	public AnswerCommand(List<Answer> answers) {
		this.answers = answers;
	}

	/**
	 * Recupera as respostas
	 * 
	 * @return answers lista de respostas
	 * @author Alan Arantes Souza
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * Seta as respostas
	 * 
	 * @param answer seta a lista de respostas
	 * @author Alan Arantes Souza
	 */
	public void setAnswers(List<Answer> answer) {
		this.answers = answer;
	}
	
}
