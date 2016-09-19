package org.ngam.vanilla.dao;

import org.ngam.vanilla.entities.Movie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.testing.ServiceRegistryBuilder;

/**
 * Created by phoenix on 9/15/16.
 */
public class VanillaDAO_dbImpl implements VanillaDAO {
    private SessionFactory sessionFactory = null;

    /*
     * Creating a SessionFactory using version 4.2 of Hibernate
     */
    public VanillaDAO_dbImpl() {
        Configuration config = new Configuration().configure();
        // build a Registry with configuration properties
        ServiceRegistry serviceReg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildRegistry();
        // create session factory
        sessionFactory = config.buildSessionFactory(serviceReg);
    }
    @Override
    public List<Movie> getMovies() {
        Session session = sessionFactory.getCurrentSession();
        List<Movie> movies = session.createQuery("from Movie").list();
        session.getTransaction().commit();
        return movies;
    }

    @Override
    public Movie getMovie(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Movie movie = (Movie) session.load(Movie.class, id);

        session.getTransaction().commit();
        return movie;
    }

    @Override
    public boolean addMovie(Movie movie) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(movie);
        session.getTransaction().commit();
        return true;
    }
    @Override
    public boolean removeMovie(Movie movie) {
        return false;
    }
}

