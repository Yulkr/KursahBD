package com.example.bd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="raspisanies")
public class Raspisanie implements Serializable {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    //private Set<Teatr> teatrs;
    @Column(name = "id")
    private long id;
    @Column(name = "datatime")
    private Date datatime;

    @JsonIgnore
    @ManyToOne (optional = false,
            cascade=CascadeType.ALL)
    @JoinColumn (name="teatr_id", nullable = false)
    //private Teatr teatrs;
    private Teatr teatr;
    //private Set<Teatr> teatrs;



    public Raspisanie(long id, Date datatime) {
        this.id = id;
        this.datatime = datatime;
    }

    public Raspisanie(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    @Override
    public String toString() {
        return "Raspisanie{" +
                ", id=" + id +
                ", datatime=" + datatime +
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
