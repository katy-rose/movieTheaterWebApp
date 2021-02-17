/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Katy Rose
 */
@Entity
@Table(name = "MOVIESBYTHEATER")
@NamedQueries({
    @NamedQuery(name = "Moviesbytheater.findAll", query = "SELECT m FROM Moviesbytheater m"),
    @NamedQuery(name = "Moviesbytheater.findByTheaterName", query = "SELECT m FROM Moviesbytheater m WHERE m.moviesbytheaterPK.theaterName = :theaterName"),
    @NamedQuery(name = "Moviesbytheater.findByTitle", query = "SELECT m FROM Moviesbytheater m WHERE m.moviesbytheaterPK.title = :title")})
public class Moviesbytheater implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MoviesbytheaterPK moviesbytheaterPK;

    public Moviesbytheater() {
    }

    public Moviesbytheater(MoviesbytheaterPK moviesbytheaterPK) {
        this.moviesbytheaterPK = moviesbytheaterPK;
    }

    public Moviesbytheater(String theaterName, String title) {
        this.moviesbytheaterPK = new MoviesbytheaterPK(theaterName, title);
    }

    public MoviesbytheaterPK getMoviesbytheaterPK() {
        return moviesbytheaterPK;
    }

    public void setMoviesbytheaterPK(MoviesbytheaterPK moviesbytheaterPK) {
        this.moviesbytheaterPK = moviesbytheaterPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moviesbytheaterPK != null ? moviesbytheaterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moviesbytheater)) {
            return false;
        }
        Moviesbytheater other = (Moviesbytheater) object;
        if ((this.moviesbytheaterPK == null && other.moviesbytheaterPK != null) || (this.moviesbytheaterPK != null && !this.moviesbytheaterPK.equals(other.moviesbytheaterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Moviesbytheater[ moviesbytheaterPK=" + moviesbytheaterPK + " ]";
    }
    
}
