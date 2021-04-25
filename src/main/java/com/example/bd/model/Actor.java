package com.example.bd.model;

import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "actors")
public class Actor implements Serializable {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "first_nameA")
    private String first_nameA;
    @Column(name = "last_nameA")
    private String last_nameA;
    @Column(name = "birthdayA")
    private String birthdayA;

    @ManyToMany
    @JoinTable (name="teatrs_actors",
            joinColumns=@JoinColumn (name="actors_id"),
            inverseJoinColumns=@JoinColumn(name="teatr_id"))
    private Set<Teatr> teatrs;

    public Actor(){
        super();
    }

    public Actor(long id, String first_nameA, String last_NameA, String birthdayA) {
        this.id = id;
        this.first_nameA = first_nameA;
        this.last_nameA = last_NameA;
        this.birthdayA = birthdayA;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_nameA() {
        return first_nameA;
    }

    public void setFirst_nameA(String first_nameA) {
        this.first_nameA = first_nameA;
    }

    public String getLast_nameA() {
        return last_nameA;
    }

    public void setLast_nameA(String last_nameA) {
        this.last_nameA = last_nameA;
    }

    public String getBirthdayA() {
        return birthdayA;
    }

    public void setBirthdayA(String birthdayA) {
        this.birthdayA = birthdayA;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", first_nameA='" + first_nameA + '\'' +
                ", last_nameA='" + last_nameA + '\'' +
                ", birthdayA='" + birthdayA + '\'' +
                '}';
    }
}
