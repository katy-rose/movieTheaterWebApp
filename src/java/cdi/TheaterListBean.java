/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.MovieDB_EJB;
import entity.Dfwtheaters;
import entity.Zipcodes;
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
@Named(value = "theaterListBean")
@SessionScoped
public class TheaterListBean implements Serializable {

    @EJB
    private MovieDB_EJB movieDB_EJB;
    Zipcodes selectedZip;
    
    public TheaterListBean() {
    }
    
    //Set the selectedZip in the bean based on the zipcode chosen on MainPage.xhtml- page that lists the zipcodes to choose from
    //Then go to TheaterList.xhtml to show list of theaters for that zipcode
      public String getTheaters(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
                fc.getExternalContext().getRequestParameterMap();
        int zipToSearch = Integer.parseInt(params.get("zip"));
        selectedZip = movieDB_EJB.getZipcode(zipToSearch);
        return "TheaterList";
    }
  
    //Return a list of theaters for a specific chosen zipcode
    public List<Dfwtheaters> getTheaterList() {
        if (selectedZip != null)
            return movieDB_EJB.getTheatersByZipcode(selectedZip.getZipcode());
        else
            return null;
    }
    
    
}
