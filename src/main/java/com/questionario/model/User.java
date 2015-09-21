package com.questionario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa a tabela de usu�rios
 * Representa uma entidade do Hibernate
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Entity
@Table(name="users")
public class User {
	
	/*
	 * Objetos que representam as colunas da tabela de usu�rios
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	/**
	 * Construtor padr�o
	 * O comportamento padr�o deste objeto s�o todos os elementos vazios
	 * 
	 * @author Alan Arantes Souza
	 */
	public User() {
		
	}
	
	/**
	 * Recupera o id do usu�rio
	 * @return id id do usu�rio
	 * 
	 * @author Alan Arantes Souza
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Seta o id do usu�rio
	 * 
	 * @param id id do usu�rio
	 * @author Alan Arantes Souza
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Recupera o email do usu�rio
	 * @return email email do usu�rio
	 * 
	 * @author Alan Arantes Souza
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Seta o email do usu�rio
	 * 
	 * @param email email do usu�rio
	 * @author Alan Arantes Souza
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Recupera a senha do usu�rio
	 * @return password senha do usu�rio
	 * 
	 * @author Alan Arantes Souza
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Seta a senha do usu�rio
	 * 
	 * @param password senha do usu�rio
	 * @author Alan Arantes Souza
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
