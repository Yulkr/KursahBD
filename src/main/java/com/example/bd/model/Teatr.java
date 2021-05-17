package com.example.bd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
/**
 * Класс модели для таблицы театра(афиши мероприятий)
 *
 */
@Entity
@Table(name="teatrs")
public class Teatr implements Serializable {
    /**
     * Первичный ключ таблицы театра
     */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    /**
     * Столбец названия
     */
    @Column(name="name")
    private String name;
    /**
     * Столбец жанра
     */
    @Column(name="genre")
    private String genre;
    /**
     * Столбец постановщика
     */
    @Column(name="author")
    private String author;
    /**
     * Столбец стоимости
     */
    @Column(name="cost")
    private Integer cost;
    /**
     * Внешний ключ таблицы театра к таблице расписания
     */
    @JsonIgnore
    @OneToMany(mappedBy = "teatr",
              fetch = FetchType.EAGER)
    public Set<Raspisanie> raspisanies;
    /**
     * Внешний ключ таблицы театра к таблице актеров
     */
    @JsonIgnore
    @ManyToMany
    @JoinTable (name="teatrs_actors",
            joinColumns=@JoinColumn (name="teatr_id"),
            inverseJoinColumns=@JoinColumn(name="actors_id"))
    private Set<Actor> actors;
    /**
     * Конструктор для модели
     */
    public Teatr(){

    }
    /**
     * Конструктор для модели
     *
     * @param id уникальный индентификатор театра(мероприятия)
     * @param name название мероприятия
     * @param genre жанр мероприятия
     * @param author постановщик мероприятия
     * @param cost стоимость мероприятия
     */
    public Teatr(long id, String name, String genre, String author, Integer cost) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.cost = cost;
    }
    /**
     * Getter для театра(мероприятия) id
     *
     * @return id
     */
    public long getId() {
        return id;
    }
    /**
     * Сеттер id мероприятия
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * Getter для названия
     *
     * @return namt
     */
    public String getName() {
        return name;
    }
    /**
     * Сеттер названия
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter для жанра
     *
     * @return genre
     */
    public String getGenre() {
        return genre;
    }
    /**
     * Сеттер жанра
     *
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    /**
     * Getter для постановщика
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Сеттер постановщика
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * Getter для стоимости
     *
     * @return cost
     */
    public Integer getCost() {
        return cost;
    }
    /**
     * Сеттер стоимости
     *
     * @param cost
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }
    /**
     * Метод отображения или возврата значений полей экземпляра класса истории
     *
     * @return string
     */
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

}
