package com.example.bd.repo;

import com.example.bd.model.Raspisanie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.TreeSet;

/**
 * Репозиторий Jpa для создания CRUD-запросов для таблицы raspisanies
 *
 */
public interface RaspisanieRepo extends JpaRepository<Raspisanie, Long> {
    /**
     * Запрос для получения расписания по идентификатору пользователя
     *
     */
    Raspisanie findByTeatrIdAndId(long teatrId, long raspisanieId);
    List<Raspisanie> findAllByTeatrId(long teatrId);

    //boolean existsByUserIdAndId(long userId, long id);

    //boolean existsByTeatrIdAndId(long teatrId, long raspisanieId);
}
