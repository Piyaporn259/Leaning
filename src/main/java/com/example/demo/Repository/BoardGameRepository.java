package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BoardGame;


public interface BoardGameRepository extends JpaRepository<BoardGame, Integer> {

}

