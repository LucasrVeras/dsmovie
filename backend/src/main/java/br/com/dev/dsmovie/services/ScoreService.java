package br.com.dev.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dev.dsmovie.dto.MovieDto;
import br.com.dev.dsmovie.dto.ScoreDto;
import br.com.dev.dsmovie.model.Movie;
import br.com.dev.dsmovie.model.Score;
import br.com.dev.dsmovie.model.User;
import br.com.dev.dsmovie.repositories.MovieRepository;
import br.com.dev.dsmovie.repositories.ScoreRepository;
import br.com.dev.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository UserRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	
	@Transactional
	public MovieDto saveScore(ScoreDto scoreDto) {
		
		User user = UserRepository.findByEmail(scoreDto.getEmail());
		
		if (user == null) {
			user = new User();
			user.setEmail(scoreDto.getEmail());
			user = UserRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(scoreDto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for(Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDto(movie);
	}
	
	
}
