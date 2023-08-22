package com.example.demo.Controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.BoardGameRepository;
import com.example.demo.model.BoardGame;


@RestController
public class BoardGameController {

	@Autowired
	BoardGameRepository boardGameRepository;

	@PostMapping("/board")
	public ResponseEntity<Object> addBoardGame(@RequestBody BoardGame body) {
		try {

			BoardGame newboardGame = boardGameRepository.save(body);

			return new ResponseEntity<>(newboardGame, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<>("Internal server error ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/board")
	public ResponseEntity<Object> getBordGame() {

		try {

			List<BoardGame> boardGames = boardGameRepository.findAll();
			return new ResponseEntity<>(boardGames, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>("Integer server  error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/board/{gameId}")
	public ResponseEntity<Object> getBordGameById(@PathVariable("gameId") Integer gameId) {

		try {

			
			Optional<BoardGame> foundboardGame = boardGameRepository.findById(gameId);
			{
				if (foundboardGame.isPresent()) {

					BoardGame boardGame = foundboardGame.get();
					
					return new ResponseEntity<>(boardGame, HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Board Game Not Found.", HttpStatus.BAD_REQUEST);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Integer server  error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@DeleteMapping("/board/{gameId}")
	public ResponseEntity<Object> deleteboardGame(@PathVariable Integer gameId) {
		try {
			Optional<BoardGame> foundboardGame = boardGameRepository.findById(gameId);
			if (foundboardGame.isPresent()) {
				
				BoardGame boardGame = foundboardGame.get();				
				boardGameRepository.delete(boardGame);

				return new ResponseEntity<>("DELETE SUCSESS", HttpStatus.OK);

			} else {
				return new ResponseEntity<>("EMPLOYEE not found", HttpStatus.OK);
			}
		} catch (Exception e) {
		
		}
		return new ResponseEntity<>("Internal server error", HttpStatus.OK);
	}

}
