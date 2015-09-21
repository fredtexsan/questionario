package com.questionario.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe que representa a tabela de respostas
 * Representa uma entidade do Hibernate
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Entity
@Table(name="answers")
public class Answer {
	
	/*
	 * Objetos que representam as colunas da tabela de respostas
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_question")
	private Question question;
	
	/**
	 * Construtor padrão
	 * O comportamento padrão deste objeto são todos os elementos vazios
	 * 
	 * @author Alan Arantes Souza
	 */
	public Answer() {
		
	}
	
	/**
	 * Recupera o id da resposta
	 * @return id id da reposta
	 * 
	 * @author Alan Arantes Souza
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Seta o id da resposta
	 * 
	 * @param id id da resposta
	 * @author Alan Arantes Souza
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Recupera o email da resposta
	 * @return email email da reposta
	 * 
	 * @author Alan Arantes Souza
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Seta o email da resposta
	 * 
	 * @param email email da resposta
	 * @author Alan Arantes Souza
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Recupera a resposta
	 * @return name resposta
	 * 
	 * @author Alan Arantes Souza
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Seta a resposta
	 * 
	 * @param name resposta
	 * @author Alan Arantes Souza
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Recupera a pergunta a qual a
	 * resposta pertence
	 * @return question pergunta
	 * 
	 * @author Alan Arantes Souza
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * Seta a pergunta a qual a
	 * resposta pertence
	 * 
	 * @param question pergunta
	 * @author Alan Arantes Souza
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
}
