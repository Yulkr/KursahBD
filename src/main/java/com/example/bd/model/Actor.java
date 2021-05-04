package com.example.bd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
/**
 * Класс модели для таблицы актеров
 *
 */
@Entity
@Table(name = "actors")
public class Actor implements Serializable {
    /**
     * Первичный ключ таблицы актеров
     */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    /**
     * Столбец имени актера
     */
    @Column(name = "first_NameA")
    private String first_NameA;
    /**
     * Столбец фамилии актера
     */
    @Column(name = "last_NameA")
    private String last_NameA;
    /**
     * Столбец даты рождения актера
     */
    @Column(name = "birthdayA")
    private String birthdayA;

    /**
     * Внешний ключ таблицы актера к таблице мероприятия
     */
    //@JsonIgnore
    @ManyToMany
    @JoinTable (name="teatrs_actors",
            joinColumns=@JoinColumn (name="actors_id"),
            inverseJoinColumns=@JoinColumn(name="teatr_id"))
    private Set<Teatr> teatrs;
    /**
     * Конструктор для модели
     */
    public Actor(){
        super();
    }
    /**
     * Конструктор для модели
     *
     * @param id уникальный индентификатор актера
     * @param first_NameA имя акттера
     * @param last_NameA фамилия актера
     * @param birthdayA  дата рождения актера
     */
    public Actor(long id, String first_NameA, String last_NameA, String birthdayA) {
        this.id = id;
        this.first_NameA = first_NameA;
        this.last_NameA = last_NameA;
        this.birthdayA = birthdayA;
    }
    /**
     * Getter для актера
     *
     * @return id
     */
    public long getId() {
        return id;
    }
    /**
     * Сеттер для уникального индентификатора актера
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * Getter для имени актера
     *
     * @return first_NameA
     */
    public String getFirst_NameA() {
        return first_NameA;
    }
    /**
     * Сеттер для имени актера
     *
     * @param first_NameA
     */
    public void setFirst_NameA(String first_NameA) {
        this.first_NameA = first_NameA;
    }
    /**
     * Getter для фамилии актера
     *
     * @return last_NameA
     */
    public String getLast_NameA() {
        return last_NameA;
    }
    /**
     * Сеттер для фамилии актера
     *
     * @param last_NameA
     */
    public void setLast_NameA(String last_NameA) {
        this.last_NameA = last_NameA;
    }
    /**
     * Getter для даты рождения актера
     *
     * @return birthdayA
     */
    public String getBirthdayA() {
        return birthdayA;
    }
    /**
     * Сеттер для даты рождения актера
     *
     * @param birthdayA
     */
    public void setBirthdayA(String birthdayA) {
        this.birthdayA = birthdayA;
    }
    /**
     * Метод отображения или возврата значений полей экземпляра класса актера
     *
     * @return string
     */
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
