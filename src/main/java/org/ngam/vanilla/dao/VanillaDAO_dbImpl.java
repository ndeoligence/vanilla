package org.ngam.vanilla.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.ngam.vanilla.entities.Movie;

import java.util.List;

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
        // Build a registry with our config properties
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        // create the session factory
        sessionFactory = config.buildSessionFactory(registry);
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

