package com.questionario.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.questionario.model.Answer;
import com.questionario.model.Option;
import com.questionario.model.Question;
import com.questionario.model.Questionnarie;
import com.questionario.model.command.AnswerCommand;
import com.questionario.model.command.QuestionnarieCommand;
import com.questionario.service.AnswerService;
import com.questionario.service.OptionService;
import com.questionario.service.QuestionService;
import com.questionario.service.QuestionnarieService;
import com.questionario.service.UserService;

/**
 * Classe que realiza o controle dos formul�rios Principal classe da aplica��o
 * Representa um controlador do Spring
 * 
 * @author Alan Arantes Souza
 * @version 1.0
 * @since 1.0
 */

@Controller
public class QuestionnarieController {
	
	/*
	 * Log
	 */
	final static Logger logger = Logger.getLogger(QuestionnarieController.class);
	
	/*
	 * Objetos de servi�o que auxiliaram no controle dos Models/DAOs
	 */
	@Autowired
	private UserService userService;

	@Autowired
	private QuestionnarieService questionnarieService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private OptionService optionService;

	@Autowired
	private AnswerService answerService;

	/**
	 * Lista todos os question�rios, tanto para usu�rios logados, quanto para
	 * usu�rios an�nimos Direciona para a p�gina de question�rios
	 * 
	 * @return ModelAndView contendo a lista de question�rios
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAllQuestionnaries() {
		logger.info("Listando question�rios...");
		ModelAndView modelAndView = new ModelAndView("list-questionnaries");

		// busca todos os question�rios e insere na view
		modelAndView.addObject("questionnaries", questionnarieService.getQuestionnaries());

		return modelAndView;
	}

	/**
	 * M�todo que direciona para a p�gna de cria��o de question�rios Apenas
	 * usu�rios logados tem acesso a esta p�gina
	 * 
	 * @param questionnarieCommand wrapper para a cria��o do question�rio
	 * @return ModelAndView direciona para a cria��o de question�rio
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createQuestionnarie(
			@ModelAttribute("questionnarieCommand") QuestionnarieCommand questionnarieCommand) {
		logger.info("Iniciando o processo de cria��o de question�rio...");
		ModelAndView modelAndView = new ModelAndView("add-quetionnarie");
		// adicona o wrapper na view
		modelAndView.addObject("questionnarieCommand", new QuestionnarieCommand());

		return modelAndView;
	}

	/**
	 * M�todo respons�vel por criar um question�rio Apenas usu�rios logados tem
	 * acesso a esta p�gina
	 * 
	 * @param questionnarieCommand wrapper para a cria��o do question�rio
	 * @return ModelAndView direciona para lista de question�rios
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addQuestionnarie(
			@ModelAttribute("questionnarieCommand") QuestionnarieCommand questionnarieCommand) {
		logger.info("Criando question�rio...");
		ModelAndView modelAndView = new ModelAndView("redirect:list");

		// recupera o question�rio wrapper
		Questionnarie questionnarie = questionnarieCommand.getQuestionnarie();
		// email do usu�rio que criou o question�rio
		String email = questionnarie.getUser().getEmail();

		// se for um usu�rio v�lido
		// busca o mesmo atrav�s do email e insere no question�rio
		if (userService.isValidUser(email)) {
			questionnarie.setUser(userService.getUserByEmail(email));
		}

		// salva o question�rio e recupera o id do mesmo
		int questionnarieID = questionnarieService.addQuestionnarie(questionnarie);
		
		logger.debug("ID do question�rio criado: " + questionnarieID);
		
		// recupera todas as perguntas
		List<Question> questionList = questionnarieCommand.getQuestion();
		if (questionList != null) {
			for (int i = 0; i < questionList.size(); i++) {
				// seta qual question�rio esta pergunta pertence
				Question question = questionList.get(i);
				question.setQuestionnarie(questionnarieService.getQuestionnarie(questionnarieID));
				// salva a pergunta e recupera o id da mesma
				int questionId = questionService.addQuestion(question);
				
				logger.debug("ID da pergunta criada: " + questionId);
				
				// recupera todas as op��es, caso tenha alguma
				List<Option> optionList = questionnarieCommand.getOption();
				if (optionList != null) {
					for (Option option : optionList) {
						// as op��es nem sempre vir�o em ordem
						// � necess�rio verificar se a op��o pertence � pergunta
						// salva anteriormente
						if (option.getQuestion().getId() == i) {
							// seta qua pergunta esta op��o pertence
							option.setQuestion(questionService.getQuestion(questionId));
							// salva a op��o
							int optionID = optionService.addOption(option);
							
							logger.debug("ID da op��o criada: " + optionID);
						}
					}
				}
			}
		} else {
			logger.error("� necess�rio ter pelo menos uma pergunta no question�rio.!!!");
			
			// se n�o foi passado nenhuma pergunta
			modelAndView.addObject("message", "� necess�rio ter pelo menos uma pergunta no question�rio.");
			return modelAndView;
		}

		modelAndView.addObject("message", "Question�rio adicionado com sucesso!");
		logger.info("Question�rio criado com sucesso!!!");

		return modelAndView;
	}

	/**
	 * M�todo respons�vel por criar um question�rio Apenas usu�rios logados tem
	 * acesso a esta p�gina
	 * 
	 * @param id id do question�rio a ser listado
	 * @return ModelAndView direciona para o question�rio referenciado no id
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public ModelAndView listQuestionnarieById(@PathVariable Integer id) {
		logger.info("Listando question�rio: " + id);
		ModelAndView modelAndView = new ModelAndView("list-questionnarie-id");

		// wrapper para enviar o question�rio para a view
		QuestionnarieCommand questionnarieCommand = new QuestionnarieCommand();

		// recupera o question�rio, as quest�es do mesmo e as op��es das
		// quest�es
		questionnarieCommand.setQuestionnarie(questionnarieService.getQuestionnarie(id));
		questionnarieCommand.setQuestion(questionService.getQuestionsByQuestionnarieId(id));

		List<Option> options = new ArrayList<Option>();

		List<Question> questionList = questionnarieCommand.getQuestion();
		if (questionList != null) {
			for (Question question : questionList) {
				options.addAll(optionService.getOptionByQuestionId(question.getId()));
			}
		}

		questionnarieCommand.setOption(options);
		// seta o wrapper na view
		modelAndView.addObject("questionnarieCommand", questionnarieCommand);

		return modelAndView;
	}

	/**
	 * M�todo respons�vel por criar um question�rio Apenas usu�rios logados tem
	 * acesso a esta p�gina
	 * 
	 * @param answerCommand wrapper que representa a resposta do question�rio
	 * @return ModelAndView direciona para lista de question�rios
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/answer", method = RequestMethod.POST)
	public ModelAndView addAnswer(@ModelAttribute("answerCommand") AnswerCommand answerCommand) {
		logger.info("Iniciando o processo de inclus�o de resposta...");
		ModelAndView modelAndView = new ModelAndView("redirect:list");

		// recupera as respostas
		List<Answer> answerList = answerCommand.getAnswers();
		if (answerList != null) {
			// recupera qualquer pergunta (uma vez que todas as perguntas
			// pertence ao mesmo question�rio)
			// para verificar qual � o question�rio que a mesma pertence
			// e assim, verificar se este email j� respondeu este question�rio
			String email = answerList.get(0).getEmail();
			int questionId = answerList.get(0).getQuestion().getId();

			if (answerService.hasAnswer(questionId, email)) {
				modelAndView.addObject("message", "Voc� n�o pode responder o mesmo question�rio mais de uma vez!");
				return modelAndView;
			}

			for (Answer answer : answerList) {
				// recupera o Id da quest�o
				questionId = answer.getQuestion().getId();
				// busca a mesma e seta no objeto de resposta
				answer.setQuestion(questionService.getQuestion(questionId));
				// salva a resposta
				answerService.addAnswer(answer);
			}
			
			logger.info("Respostas salvas com sucesso!!!");
		} else {
			logger.error("� necess�rio responster todas as perguntas!!!");
			
			// se n�o foi passado nenhuma resposta
			modelAndView.addObject("message", "� necess�rio responster todas as perguntas.");
			return modelAndView;
		}

		return modelAndView;
	}
}
