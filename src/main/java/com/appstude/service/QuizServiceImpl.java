package com.appstude.service;

import com.appstude.dao.ParticipantRepository;
import com.appstude.dao.QuestionRepository;
import com.appstude.entities.Participant;
import com.appstude.entities.Question;
import com.appstude.utilis.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private ParticipantRepository participantRepository;
	

	
	@Override
	public Question addQuestion(Question question) {
		question = questionRepository.save(question);
		return question;
	}

	@Override
	public List<Question> getLisOfQuestion() {
		
		return questionRepository.findAll();
	}

	@Override
	public Participant addParticipant(Participant participant) {
		return participantRepository.save(participant);
	}

	@Override
	public Participant findParticipantById(Long id) {
		return participantRepository.findById(id).get();
	}


	@Override
	public List<Participant> getLisOfRoles() {
		return participantRepository.findAll();
	}

	@Override
	public List<QuestionDTO> getRandomQuestions() {

		List<QuestionDTO> listQuestionDTO = new ArrayList<>();

		for (Question  q : questionRepository.getRandomQuestions()) {

			QuestionDTO questionDTO = new QuestionDTO();
			questionDTO.setId(q.getId());
			questionDTO.setName(q.getName());
			questionDTO.setImagename(q.getImagename());
			String[] options = {q.getOption1(), q.getOption2(),q.getOption3(),q.getOption4()};
			questionDTO.setOptions(options);
			listQuestionDTO.add(questionDTO);
		}
		return listQuestionDTO;
	}

	@Override
	public List<Integer> getAnswers(List<Long> idQuestions) {

		List<Integer> listAnsewrs = new ArrayList<>();

		for (Question question:questionRepository.findQuestionByIds(idQuestions)) {
				listAnsewrs.add(question.getAnswer());

		}
		return listAnsewrs;
	}

}
