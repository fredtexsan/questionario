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
 * Classe que representa a tabela de questionários
 * Representa uma entidade do Hibernate
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Entity
@Table(name="questionnaries")
public class Questionnarie {
	
	/*
	 * Objetos que representam as colunas da tabela de questionários
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
	private User user;
	
	/**
	 * Construtor padrão
	 * O comportamento padrão deste objeto são todos os elementos vazios
	 * 
	 * @author Alan Arantes Souza
	 */
	public Questionnarie() {
		
	}
	
	/**
	 * Recupera o id do questionário
	 * @return id id do questionário
	 * 
	 * @author Alan Arantes Souza
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Seta o id do questionário
	 * 
	 * @param id id do questionário
	 * @author Alan Arantes Souza
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Recupera o nome do questionário
	 * @return name pergunta
	 * 
	 * @author Alan Arantes Souza
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Seta o nome do questionário
	 * 
	 * @param name nome do questonário
	 * @author Alan Arantes Souza
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Recupera o usuário que criou
	 * o questionário
	 * @return user usuário que criou o questionário
	 * 
	 * @author Alan Arantes Souza
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Seta o usuário que criou
	 * o questionário
	 * 
	 * @param user usuário
	 * @author Alan Arantes Souza
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
