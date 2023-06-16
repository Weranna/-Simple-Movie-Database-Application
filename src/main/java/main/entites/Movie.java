package main.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=
        Movie.class)
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    private String title;
    private String genre;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable (name = "MovieDirector", joinColumns = {
            @JoinColumn(name = "movie_id", referencedColumnName = "id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "director_id", referencedColumnName = "id")
    })

    private Set<Director> directors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (name = "MovieWriter", joinColumns = {
            @JoinColumn(name = "movie_id", referencedColumnName = "id")
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "writer_id", referencedColumnName = "id")
            })

    private Set<Writer> writers;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="premiere_id", referencedColumnName = "id")
    Premiere premiere;

    public Movie() {

    }

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public Set<Writer> getWriters() {
        return writers;
    }

    public void setWriters(Set<Writer> writers) {
        this.writers = writers;
    }

    public Premiere getPremiere() {
        return premiere;
    }

    public void setPremiere(Premiere premiere) {
        this.premiere = premiere;
    }
}

