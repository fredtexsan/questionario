package com.questionario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe que representa a tabela de op��es
 * Representa uma entidade do Hibernate
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Entity
@Table(name = "options")
public class Option {

	/*
	 * Objetos que representam as colunas da tabela de op��es
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_question", nullable = false)
	private Question question;

	/**
	 * Construtor padr�o
	 * O comportamento padr�o deste objeto s�o todos os elementos vazios
	 * 
	 * @author Alan Arantes Souza
	 */
	public Option() {

	}

	/**
	 * Recupera o id da op��o
	 * @return id id da op��o
	 * 
	 * @author Alan Arantes Souza
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Seta o id da op��o
	 * 
	 * @param id id da op��o
	 * @author Alan Arantes Souza
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Recupera a op��o
	 * @return name op��o
	 * 
	 * @author Alan Arantes Souza
	 */
	public String getName() {
		return name;
	}

	/**
	 * Seta a op��o
	 * 
	 * @param name op��o
	 * @author Alan Arantes Souza
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Recupera a pergunta a qual a
	 * op��o pertence
	 * @return question pergunta
	 * 
	 * @author Alan Arantes Souza
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * Seta a pergunta a qual a
	 * op��o pertence
	 * 
	 * @param question pergunta
	 * @author Alan Arantes Souza
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
}
