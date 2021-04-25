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
    @Column(name = "first_NameA")
    private String first_NameA;
    @Column(name = "last_NameA")
    private String last_NameA;
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

    public Actor(long id, String first_NameA, String last_NameA, String birthdayA) {
        this.id = id;
        this.first_NameA = first_NameA;
        this.last_NameA = last_NameA;
        this.birthdayA = birthdayA;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_NameA() {
        return first_NameA;
    }

    public void setFirst_NameA(String first_NameA) {
        this.first_NameA = first_NameA;
    }

    public String getLast_NameA() {
        return last_NameA;
    }

    public void setLast_NameA(String last_NameA) {
        this.last_NameA = last_NameA;
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
                ", first_NameA='" + first_NameA + '\'' +
                ", last_NameA='" + last_NameA + '\'' +
                ", birthdayA='" + birthdayA + '\'' +
                '}';
    }
}
