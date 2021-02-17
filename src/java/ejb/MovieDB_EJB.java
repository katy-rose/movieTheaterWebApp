/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Dfwtheaters;
import entity.Movies;
import entity.Showtimes;
import entity.Zipcodes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Katy Rose
 */
@Stateless
public class MovieDB_EJB {

    @PersistenceContext(unitName = "FinalProjectPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

     //Get all available zipcodes on main page
    public List<Zipcodes> findAllZipcodes() {
        return em.createNamedQuery("Zipcodes.findAll", Zipcodes.class).getResultList();
    }
    
     //Return a specific zipcode object
    public Zipcodes getZipcode(int zip) {
        return em.createNamedQuery("Zipcodes.findByZipcode", Zipcodes.class)
                .setParameter("zipcode", zip).getSingleResult();
    }
    
    //Query a list of theaters by zipcode
    public List<Dfwtheaters> getTheatersByZipcode(int zip) {
        return em.createNamedQuery("Dfwtheaters.findByZipcode", Dfwtheaters.class)
                .setParameter("zipcode", zip).getResultList();
    }
    
     //Return a specific theater object
    public Dfwtheaters getTheater(String theater) {
        return em.createNamedQuery("Dfwtheaters.findByTheaterName", Dfwtheaters.class)
                .setParameter("theaterName", theater).getSingleResult();
    }
     
    //Query a list of movies playing at a specific theater
    public List<Movies> getMoviesByTheater(Dfwtheaters theater) {
        return em.createNamedQuery("Movies.findByTheaterName", Movies.class)
                .setParameter("theaterName", theater.getTheaterName()).getResultList();
    }
    
    //Return a specific Movie object
    public Movies getMovie(String movieTitle) {
        return em.createNamedQuery("Movies.findByTitle", Movies.class)
                .setParameter("title", movieTitle).getSingleResult();
    }
    
    //Get query of showtimes for a specific movie at a specific theater
    public List<Showtimes> getMovieShowtimes(String movieTitle, String theaterName) {
        return em.createNamedQuery("Showtimes.findByTitleAndTheater", Showtimes.class)
                .setParameter("title", movieTitle).setParameter("theaterName", theaterName).getResultList();
    }
    
    //Return a specific Showtimes object
    public Showtimes getShowtime(String movieTitle, String theaterName, String movieTime){
        return em.createNamedQuery("Showtimes.findByTitleTheaterAndTime", Showtimes.class)
                .setParameter("title", movieTitle).setParameter("theaterName", theaterName).setParameter("showtime", movieTime).getSingleResult();
    }
}
