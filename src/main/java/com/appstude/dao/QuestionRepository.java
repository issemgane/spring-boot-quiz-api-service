package com.appstude.dao;

import com.appstude.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface QuestionRepository extends JpaRepository<Question, Long> {

	@Query(value = "SELECT * FROM questions ORDER BY RAND() LIMIT 10", nativeQuery = true)
	public List<Question> getRandomQuestions();

	@Query(value = "SELECT * FROM questions WHERE id in :ids ORDER BY FIELD(id, :ids)", nativeQuery = true)
	List<Question> findQuestionByIds(@Param("ids") List<Long> types);



}
