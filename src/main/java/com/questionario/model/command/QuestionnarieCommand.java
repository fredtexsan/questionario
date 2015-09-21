package com.questionario.model.command;

import java.util.List;

import com.questionario.model.Option;
import com.questionario.model.Question;
import com.questionario.model.Questionnarie;

/**
 * Classe que representa um wrapper para os question�rios
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

public class QuestionnarieCommand {
	/*
	 * Objetos pertencentes ao question�rio
	 */
	Questionnarie questionnarie;
	
	List<Question> question;
	
	List<Option> option;
	
	/**
	 * Construtor padr�o
	 * O comportamento padr�o deste objeto s�o todos os elementos do queston�rio vazios
	 * 
	 * @author Alan Arantes Souza
	 */
	public QuestionnarieCommand() {
		
	}

	/**
	 * Construtor
	 * Seta os objetos pertencentes a um question�rio
	 * 
	 * @param questionnarie question�rio
	 * @param questions perguntas pertencentes ao question�rio
	 * @param option op��es pertencentes �s perguntas
	 * @author Alan Arantes Souza
	 */
	public QuestionnarieCommand(Questionnarie questionnarie, List<Question> questions, List<Option> option) {
		this.questionnarie = questionnarie;
		this.question = questions;
		this.option = option;
	}

	/**
	 * Recupera o question�rio
	 * @return questionnarie question�rio
	 * 
	 * @author Alan Arantes Souza
	 */
	public Questionnarie getQuestionnarie() {
		return questionnarie;
	}

	/**
	 * Seta o question�rio
	 * 
	 * @param questionnarie question�rio
	 * @author Alan Arantes Souza
	 */
	public void setQuestionnarie(Questionnarie questionnarie) {
		this.questionnarie = questionnarie;
	}

	/**
	 * Recupera as perguntas
	 * @return question quest�es
	 * 
	 * @author Alan Arantes Souza
	 */
	public List<Question> getQuestion() {
		return question;
	}

	/**
	 * Seta as quest�es
	 * 
	 * @param question lista de quest�es
	 * @author Alan Arantes Souza
	 */
	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	/**
	 * Recupera as op��es
	 * @return option op��es
	 * 
	 * @author Alan Arantes Souza
	 */
	public List<Option> getOption() {
		return option;
	}

	/**
	 * Seta as op��es
	 * 
	 * @param option lista de op��es
	 * @author Alan Arantes Souza
	 */
	public void setOption(List<Option> option) {
		this.option = option;
	}

}
