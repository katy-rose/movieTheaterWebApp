/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Katy Rose
 */
@Embeddable
public class ShowtimesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "THEATER_NAME")
    private String theaterName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SHOWTIME")
    private String showtime;

    public ShowtimesPK() {
    }

    public ShowtimesPK(String theaterName, String title, String showtime) {
        this.theaterName = theaterName;
        this.title = title;
        this.showtime = showtime;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterName != null ? theaterName.hashCode() : 0);
        hash += (title != null ? title.hashCode() : 0);
        hash += (showtime != null ? showtime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShowtimesPK)) {
            return false;
        }
        ShowtimesPK other = (ShowtimesPK) object;
        if ((this.theaterName == null && other.theaterName != null) || (this.theaterName != null && !this.theaterName.equals(other.theaterName))) {
            return false;
        }
        if ((this.title == null && other.title != null) || (this.title != null && !this.title.equals(other.title))) {
            return false;
        }
        if ((this.showtime == null && other.showtime != null) || (this.showtime != null && !this.showtime.equals(other.showtime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ShowtimesPK[ theaterName=" + theaterName + ", title=" + title + ", showtime=" + showtime + " ]";
    }
    
}
