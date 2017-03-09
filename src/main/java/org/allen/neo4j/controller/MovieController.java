package org.allen.neo4j.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.allen.neo4j.domain.Movie;
import org.allen.neo4j.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping("/graph")
    public Map<String, Object> graph(@RequestParam(value = "limit", required = false) Integer limit) {
        return movieService.graph(limit == null ? 100 : limit);
    }

    @RequestMapping("/movies")
    public Collection<Movie> getMoviesByActor(@RequestParam String actor) {
        return movieService.getMovies(actor);
    }

    @RequestMapping("/movie")
    public Movie getMovieByTitle(@RequestParam String title) {
        return movieService.getMovieByTitle(title);
    }
}
