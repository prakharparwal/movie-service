package com.movie.service.controller;

import com.movie.service.data.Movie;
import com.movie.service.data.MovieDTO;
import com.movie.service.data.ResponseText;
import com.movie.service.service.MovieService;
import com.movie.service.util.MovieUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;
    /*
        @Autowired
        KafkaTemplate<String, Movie> kafkaTemplate;
        */
    @Autowired
    KafkaProducer<String, Movie> kafkaProducer;

    @GetMapping("/home")
    String getHome() {
        return "index";
    }

    @GetMapping("/movies")
    @ResponseBody
    List<Movie> getAllMovies() {
        return movieService.getAllMovies();
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
    String getMovieForm(@ModelAttribute("movieForm") Movie movie) {
        return "addMovie";
    }


    @GetMapping("/testResponseOk")
    ResponseEntity<String> getResponseOk() {
        return ResponseEntity.ok("This is response");
    }


    @RequestMapping(value = "/deleteMovie/{movieId}", method = RequestMethod.DELETE)
    @ResponseBody
    String deleteMovie(@PathVariable int movieId) {
        movieService.deleteMovie(movieId);
        return "Movie got deleted";
    }

    @RequestMapping(value = "/findMovie/{movieName}", method = RequestMethod.GET)
    @ResponseBody
    Movie findMovieByName(@PathVariable String movieName) {
        return movieService.findMovieByName(movieName);
    }


    @GetMapping("/testException")
    @ResponseBody
    public String testException() {
        try {
            movieService.testException();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Testing exception";
    }


    @GetMapping("/produceKafkaEvents")
    @ResponseBody
    public String produceKafkaEvents() {


        Properties properties = new Properties();

        kafkaProducer = new KafkaProducer<String, Movie>(properties);

        kafkaProducer.send(new ProducerRecord<String, Movie>("MOVIE_DETAILS", new Movie(1, "Test", 2020)));

        return "Events have been published";
    }

}
