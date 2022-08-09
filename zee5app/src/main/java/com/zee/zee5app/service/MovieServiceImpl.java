package com.zee.zee5app.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.repo.MovieRepo;
import com.zee.zee5app.repo.MovieRepoImpl;

public class MovieServiceImpl implements MovieService {

	private MovieServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	private static MovieServiceImpl movieServiceImpl;

	public static MovieServiceImpl getInstance() {
		// userRepo object

		if (movieServiceImpl == null) {
			movieServiceImpl = new MovieServiceImpl();
		}

		return movieServiceImpl;
	}

	private MovieRepo movieRepo = MovieRepoImpl.getInstance();

	@Override
	public Optional<Movie> insertMovie(Movie movie) {
		// TODO Auto-generated method stud
		//return movieRepo.insertMovie(movie);
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		File file = new File(movie.getTrailer1());
		System.out.println(file.getName());
		try {
			if(movie.getTrailer1()==null || movie.getTrailer1() == "" || !file.exists())
			{
				throw new FileNotFoundException("file does not exist");
			}
			else
			{
				bufferedInputStream = new BufferedInputStream(new FileInputStream(movie.getTrailer1()));
				bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\Zee5App\\trailer\\"+file.getName()), 2048);
				bufferedOutputStream.write(bufferedInputStream.readAllBytes());
				System.out.println("file exists");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				bufferedInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		// shift the file to zee5app trailer folder
		// provide the location to trailer field

		// then take the path and store in db --> HANDLED BY REPO.
	}

	@Override
	public Optional<Movie> updateMovie(String movieId, Movie movie) throws NoDataFoundException {
		// TODO Auto-generated method stub
		// trailer file exists or not
		return movieRepo.updateMovie(movieId, movie);
	}

	@Override
	public Optional<Movie> getMovieByMovieId(String movieId) {
		// TODO Auto-generated method stub
//		return null;
		return movieRepo.getMovieByMovieId(movieId);
	}

	@Override
	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] getAllMoviesByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] getAllMoviesByName(String movieName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMovieByMovieId(String movieId) {
		// TODO Auto-generated method stub
		return null;
	}

}
