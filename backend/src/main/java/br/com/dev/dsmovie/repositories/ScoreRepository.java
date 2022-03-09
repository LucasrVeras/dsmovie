package br.com.dev.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dev.dsmovie.model.Score;
import br.com.dev.dsmovie.model.ScorePK;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
