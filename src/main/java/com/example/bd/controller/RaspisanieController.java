package com.example.bd.controller;

import com.example.bd.model.Raspisanie;
import com.example.bd.model.Teatr;
import com.example.bd.repo.ActorRepo;
import com.example.bd.repo.RaspisanieRepo;
import com.example.bd.repo.TeatrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@RestController
/**
 * Контроллер для обработки запросов расписания переводов манипулирующих команд
 *
 */
public class RaspisanieController {
    /**
     * Репозиторий для манипулирования данными в таблице расписания
     */
    @Autowired
    private RaspisanieRepo raspisanieRepo;
    /**
     * Репозиторий для манипулирования данными в таблице театра
     */
    @Autowired
    private TeatrRepo teatrRepo;
    /**
     * Метод обработки пост-запросов на получение расписания мероприятий театра
     *
     */
    @PostMapping(value = "/raspisanies")
    public Raspisanie create(@RequestBody Raspisanie raspisanie) {
        return raspisanieRepo.save(raspisanie);
    }
    /**
     * Метод обработки гет-запросов на отправление расписания мероприятий
     *
     */
    @GetMapping(value = "/raspisanies")
    public ResponseEntity<List<Raspisanie>> read() {
        List<Raspisanie> raspisanie = raspisanieRepo.findAll();
        return !raspisanie.isEmpty()
                ? new ResponseEntity<>(raspisanie, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /**
     * Метод обработки гет-запросов на отправление расписания мероприятий театра по id
     *
     */
    @GetMapping(value = "/raspisanies/{teatr_id}")

    public ResponseEntity<List<Raspisanie>> read(@PathVariable(name = "teatr_id") Long id) {
        List<Raspisanie> raspisanies = raspisanieRepo.findAllByTeatrId(id);

        return raspisanies != null
                ? new ResponseEntity<>(raspisanies, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
