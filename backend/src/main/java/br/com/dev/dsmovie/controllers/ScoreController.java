package br.com.dev.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.dsmovie.dto.MovieDto;
import br.com.dev.dsmovie.dto.ScoreDto;
import br.com.dev.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@PutMapping
	public MovieDto saveScore(@RequestBody ScoreDto scoreDto) {
		
		MovieDto movieDto = scoreService.saveScore(scoreDto);
		return movieDto;
	}
}
