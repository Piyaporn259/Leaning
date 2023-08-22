package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BoardGame")
public class BoardGame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer gameId;
	
	private String tiltle;
	private String description;
	
	@OneToMany
	@JoinColumn(name = "gameId")
	private List<Review> reviews;
	
	public BoardGame() {
		super();
	}

	public BoardGame(Integer gameId, String tiltle, String description, List<Review> reviews) {
		super();
		this.gameId = gameId;
		this.tiltle = tiltle;
		this.description = description;
		this.reviews = reviews;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getTiltle() {
		return tiltle;
	}

	public void setTiltle(String tiltle) {
		this.tiltle = tiltle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	
}
