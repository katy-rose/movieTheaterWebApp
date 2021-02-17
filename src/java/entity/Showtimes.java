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
@Table(name = "SHOWTIMES")
@NamedQueries({
    @NamedQuery(name = "Showtimes.findAll", query = "SELECT s FROM Showtimes s"),
    @NamedQuery(name = "Showtimes.findByTheaterName", query = "SELECT s FROM Showtimes s WHERE s.showtimesPK.theaterName = :theaterName"),
    @NamedQuery(name = "Showtimes.findByTitle", query = "SELECT s FROM Showtimes s WHERE s.showtimesPK.title = :title"),
    @NamedQuery(name = "Showtimes.findByShowtime", query = "SELECT s FROM Showtimes s WHERE s.showtimesPK.showtime = :showtime"),
    @NamedQuery(name = "Showtimes.findByTitleAndTheater", query = "SELECT s FROM Showtimes s WHERE s.showtimesPK.title = :title AND s.showtimesPK.theaterName = :theaterName"),
    @NamedQuery(name = "Showtimes.findByTitleTheaterAndTime", query = "SELECT s FROM Showtimes s WHERE s.showtimesPK.title = :title AND s.showtimesPK.theaterName = :theaterName AND s.showtimesPK.showtime = :showtime")
})
public class Showtimes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ShowtimesPK showtimesPK;

    public Showtimes() {
    }

    public Showtimes(ShowtimesPK showtimesPK) {
        this.showtimesPK = showtimesPK;
    }

    public Showtimes(String theaterName, String title, String showtime) {
        this.showtimesPK = new ShowtimesPK(theaterName, title, showtime);
    }

    public ShowtimesPK getShowtimesPK() {
        return showtimesPK;
    }

    public void setShowtimesPK(ShowtimesPK showtimesPK) {
        this.showtimesPK = showtimesPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (showtimesPK != null ? showtimesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Showtimes)) {
            return false;
        }
        Showtimes other = (Showtimes) object;
        if ((this.showtimesPK == null && other.showtimesPK != null) || (this.showtimesPK != null && !this.showtimesPK.equals(other.showtimesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Showtimes[ showtimesPK=" + showtimesPK + " ]";
    }
    
}
