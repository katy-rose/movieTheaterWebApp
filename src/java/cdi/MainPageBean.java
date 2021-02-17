/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.MovieDB_EJB;
import entity.Zipcodes;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Katy Rose
 */
@Named(value = "mainPageBean")
@SessionScoped
public class MainPageBean implements Serializable {

    @EJB
    private MovieDB_EJB movieDB_EJB;

    public MainPageBean() {
    }
    
    //Get a list of all zipcodes stored in the database for the home page
     public List<Zipcodes> getAllZipcodes() {
        return movieDB_EJB.findAllZipcodes();
    }
    
}
