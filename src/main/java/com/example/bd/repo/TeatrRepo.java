package com.example.bd.repo;

import com.example.bd.model.Actor;
import com.example.bd.model.Teatr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Репозиторий Jpa для создания CRUD-запросов для таблицы teatrs
 *
 */
public interface TeatrRepo extends JpaRepository<Teatr, Long> {
    //Teatr findByUserIdAndId(long teatrId);

    //boolean existsByUserIdAndId(long teatrId);
    /**
     * Запрос на получение мероприятия по жанру
     *
     * @param genre  мероприятия
     */
    List<Teatr> findByGenre(String genre);
    Teatr findTeatrById(long id);
}
