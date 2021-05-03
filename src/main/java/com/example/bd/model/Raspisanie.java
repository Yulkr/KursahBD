package com.example.bd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity

@Table(name="raspisanies")
public class Raspisanie implements Serializable {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    //private Set<Teatr> teatrs;
    @Column(name = "id")
    private long id;
    @Column(name = "data")
    private String data;
    @Column(name = "time")
    private LocalTime time;

    @JsonIgnore
    @ManyToOne (optional = false,
            cascade=CascadeType.ALL)
    @JoinColumn (name="teatr_id", nullable = false)
    //private Teatr teatrs;
    private Teatr teatr;
    //private Set<Teatr> teatrs;



    public Raspisanie(long id, String data, LocalTime time) {
        this.id = id;
        this.data = data;
        this.time = time;
    }

    public Raspisanie(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String  data) {
        this.data = data;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Raspisanie{" +
                "id=" + id +
                ", data=" + data +
                ", time=" + time +
                ", teatr=" + teatr +
                '}';
    }
    /*
    public Set<Teatr> getTeatr() {
        return teatrs;
    }

 */

    public Teatr getTeatr() {
        return teatr;
    }



    public void setTeatr(Teatr teatr) {
        this.teatr = teatr;
    }


/*
    private void setTeatrs(Set<Teatr> teatrs){
        this.teatrs = teatrs;
    }

 */
}
