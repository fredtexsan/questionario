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
 * Classe que representa a tabela de question�rios
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
	 * Objetos que representam as colunas da tabela de question�rios
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
	 * Construtor padr�o
	 * O comportamento padr�o deste objeto s�o todos os elementos vazios
	 * 
	 * @author Alan Arantes Souza
	 */
	public Questionnarie() {
		
	}
	
	/**
	 * Recupera o id do question�rio
	 * @return id id do question�rio
	 * 
	 * @author Alan Arantes Souza
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Seta o id do question�rio
	 * 
	 * @param id id do question�rio
	 * @author Alan Arantes Souza
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Recupera o nome do question�rio
	 * @return name pergunta
	 * 
	 * @author Alan Arantes Souza
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Seta o nome do question�rio
	 * 
	 * @param name nome do queston�rio
	 * @author Alan Arantes Souza
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Recupera o usu�rio que criou
	 * o question�rio
	 * @return user usu�rio que criou o question�rio
	 * 
	 * @author Alan Arantes Souza
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Seta o usu�rio que criou
	 * o question�rio
	 * 
	 * @param user usu�rio
	 * @author Alan Arantes Souza
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
