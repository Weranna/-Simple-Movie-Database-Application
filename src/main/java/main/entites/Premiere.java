package main.entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Premiere.class)
@Table(name = "Premiere")
public class Premiere {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="cinema_id", referencedColumnName = "id")
    Cinema cinema;

    public Premiere() {

    }

    public Premiere(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }


}

