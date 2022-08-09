package com.zee.zee5app.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UnabletoGenerateIdException;
import com.zee.zee5app.utils.DBUtils;

public class MovieRepoImpl implements MovieRepo {

	private MovieRepoImpl() {
		// TODO Auto-generated constructor stub
	}

	private List<Movie> movies = new ArrayList<>();
	private DBUtils dbUtils = DBUtils.getInstance();

	private static MovieRepo movieRepo;

	public static MovieRepo getInstance() {
		// userRepo object

		if (movieRepo == null) {
			movieRepo = new MovieRepoImpl();

		}
		return movieRepo;
	}

//	private void ksmks() {
//		Collections.sort((List<T>) movies);
//	}
//    
//    

	@Override
	public Optional<Movie> insertMovie(Movie movie) throws UnabletoGenerateIdException {
		// TODO Auto-generated method stub
//		boolean result = movies.add(movie);
//
//		if (result) {
//			return Optional.of(movie);
//		}
//
//		return Optional.empty();
//		return null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into movie_table" +
		"(movieid, actors, moviename, director, genre, productions, languages, movielength, trailer"+
				"values(?,?,?,?,?,?,?,?,?)";
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, dbUtils.idGenerator(movie.getMovieName().substring(0),movie.getMovieName().substring(1)));
			String actors = "";
			String lang = "";
			actors = String.join(",",movie.getActors());
			lang = String.join(",",movie.getLanguages());
			preparedStatement.setString(2, actors);
			preparedStatement.setString(3, movie.getMovieName());
			preparedStatement.setString(4, movie.getDirector());
			preparedStatement.setString(4,movie.getGenre().toString());
			preparedStatement.setString(6, movie.getProduction());
			preparedStatement.setString(7,lang);
			preparedStatement.setFloat(8, movie.getMovieLength());
			preparedStatement.setString(9, movie.getTrailer1());
			int res = preparedStatement.executeUpdate();
			if(res > 0)
			{
				return Optional.of(movie);
			}
			else
				return Optional.empty();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
			
	}

	@Override
	public Optional<Movie> updateMovie(String movieId, Movie movie) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> movie2 = this.getMovieByMovieId(movieId);

		if (movie2.isPresent()) {
			if (movies.remove(movie2.get())) {
				movies.add(movie);
				return Optional.of(movie);
			} else {
				throw new NoDataFoundException("NO Movie found");
			}

		}

		return Optional.empty();

//		return null;
	}

	@Override
	public Optional<Movie> getMovieByMovieId(String movieId) {
		// TODO Auto-generated method stub
		for (Movie movie : movies) {
			if (movie != null && movie.getMovieId().equals(movieId)) {
				return Optional.of(movie);
			}
		}

		return Optional.empty();

//		return null;
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
	public String deleteMovieByMovieId(String movieId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> optional = this.getMovieByMovieId(movieId);
		if (optional.isPresent()) {
			if (!movies.remove(optional.get())) {
				throw new NoDataFoundException("No movie found");
			} else {
				return "Success";
			}
		}
		return "fail";

//		return null;
	}

	@Override
	public List<Movie> FindByOrderByMovieNameDsc() {

		List<Movie> movies2 = new ArrayList<>(movies);

//		method1

		Comparator<Movie> comparator = (e1, e2) -> {
			return e2.getMovieName().compareTo(e1.getMovieName());
		};

		Collections.sort(movies2, comparator);

//		method2
//		Collections.sort(movies2, (e1,e2)->
//			e2.getMovieName().compareTo(e1.getMovieName()));

		// TODO Auto-generated method stub
		return movies2;
	}

}
