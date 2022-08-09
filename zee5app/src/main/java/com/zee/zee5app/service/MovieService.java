package com.zee.zee5app.service;

import java.io.FileNotFoundException;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UnabletoGenerateIdException;

public interface MovieService {
	public Optional<Movie> insertMovie(Movie movie) throws UnabletoGenerateIdException;
    public Optional<Movie> updateMovie(String movieId, Movie movie) throws NoDataFoundException;

    public Optional<Movie> getMovieByMovieId(String movieId);
    public Movie[] getAllMovies();
    public Movie[] getAllMoviesByGenre(String genre);
    public Movie[] getAllMoviesByName(String movieName);
    public String deleteMovieByMovieId(String movieId);

}
