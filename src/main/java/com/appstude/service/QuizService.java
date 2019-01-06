package com.appstude.service;

import com.appstude.entities.Participant;
import com.appstude.entities.Question;
import com.appstude.utilis.QuestionDTO;

import java.util.List;

public interface QuizService {
	
   public Question addQuestion(Question question);
   public List<Question> getLisOfQuestion();
   
   
   public Participant addParticipant(Participant participant);
   public Participant findParticipantById(Long id);
   public List<Participant> getLisOfRoles();
   public List<QuestionDTO> getRandomQuestions();
   public List<Integer> getAnswers(List<Long> idQuestions);
   
   
}
