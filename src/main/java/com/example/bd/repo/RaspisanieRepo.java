package com.example.bd.repo;

import com.example.bd.model.Raspisanie;
import org.springframework.data.jpa.repository.JpaRepository;
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
    //boolean existsByUserIdAndId(long userId, long id);

    //boolean existsByTeatrIdAndId(long teatrId, long raspisanieId);
}
