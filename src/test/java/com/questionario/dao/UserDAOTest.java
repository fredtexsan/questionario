package com.questionario.dao;

import static org.junit.Assert.*;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.questionario.model.User;

@Transactional
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTest {
	@Resource
	private SessionFactory sessionFactory;
	
	User user;
	String email;
	String password;

	@Before
	public void setUp() {
		this.email = "test@test.com";
		this.password = "123456";
		
		this.user = new User();
		this.user.setEmail(email);
		this.user.setPassword(password);
	}

	@Test
	public void testAddUserTest() {
		UserDAO dao = new UserDAOImpl(sessionFactory);
		int id = dao.addUser(user);

		assertTrue(id > 0);
	}
	
	@Test
	public void testGetUserTest() {
		UserDAO dao = new UserDAOImpl(sessionFactory);
		int id = dao.addUser(user);
		
		assertNotNull(dao.getUser(id));
	}
	
	@Test
	public void testGetUserByEmailTest() {
		UserDAO dao = new UserDAOImpl(sessionFactory);
		dao.addUser(user);
		
		User userEmail = dao.getUserByEmail(email);
		
		if(userEmail != null) {
			assertEquals(email, dao.getUserByEmail(email).getEmail());
		} else {
			fail("Usuário não foi retornado");
		}
	}
	
	@Test
	public void getUsersTest() {
		UserDAO dao = new UserDAOImpl(sessionFactory);
		dao.addUser(user);
		
		user.setEmail("outro@teste.com");
		user.setPassword("654321");
		
		dao.addUser(user);
		
		assertTrue(dao.getUsers().size() > 1);
	}
	
	@Test
	public void isValidUserEmailTest() {
		UserDAO dao = new UserDAOImpl(sessionFactory);
		dao.addUser(user);
		
		assertTrue(dao.isValidUser(email));
	}
	
	@Test
	public void isValidUserEmailPasswordTest() {
		String email = "test@test.com";
		String senha = "123456";
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(senha);

		UserDAO dao = new UserDAOImpl(sessionFactory);
		dao.addUser(user);
		
		assertTrue(dao.isValidUser(email, senha));
	}
}
