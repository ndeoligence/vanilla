package org.ngam.vanilla.dao;

import org.junit.Test;
import org.ngam.vanilla.entities.Movie;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by phoenix on 9/15/16.
 */

public class VanillaDAODbImplTest {
    @Test
    public void testAddMovie() {
        Movie movie = new Movie(0,"Jaws","Steven Spielberg","Story of a great white shark!");
        VanillaDAO_dbImpl dao = new VanillaDAO_dbImpl();
        dao.addMovie(movie);
        List<Movie> movies = dao.getMovies();
        assertTrue(movies.contains(movie));
    }
}
