package com.zee.zee5app;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.enums.Genre;
import com.zee.zee5app.exceptions.UnabletoGenerateIdException;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.MovieServiceImpl;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.UserServiceImpl;

public class Main2 {

    public static void main(String[] args) {
        UserService userService = UserServiceImpl.getInstance();
        MovieService movieService = MovieServiceImpl.getInstance();

        User newUser = new User("rikesh", "kumar", "rikesh@gmail.com");
        newUser.setUserId(String.valueOf("987"));
        newUser.setDob(LocalDate.now());
        newUser.setDoj(LocalDate.now());
        newUser.setActive(false);
     try {
		userService.insertUser(newUser);
	} catch (UnabletoGenerateIdException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

        String[] actors = { "prabhas", "rana" };
        String[] languages = { "HINDI", "ENGLISH" };
//        Movie movie = new Movie();

//    try {
//            movie.setMovieId("12345");
//            movie.setActors(actors);
//            movie.setDirector("SSR");
//            movie.setMovieName("bahubali");
//            movie.setLanguages(languages);
//            movie.setMovieLength(10);
//            movie.setGenre(Genre.ACTION);
//            movie.setProduction("dharma");
//            
//            Movie insertedMovie = movieService.insertMovie(movie);
//            System.out.println(insertedMovie);
//            
//            
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//        Optional<Movie> movie = movieService.getMovieByMovieId("12345");
//        System.out.println(movie.get());
//        Movie movie = new Movie();
//        movie.setTrailer1("C:\\Users\\mohammed.afif\\Downloads\\Baby Driver Opening Scene (2017) _ Movieclips Coming Soon.mp4");
//        try {
//            movieService.insertMovie(movie);
//        } catch (FileNotFoundException | UnableToGenerateIdException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

}