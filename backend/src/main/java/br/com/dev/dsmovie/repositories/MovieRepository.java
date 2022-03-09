package br.com.dev.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dev.dsmovie.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
