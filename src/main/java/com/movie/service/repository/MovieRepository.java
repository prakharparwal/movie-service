package com.movie.service.repository;

import com.movie.service.data.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

    Movie findByName(String movieName);
}
