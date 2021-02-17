/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Katy Rose
 */
@Entity
@Table(name = "DFWTHEATERS")
@NamedQueries({
    @NamedQuery(name = "Dfwtheaters.findAll", query = "SELECT d FROM Dfwtheaters d"),
    @NamedQuery(name = "Dfwtheaters.findByTheaterName", query = "SELECT d FROM Dfwtheaters d WHERE d.theaterName = :theaterName"),
    @NamedQuery(name = "Dfwtheaters.findByAddress", query = "SELECT d FROM Dfwtheaters d WHERE d.address = :address"),
    @NamedQuery(name = "Dfwtheaters.findByZipcode", query = "SELECT d FROM Dfwtheaters d WHERE d.zipcode = :zipcode")})
public class Dfwtheaters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "THEATER_NAME")
    private String theaterName;
    @Size(max = 100)
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "ZIPCODE")
    private Integer zipcode;

    public Dfwtheaters() {
    }

    public Dfwtheaters(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterName != null ? theaterName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dfwtheaters)) {
            return false;
        }
        Dfwtheaters other = (Dfwtheaters) object;
        if ((this.theaterName == null && other.theaterName != null) || (this.theaterName != null && !this.theaterName.equals(other.theaterName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Dfwtheaters[ theaterName=" + theaterName + " ]";
    }
    
}
