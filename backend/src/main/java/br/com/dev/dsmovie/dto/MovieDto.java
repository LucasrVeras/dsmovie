package br.com.dev.dsmovie.dto;

import br.com.dev.dsmovie.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDto {

	private Long id;
	private String title;
	private Double score;
	private Integer count;
	private String image;
	
	public MovieDto(Movie movie) {
		id = movie.getId();
		title = movie.getTitle();
		score = movie.getScore();
		count = movie.getCount();
		image = movie.getImage();
	}
}
