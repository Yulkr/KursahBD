package com.example.bd.repo;

import com.example.bd.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Репозиторий Jpa для создания CRUD-запросов для таблицы actors
 *
 */
public interface ActorRepo extends JpaRepository<Actor, Long> {
    Actor findActorById(long id);


}
