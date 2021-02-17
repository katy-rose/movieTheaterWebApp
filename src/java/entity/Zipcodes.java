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

/**
 *
 * @author Katy Rose
 */
@Entity
@Table(name = "ZIPCODES")
@NamedQueries({
    @NamedQuery(name = "Zipcodes.findAll", query = "SELECT z FROM Zipcodes z"),
    @NamedQuery(name = "Zipcodes.findByZipcode", query = "SELECT z FROM Zipcodes z WHERE z.zipcode = :zipcode")})
public class Zipcodes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZIPCODE")
    private Integer zipcode;

    public Zipcodes() {
    }

    public Zipcodes(Integer zipcode) {
        this.zipcode = zipcode;
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
        hash += (zipcode != null ? zipcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zipcodes)) {
            return false;
        }
        Zipcodes other = (Zipcodes) object;
        if ((this.zipcode == null && other.zipcode != null) || (this.zipcode != null && !this.zipcode.equals(other.zipcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Zipcodes[ zipcode=" + zipcode + " ]";
    }
    
}
