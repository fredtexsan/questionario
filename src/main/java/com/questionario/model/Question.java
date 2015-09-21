package com.questionario.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe que representa a tabela de perguntas
 * Representa uma entidade do Hibernate
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Entity
@Table(name="questions")
public class Question {
	
	/*
	 * Objetos que representam as colunas da tabela de perguntas
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	Boolean type; 
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_questionnarie")
	private Questionnarie questionnarie;
	
	@OneToMany(mappedBy = "question", targetEntity = Option.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Option> options;
	
	/**
	 * Construtor padrão
	 * O comportamento padrão deste objeto são todos os elementos vazios
	 * 
	 * @author Alan Arantes Souza
	 */
	public Question() {
		
	}
	
	/**
	 * Recupera o id da pergunta
	 * @return id id da pergunta
	 * 
	 * @author Alan Arantes Souza
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Seta o id da pergunta
	 * 
	 * @param id id da pergunta
	 * @author Alan Arantes Souza
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Recupera a pergunta
	 * @return name pergunta
	 * 
	 * @author Alan Arantes Souza
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Seta a pergunta
	 * 
	 * @param name pergunta
	 * @author Alan Arantes Souza
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Recupera o tipo da pergunta
	 * aberta ou fechada
	 * @return type tipo da pergunta
	 * 
	 * @author Alan Arantes Souza
	 */
	public Boolean getType() {
		return type;
	}

	/**
	 * Seta o tipo da pergunta
	 * aberta ou fechada
	 * 
	 * @author Alan Arantes Souza
	 */
	public void setType(Boolean type) {
		this.type = type;
	}
	
	/**
	 * Recupera o questionário a qual a
	 * pergunta pertence
	 * @return questionnarie questionário
	 * 
	 * @author Alan Arantes Souza
	 */
	public Questionnarie getQuestionnarie() {
		return questionnarie;
	}

	/**
	 * Seta o questionário a qual a
	 * pergunta pertence
	 * 
	 * @param questionnarie questionário
	 * @author Alan Arantes Souza
	 */
	public void setQuestionnarie(Questionnarie questionnarie) {
		this.questionnarie = questionnarie;
	}
	
	/**
	 * Recupera as opções pertencentes
	 * a pergunta
	 * @return options lista de opções
	 * 
	 * @author Alan Arantes Souza
	 */
	public List<Option> getOptions() {
		return options;
	}

	/**
	 * Seta as opções pertencentes
	 * a pergunta
	 * 
	 * @param options opções
	 * @author Alan Arantes Souza
	 */
	public void setOptions(List<Option> options) {
		this.options = options;
	}
}
