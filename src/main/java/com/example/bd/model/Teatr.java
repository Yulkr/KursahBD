package com.example.bd.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="teatrs")
public class Teatr implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="genre")
    private String genre;
    @Column(name="author")
    private String author;
    @Column(name="cost")
    private Integer cost;


    @OneToMany(mappedBy = "teatrs",
              fetch = FetchType.EAGER)
    public Set<Raspisanie> raspisanies;

    @ManyToMany
    @JoinTable (name="teatrs_actors",
            joinColumns=@JoinColumn (name="teatr_id"),
            inverseJoinColumns=@JoinColumn(name="actors_id"))
    private Set<Actor> actors;

    public Teatr(){

    }

    public Teatr(long id, String name, String genre, String author, Integer cost) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Teatr{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", cost=" + cost +
                '}';
    }

    public void getTeators() {
    }
    public Set<Raspisanie> getRaspisanies(){
        return raspisanies;
    }
    public void setRaspisanies(Set<Raspisanie> raspisanies){
        this.raspisanies = raspisanies;
    }

    //public List<Object> getTeators() {
    //}
}
