package org.ngam.vanilla.dao;

import org.ngam.vanilla.entities.Movie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by phoenix on 9/15/16.
 */
public class VanillaDAO_dbImpl implements VanillaDAO {
    ConnectionFactory cf;
    public VanillaDAO_dbImpl() {
        cf=new ConnectionFactory();
    }
    @Override
    public List<Movie> getMovies() {
        List<Movie> movies=null;
        String sql="select * from movies;";
        try {
            ResultSet resultSet=cf.get().prepareStatement(sql).executeQuery();
            movies=new ArrayList<>();
            Movie movie;
            while (resultSet.next()) {
                movie=new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDirector(resultSet.getString("director"));
                movie.setSynopsis(resultSet.getString("synopsis"));
                movies.add(movie);
            }
        } catch (SQLException e) {
            System.err.println("Error : "+e);
        }
        return movies;
    }

    @Override
    public boolean addMovie(Movie movie) {
        if (movie==null) return false;
        String sql = "insert into movies values (?,?,?,?);";
        try {
            PreparedStatement ps=cf.get().prepareStatement(sql);
            ps.setInt(1,0);
            ps.setString(2,movie.getTitle());
            ps.setString(3,movie.getDirector());
            ps.setString(4,movie.getSynopsis());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            System.err.println("Error : "+e);
            return false;
        }
    }
    @Override
    public boolean removeMovie(Movie movie) {
        if (movie == null || movie.getId() < 1) return false;
        String sql = "remove from movies where id=?;";
        try {
            PreparedStatement ps=cf.get().prepareStatement(sql);
            ps.setInt(1,movie.getId());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            System.err.println("Error : "+e);
            return false;
        }
    }
}















