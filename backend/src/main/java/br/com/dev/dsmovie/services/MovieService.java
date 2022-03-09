package br.com.dev.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dev.dsmovie.dto.MovieDto;
import br.com.dev.dsmovie.model.Movie;
import br.com.dev.dsmovie.repositories.MovieRepository;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	/* 
	 *	Returns a paginated list of movies  
	 */
	@Transactional(readOnly = true)
	public Page<MovieDto> findAll(Pageable pageable){
		Page<Movie> result = movieRepository.findAll(pageable);
		Page<MovieDto> page = result.map(x -> new MovieDto(x));
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDto findById(Long id) {
		Movie result = movieRepository.findById(id).get();
		MovieDto dto = new MovieDto(result);
		return dto;
	}
}
