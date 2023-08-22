package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reviewID;
	
	private String comment;
	private String rating;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "gameId")
	private BoardGame game;
	
	public Review() {
		super();
	}

	
	public Review(Integer reviewID, String comment, String rating, User user, BoardGame game) {
		super();
		this.reviewID = reviewID;
		this.comment = comment;
		this.rating = rating;
		this.user = user;
		this.game = game;
	}


	public Integer getReviewID() {
		return reviewID;
	}

	public void setReviewID(Integer reviewID) {
		this.reviewID = reviewID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public BoardGame getGame() {
//		return game;
//	}

	public void setGame(BoardGame game) {
		this.game = game;
	}

	
	
	
}
