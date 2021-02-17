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
@Table(name = "MOVIES")
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m"),
    @NamedQuery(name = "Movies.findByTitle", query = "SELECT m FROM Movies m WHERE m.title = :title"),
    @NamedQuery(name = "Movies.findByReleaseDate", query = "SELECT m FROM Movies m WHERE m.releaseDate = :releaseDate"),
    @NamedQuery(name = "Movies.findByRating", query = "SELECT m FROM Movies m WHERE m.rating = :rating"),
    @NamedQuery(name = "Movies.findByGenre", query = "SELECT m FROM Movies m WHERE m.genre = :genre"),
    @NamedQuery(name = "Movies.findByRuntime", query = "SELECT m FROM Movies m WHERE m.runtime = :runtime"),
    @NamedQuery(name = "Movies.findBySynopsis", query = "SELECT m FROM Movies m WHERE m.synopsis = :synopsis"),
    @NamedQuery(name = "Movies.findByTheaterName", query = "SELECT m FROM Movies m, Moviesbytheater t WHERE m.title = t.moviesbytheaterPK.title AND t.moviesbytheaterPK.theaterName = :theaterName")
})
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "RELEASE_DATE")
    private Integer releaseDate;
    @Size(max = 10)
    @Column(name = "RATING")
    private String rating;
    @Size(max = 100)
    @Column(name = "GENRE")
    private String genre;
    @Size(max = 30)
    @Column(name = "RUNTIME")
    private String runtime;
    @Size(max = 400)
    @Column(name = "SYNOPSIS")
    private String synopsis;

    public Movies() {
    }

    public Movies(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (title != null ? title.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        if ((this.title == null && other.title != null) || (this.title != null && !this.title.equals(other.title))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movies[ title=" + title + " ]";
    }
    
}
