package com.appstude.web;


import com.appstude.entities.Participant;
import com.appstude.entities.Question;
import com.appstude.service.QuizService;
import com.appstude.utilis.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin
public class QuizRestController {

	@Autowired
	private QuizService quizService;
	
	//@Secured ({"ROLE_ADMIN"})
	@GetMapping("/questions")
	public List<Question> listQuestions(){
		return quizService.getLisOfQuestion();
	}
	
	//@Secured ({"ROLE_ADMIN"})
	@PostMapping("/participants")
	public ResponseEntity<Participant>  saveParticipant(@RequestBody Participant t){
        Participant participant=null;
	    try{
            participant = quizService.addParticipant(t);
            return new ResponseEntity<Participant>(participant, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Participant>(new Participant() , HttpStatus.INTERNAL_SERVER_ERROR);
        }



	}

	//@Secured ({"ROLE_ADMIN"})
	@PutMapping("/participants")
	public void updateParticipant(@RequestBody Participant participant){
		Participant p =  quizService.findParticipantById(participant.getId());
		p.setName(participant.getName());
		p.setEmail(participant.getEmail());
		p.setScore(participant.getScore());
		p.setTimespent(participant.getTimespent());
		quizService.addParticipant(p);
	}

	@GetMapping("/randomquestions")
	public List<QuestionDTO> getRandomQuestions() {
		return quizService.getRandomQuestions();
	}

	@PostMapping("/answers")
	public ResponseEntity<List<Integer>> getRandomQuestions(@RequestBody List<Long> idQuestions) {
        List<Integer> mylist = quizService.getAnswers(idQuestions);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "list vide");
        if(mylist != null && mylist.size()>0){
            return  new ResponseEntity<List<Integer>>(mylist, HttpStatus.OK);
        }
		return  new ResponseEntity<List<Integer>>(mylist, headers,HttpStatus.NO_CONTENT);
	}

	@PostMapping("/testparam")
	public String test(@RequestBody List<Long> idQuestions) {
	    String result="";
        for (Long l:idQuestions) {
            result+=l+" , ";
        }
		return "hello body : "+result;
	}

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}
