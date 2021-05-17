package com.example.bd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
/**
 * Класс модели для таблицы расписания
 *
 */
@Entity
@Table(name="raspisanies")
public class Raspisanie implements Serializable {
    /**
     * Первичный ключ таблицы расписание
     */
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    /**
     * Столбец data
     */
    @Column(name = "data")
    private String data;
    /**
     * Столбец time
     */
    @Column(name = "time")
    private LocalTime time;
    /**
     * Внешний ключ таблицы распиания к таблице театра
     */
    @JsonIgnore
    @ManyToOne (optional = false,
            cascade=CascadeType.ALL)
    @JoinColumn (name="teatr_id", nullable = false)
    private Teatr teatr;

    /**
     * Конструктор для модели
     *
     * @param id id расписания
     * @param data дата мероприятия
     * @param time время мероприятия
     */
    public Raspisanie(long id, String data, LocalTime time) {
        this.id = id;
        this.data = data;
        this.time = time;
    }
    /**
     * Конструктор для модели
     */
    public Raspisanie(){}
    /**
     * Getter для расписания id
     *
     * @return id
     */
    public long getId() {
        return id;
    }
    /**
     * Сеттер для id
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * Getter для даты
     *
     * @return data
     */
    public String getData() {
        return data;
    }
    /**
     * Сеттер для даты
     *
     * @param data
     */
    public void setData(String  data) {
        this.data = data;
    }
    /**
     * Getter для времени
     *
     * @return time
     */
    public LocalTime getTime() {
        return time;
    }
    /**
     * Сеттер для времения
     *
     * @param time
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }
    /**
     * Метод отображения или возврата значений полей экземпляра класса расписания
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Raspisanie{" +
                "id=" + id +
                ", data=" + data +
                ", time=" + time +
                ", teatr=" + teatr +
                '}';
    }
    public Teatr getTeatr() {
        return teatr;
    }
    public void setTeatr(Teatr teatr) {
        this.teatr = teatr;
    }

}
