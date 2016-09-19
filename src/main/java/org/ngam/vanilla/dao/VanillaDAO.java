package org.ngam.vanilla.dao;

import org.ngam.vanilla.entities.Movie;

import java.util.List;

/**
 * Created by phoenix on 9/15/16.
 */
public interface VanillaDAO {
	Movie getMovie(int id);
    List<Movie> getMovies();
    boolean addMovie(Movie movie);
    boolean removeMovie(Movie movie);
}
