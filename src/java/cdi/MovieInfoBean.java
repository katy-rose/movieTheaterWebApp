/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.MovieDB_EJB;
import entity.Dfwtheaters;
import entity.Movies;
import entity.Showtimes;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Katy Rose
 */
@Named(value = "movieInfoBean")
@SessionScoped
public class MovieInfoBean implements Serializable {

    @EJB
    private MovieDB_EJB movieDB_EJB;
    private Movies selectedMovie;
    private Dfwtheaters selectedTheater;
    
    public MovieInfoBean() {
    }
    
    //Set the selectedMovie & selectedTheater in the bean to the movie/theater combo chosen on the MoviesByTheater.xhtml page
    //Then go to MovieInfo.xhtml to show movie information and showtimes
    public String getMovieInformation() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
                fc.getExternalContext().getRequestParameterMap();
        String movieToSearch = params.get("movie");
        selectedMovie = movieDB_EJB.getMovie(movieToSearch);
        String theaterToSearch = params.get("theater");
        selectedTheater = movieDB_EJB.getTheater(theaterToSearch);
        return "MovieInfo";
    }
    
    //Return a list of showtimes for a specific movie at a specific theater
    public List<Showtimes> getMovieShowtimes() {
        if (selectedMovie != null)
            return movieDB_EJB.getMovieShowtimes(selectedMovie.getTitle(), selectedTheater.getTheaterName());
        else
            return null;
                
    }

    public Movies getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(Movies selectedMovie) {
        this.selectedMovie = selectedMovie;
    }
    
   
    
}
