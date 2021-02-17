/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.MovieDB_EJB;
import entity.Dfwtheaters;
import entity.Movies;
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
@Named(value = "moviesByTheaterBean")
@SessionScoped
public class MoviesByTheaterBean implements Serializable {

    @EJB
    private MovieDB_EJB movieDB_EJB;
    private Dfwtheaters selectedTheater;

        public MoviesByTheaterBean() {
    }
        
    //Set the selectedTheater in the bean to the theater chosen by user on the TheaterList.xhtml page
    //Then go to the MoviesByTheater.xhtml to show list of movies playing at the chosen theater
        public String getMoviesForTheater(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
                fc.getExternalContext().getRequestParameterMap();
        String theaterToSearch = params.get("theater");
        selectedTheater = movieDB_EJB.getTheater(theaterToSearch);
        return "MoviesByTheater";
    }
    
    //Return a list of movies playing at the chosen theater
    public List<Movies> getMovieList() {
        if (selectedTheater != null)
            return movieDB_EJB.getMoviesByTheater(selectedTheater);
        else
            return null;
    }

    public Dfwtheaters getSelectedTheater() {
        return selectedTheater;
    }

    public void setSelectedTheater(Dfwtheaters selectedTheater) {
        this.selectedTheater = selectedTheater;
    }
    
    
    
}
