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
 * Classe que realiza o controle dos formulários Principal classe da aplicação
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
	 * Objetos de serviço que auxiliaram no controle dos Models/DAOs
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
	 * Lista todos os questionários, tanto para usuários logados, quanto para
	 * usuários anônimos Direciona para a página de questionários
	 * 
	 * @return ModelAndView contendo a lista de questionários
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAllQuestionnaries() {
		logger.info("Listando questionários...");
		ModelAndView modelAndView = new ModelAndView("list-questionnaries");

		// busca todos os questionários e insere na view
		modelAndView.addObject("questionnaries", questionnarieService.getQuestionnaries());

		return modelAndView;
	}

	/**
	 * Método que direciona para a págna de criação de questionários Apenas
	 * usuários logados tem acesso a esta página
	 * 
	 * @param questionnarieCommand wrapper para a criação do questionário
	 * @return ModelAndView direciona para a criação de questionário
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createQuestionnarie(
			@ModelAttribute("questionnarieCommand") QuestionnarieCommand questionnarieCommand) {
		logger.info("Iniciando o processo de criação de questionário...");
		ModelAndView modelAndView = new ModelAndView("add-quetionnarie");
		// adicona o wrapper na view
		modelAndView.addObject("questionnarieCommand", new QuestionnarieCommand());

		return modelAndView;
	}

	/**
	 * Método responsável por criar um questionário Apenas usuários logados tem
	 * acesso a esta página
	 * 
	 * @param questionnarieCommand wrapper para a criação do questionário
	 * @return ModelAndView direciona para lista de questionários
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addQuestionnarie(
			@ModelAttribute("questionnarieCommand") QuestionnarieCommand questionnarieCommand) {
		logger.info("Criando questionário...");
		ModelAndView modelAndView = new ModelAndView("redirect:list");

		// recupera o questionário wrapper
		Questionnarie questionnarie = questionnarieCommand.getQuestionnarie();
		// email do usuário que criou o questionário
		String email = questionnarie.getUser().getEmail();

		// se for um usuário válido
		// busca o mesmo através do email e insere no questionário
		if (userService.isValidUser(email)) {
			questionnarie.setUser(userService.getUserByEmail(email));
		}

		// salva o questionário e recupera o id do mesmo
		int questionnarieID = questionnarieService.addQuestionnarie(questionnarie);
		
		logger.debug("ID do questionário criado: " + questionnarieID);
		
		// recupera todas as perguntas
		List<Question> questionList = questionnarieCommand.getQuestion();
		if (questionList != null) {
			for (int i = 0; i < questionList.size(); i++) {
				// seta qual questionário esta pergunta pertence
				Question question = questionList.get(i);
				question.setQuestionnarie(questionnarieService.getQuestionnarie(questionnarieID));
				// salva a pergunta e recupera o id da mesma
				int questionId = questionService.addQuestion(question);
				
				logger.debug("ID da pergunta criada: " + questionId);
				
				// recupera todas as opções, caso tenha alguma
				List<Option> optionList = questionnarieCommand.getOption();
				if (optionList != null) {
					for (Option option : optionList) {
						// as opções nem sempre virão em ordem
						// é necessário verificar se a opção pertence à pergunta
						// salva anteriormente
						if (option.getQuestion().getId() == i) {
							// seta qua pergunta esta opção pertence
							option.setQuestion(questionService.getQuestion(questionId));
							// salva a opção
							int optionID = optionService.addOption(option);
							
							logger.debug("ID da opção criada: " + optionID);
						}
					}
				}
			}
		} else {
			logger.error("É necessário ter pelo menos uma pergunta no questionário.!!!");
			
			// se não foi passado nenhuma pergunta
			modelAndView.addObject("message", "É necessário ter pelo menos uma pergunta no questionário.");
			return modelAndView;
		}

		modelAndView.addObject("message", "Questionário adicionado com sucesso!");
		logger.info("Questionário criado com sucesso!!!");

		return modelAndView;
	}

	/**
	 * Método responsável por criar um questionário Apenas usuários logados tem
	 * acesso a esta página
	 * 
	 * @param id id do questionário a ser listado
	 * @return ModelAndView direciona para o questionário referenciado no id
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public ModelAndView listQuestionnarieById(@PathVariable Integer id) {
		logger.info("Listando questionário: " + id);
		ModelAndView modelAndView = new ModelAndView("list-questionnarie-id");

		// wrapper para enviar o questionário para a view
		QuestionnarieCommand questionnarieCommand = new QuestionnarieCommand();

		// recupera o questionário, as questões do mesmo e as opções das
		// questões
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
	 * Método responsável por criar um questionário Apenas usuários logados tem
	 * acesso a esta página
	 * 
	 * @param answerCommand wrapper que representa a resposta do questionário
	 * @return ModelAndView direciona para lista de questionários
	 * @author Alan Arantes Souza
	 */
	@RequestMapping(value = "/answer", method = RequestMethod.POST)
	public ModelAndView addAnswer(@ModelAttribute("answerCommand") AnswerCommand answerCommand) {
		logger.info("Iniciando o processo de inclusão de resposta...");
		ModelAndView modelAndView = new ModelAndView("redirect:list");

		// recupera as respostas
		List<Answer> answerList = answerCommand.getAnswers();
		if (answerList != null) {
			// recupera qualquer pergunta (uma vez que todas as perguntas
			// pertence ao mesmo questionário)
			// para verificar qual é o questionário que a mesma pertence
			// e assim, verificar se este email já respondeu este questionário
			String email = answerList.get(0).getEmail();
			int questionId = answerList.get(0).getQuestion().getId();

			if (answerService.hasAnswer(questionId, email)) {
				modelAndView.addObject("message", "Você não pode responder o mesmo questionário mais de uma vez!");
				return modelAndView;
			}

			for (Answer answer : answerList) {
				// recupera o Id da questão
				questionId = answer.getQuestion().getId();
				// busca a mesma e seta no objeto de resposta
				answer.setQuestion(questionService.getQuestion(questionId));
				// salva a resposta
				answerService.addAnswer(answer);
			}
			
			logger.info("Respostas salvas com sucesso!!!");
		} else {
			logger.error("É necessário responster todas as perguntas!!!");
			
			// se não foi passado nenhuma resposta
			modelAndView.addObject("message", "É necessário responster todas as perguntas.");
			return modelAndView;
		}

		return modelAndView;
	}
}
