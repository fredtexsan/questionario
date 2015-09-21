package com.questionario.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.questionario.model.Questionnarie;
import com.questionario.model.User;

@Transactional
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@RunWith(SpringJUnit4ClassRunner.class)
public class QuestionnarieDAOTest {
	@Resource
	private SessionFactory sessionFactory;
	
	User user;
	String email;
	String password;
	
	Questionnarie questionnarie;

	@Before
	public void setUp() {
		this.email = "test@test.com";
		this.password = "123456";
		
		this.user = new User();
		this.user.setEmail(email);
		this.user.setPassword(password);
		
		this.questionnarie = new Questionnarie();
		this.questionnarie.setName("Questionário 1");
	}

	@Test
	public void testAddQuestionnarieTest() {
		UserDAO userDAO = new UserDAOImpl(sessionFactory);
		int idUser = userDAO.addUser(user);
		
		questionnarie.setUser(userDAO.getUser(idUser));
		
		QuestionnarieDAO questionnarieDAO = new QuestionnarieDAOImpl(sessionFactory);
		int idQuestionnarie = questionnarieDAO.addQuestionnarie(questionnarie);

		assertTrue(idQuestionnarie > 0);
	}
	
	@Test
	public void testGetQuestionnarieTest() {
		UserDAO userDAO = new UserDAOImpl(sessionFactory);
		int idUser = userDAO.addUser(user);
		
		questionnarie.setUser(userDAO.getUser(idUser));
		
		QuestionnarieDAO questionnarieDAO = new QuestionnarieDAOImpl(sessionFactory);
		int idQuestionnarie = questionnarieDAO.addQuestionnarie(questionnarie);
		
		assertNotNull(questionnarieDAO.getQuestionnarie(idQuestionnarie));
	}
	
	@Test
	public void getQuestionnariesTest() {
		UserDAO userDAO = new UserDAOImpl(sessionFactory);
		int idUser = userDAO.addUser(user);
		
		questionnarie.setUser(userDAO.getUser(idUser));
		
		QuestionnarieDAO questionnarieDAO = new QuestionnarieDAOImpl(sessionFactory);
		questionnarieDAO.addQuestionnarie(questionnarie);
		
		questionnarie.setName("Questionário 2");
		questionnarieDAO.addQuestionnarie(questionnarie);
		
		assertTrue(questionnarieDAO.getQuestionnaries().size() > 1);
	}
}
