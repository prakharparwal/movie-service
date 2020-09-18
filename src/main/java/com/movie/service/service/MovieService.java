package com.movie.service.service;

import com.movie.service.data.Movie;
import com.movie.service.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    public void deleteMovie(int movieId) {
        movieRepository.deleteById(movieId);
    }

}
