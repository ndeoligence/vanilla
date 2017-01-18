package org.ngam.vanilla.dao;

import org.junit.Test;
import org.ngam.vanilla.entities.Movie;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by phoenix on 9/15/16.
 */

public class VanillaDAODbImplTest {
    @Test public void testAddMovie() {
        Movie movie = new Movie(0,"Jaws","Steven Spielberg","Story of a great white shark!");
        VanillaDAO_dbImpl dao = new VanillaDAO_dbImpl();
        // System.out.println("Adding movie : "+movie);
        dao.addMovie(movie);
        List<Movie> movies = dao.getMovies();
        
        assertTrue(movies.size() > 0);

        Movie db_mov = movies.get(movies.size()-1);
        // System.out.println("Got movie : "+db_mov);
        assertEquals(movie.getTitle(),db_mov.getTitle());
        assertEquals(movie.getDirector(),db_mov.getDirector());
        assertEquals(movie.getSynopsis(),db_mov.getSynopsis());
        //assertTrue(movies.contains(movie)); // equals won't work here because id's aren't the same!
    }
}
