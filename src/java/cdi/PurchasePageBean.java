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
import java.math.BigInteger;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Katy Rose
 */
@Named(value = "purchasePageBean")
@SessionScoped
public class PurchasePageBean implements Serializable {

    @EJB
    private MovieDB_EJB movieDB_EJB;
    private Dfwtheaters selectedTheater;
    private Movies selectedMovie;
    private Showtimes selectedShowtime;
    private int numberOfTickets;
    private BigInteger creditCardNumber;
    private int billingZipcode;
    
    public PurchasePageBean() {
    }
    
    //Set selected showtime, movie, and theater in bean based on movie time chosen on MovieInfo.xhtml
    //Then go to PurchasePage.xhtml to buy tickets
    public String getPurchasePage() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = 
                fc.getExternalContext().getRequestParameterMap();
        String movieToSearch = params.get("movie");
        selectedMovie = movieDB_EJB.getMovie(movieToSearch);
        String theaterToSearch = params.get("theater");
        selectedTheater = movieDB_EJB.getTheater(theaterToSearch);
        String showTimeToSearch = params.get("showtime");
        selectedShowtime = movieDB_EJB.getShowtime(movieToSearch, theaterToSearch, showTimeToSearch);
        return "PurchasePage";        
    }
    
    //Go to confirmation page when user clicks purchase tickets on PurchasePage.xhtml
    public String confirmation() {
        return "ConfirmationPage";
    }
    
    //Return to home page
    public String returnHome() {
        return "MainPage";
    }
    
    //Calculate total cost of tickets based on number of tickets selected on PurchasePage
    public int getTotalCost() {
        return 10 * numberOfTickets;
    }

    public Dfwtheaters getSelectedTheater() {
        return selectedTheater;
    }

    public void setSelectedTheater(Dfwtheaters selectedTheater) {
        this.selectedTheater = selectedTheater;
    }

    public Movies getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(Movies selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    public Showtimes getSelectedShowtime() {
        return selectedShowtime;
    }

    public void setSelectedShowtime(Showtimes selectedShowtime) {
        this.selectedShowtime = selectedShowtime;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public BigInteger getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(BigInteger creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getBillingZipcode() {
        return billingZipcode;
    }

    public void setBillingZipcode(int billingZipcode) {
        this.billingZipcode = billingZipcode;
    }
    
    
    
}
