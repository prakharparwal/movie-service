package com.movie.service.controller;

import com.movie.service.data.Movie;
import com.movie.service.data.MovieDTO;
import com.movie.service.data.ResponseText;
import com.movie.service.service.MovieService;
import com.movie.service.util.MovieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/home")
    String getHome() {
        return "index";
    }

    @GetMapping("/movies")
    @ResponseBody
    List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        return movies;
    }

    @RequestMapping(value = "/addMovie", method = RequestMethod.POST, headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieService.saveMovie(movie);
        return new ResponseEntity<Movie>(movie, HttpStatus.OK);
    }

    @RequestMapping(value = "/addMovieFromView", method = RequestMethod.POST)
    ResponseEntity<MovieDTO> addMovieFromView(@ModelAttribute("movieForm") Movie movie) {

        Movie savedMovie = movieService.saveMovie(movie);
        return new ResponseEntity<MovieDTO>(MovieUtil.buildMovieDTO(savedMovie), HttpStatus.OK);
    }

    @GetMapping("/addMovieForm")
    String getMovieForm(@ModelAttribute("movieForm") Movie movie)
    {
        return "addMovie";
    }


    @GetMapping("/testResponseOk")
    ResponseEntity<String> getResponseOk() {
        return ResponseEntity.ok("This is response");
    }

}
