package com.appstude.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="PARTICIPANTS")
public class Participant implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long id;
	private String name;
	private String email;
	private int score;
	private int timespent;

	public Participant() {
	}

	public Participant(String name, String email, int score, int timespent) {
		this.name = name;
		this.email = email;
		this.score = score;
		this.timespent = timespent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTimespent() {
		return timespent;
	}

	public void setTimespent(int timespent) {
		this.timespent = timespent;
	}
}
