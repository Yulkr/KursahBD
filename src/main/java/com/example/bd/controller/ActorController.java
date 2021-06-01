package com.example.bd.controller;

import com.example.bd.model.Actor;
import com.example.bd.model.Teatr;
import com.example.bd.repo.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Контроллер для обработки запросов актеров переводов манипулирующих команд
 *
 */
@RestController
public class ActorController {
    /**
     * Хранилище для манипулирования данными в таблице актеров
     */
    @Autowired
    private ActorRepo actorRepo;
    /**
     * Конструктор для репозиториев
     *
     * @param actorRepo экземпляр класса ActorRepo
     */
    public ActorController(ActorRepo actorRepo) { this.actorRepo = actorRepo; }
    /**
     * Метод обработки пост-запросов на получение актеров театра
     *
     */
    @PostMapping(value = "/actors")
    public Actor create(@RequestBody Actor actor) {
        return actorRepo.save(actor);
    }
    /**
     * Метод обработки гет-запросов на отправление актеров театра
     *
     */
    @GetMapping(value = "/actors")
    public ResponseEntity<List<Actor>> read() {
        List<Actor> actor = actorRepo.findAll();
        return !actor.isEmpty()
                ? new ResponseEntity<>(actor, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /**
     * Метод обработки гет-запросов на отправление актеров театра и id
     *
     */
    @GetMapping(value = "/actors/{id}")
    public ResponseEntity<Actor> read(@PathVariable(name = "id") Long id) {
        Actor actor = actorRepo.findById(id).orElse(null);

        return actor != null
                ? new ResponseEntity<>(actor, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /**
     * Способ обработки put-запросов на обновление данных актера
     *
     */
    @PutMapping(value = "/actors/{id}")
    public Actor update(@PathVariable(name = "id") Long actorId, @RequestBody Actor actorReq) {
        return actorRepo.findById(actorId).map(
                actor -> {
                    actor = actorReq;
                    return actorRepo.save(actor);
                }
        ).orElseThrow(() -> new ResourceNotFoundException("Person not found with id" + actorId));
    }
    /**
     * Метод обработки delete-запросов на удаление актеров из таблицы актеров
     *
     */
    @DeleteMapping(value = "/actors/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long actorId) {
        return actorRepo.findById(actorId)
                .map(actor -> {
                    actorRepo.delete(actor);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Person not found with id" + actorId));
    }

}
