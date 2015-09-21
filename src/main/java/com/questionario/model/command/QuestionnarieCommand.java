package com.questionario.model.command;

import java.util.List;

import com.questionario.model.Option;
import com.questionario.model.Question;
import com.questionario.model.Questionnarie;

/**
 * Classe que representa um wrapper para os questionários
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public class QuestionnarieCommand {
	/*
	 * Objetos pertencentes ao questionário
	 */
	Questionnarie questionnarie;
	
	List<Question> question;
	
	List<Option> option;
	
	/**
	 * Construtor padrão
	 * O comportamento padrão deste objeto são todos os elementos do questonário vazios
	 * 
	 * @author Alan Arantes Souza
	 */
	public QuestionnarieCommand() {
		
	}

	/**
	 * Construtor
	 * Seta os objetos pertencentes a um questionário
	 * 
	 * @param questionnarie questionário
	 * @param questions perguntas pertencentes ao questionário
	 * @param option opções pertencentes às perguntas
	 * @author Alan Arantes Souza
	 */
	public QuestionnarieCommand(Questionnarie questionnarie, List<Question> questions, List<Option> option) {
		this.questionnarie = questionnarie;
		this.question = questions;
		this.option = option;
	}

	/**
	 * Recupera o questionário
	 * @return questionnarie questionário
	 * 
	 * @author Alan Arantes Souza
	 */
	public Questionnarie getQuestionnarie() {
		return questionnarie;
	}

	/**
	 * Seta o questionário
	 * 
	 * @param questionnarie questionário
	 * @author Alan Arantes Souza
	 */
	public void setQuestionnarie(Questionnarie questionnarie) {
		this.questionnarie = questionnarie;
	}

	/**
	 * Recupera as perguntas
	 * @return question questões
	 * 
	 * @author Alan Arantes Souza
	 */
	public List<Question> getQuestion() {
		return question;
	}

	/**
	 * Seta as questões
	 * 
	 * @param question lista de questões
	 * @author Alan Arantes Souza
	 */
	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	/**
	 * Recupera as opções
	 * @return option opções
	 * 
	 * @author Alan Arantes Souza
	 */
	public List<Option> getOption() {
		return option;
	}

	/**
	 * Seta as opções
	 * 
	 * @param option lista de opções
	 * @author Alan Arantes Souza
	 */
	public void setOption(List<Option> option) {
		this.option = option;
	}

}
