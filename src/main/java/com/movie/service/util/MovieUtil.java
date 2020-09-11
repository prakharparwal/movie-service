package com.movie.service.util;

import com.movie.service.data.Movie;
import com.movie.service.data.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieUtil {

    public static MovieDTO buildMovieDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName(movie.getName());
        movieDTO.setReleaseYear(movie.getReleaseYear());

        return movieDTO;
    }

}
