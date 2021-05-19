package com.example.bd.controller;

import com.example.bd.model.Teatr;
import com.example.bd.repo.ActorRepo;
import com.example.bd.repo.RaspisanieRepo;
import com.example.bd.repo.TeatrRepo;
import com.example.bd.service.TeatrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
/**
 * Контроллер для обработки запросов театра переводов манипулирующих команд
 *
 */
@RestController
public class TeatrController {
    /**
     * Репозиторий для манипулирования данными в таблице театра
     */
    @Autowired
    private TeatrRepo teatrRepo;
    /**
     * Репозиторий для манипулирования данными в таблице расписания
     */
    @Autowired
    private RaspisanieRepo raspisanieRepo;

    private final TeatrService teatrService;
    /**
     * Конструктор для репозиториев
     *
     * @param teatrService экземпляр класса TeatrService
     */
    @Autowired
    public TeatrController(TeatrService teatrService){
        this.teatrService = teatrService;
    }
    /**
     * Способ обработки пост-запросов на получение мероприятий театра
     *
     */
    @PostMapping("/teatrs")
    public ResponseEntity<?> create(@RequestBody Teatr teatr){
        teatrService.create(teatr);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
    /**
     * Метод обработки гет-запросов на отправление мероприятий театра
     *
     */
    @GetMapping("/teatrs")
    public ResponseEntity<List<Teatr>> findAll(){
        final List<Teatr> teatrList = teatrService.findAll();
        return teatrList != null && !teatrList.isEmpty()
                ? new ResponseEntity<>(teatrList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /**
     * Метод обработки гет-запросов на отправление мероприятий театра
     *
     */
    @GetMapping("/teatrs/{id}")
    public ResponseEntity<Optional<Teatr>> findById(@PathVariable(name = "id") Long id){
        final Optional<Teatr> teatr = teatrService.findById(id);
        return teatr.isPresent()
                ? new ResponseEntity<>(teatr, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /**
     * Метод обработки гет-запросов на отправление мероприятий театра по жанру
     *
     */
    @GetMapping("/teatrs/genre_{genre}")
    public ResponseEntity<List<Teatr>> findByGenre(@PathVariable(name = "genre") String genre){
        final List<Teatr> teatrList = teatrService.findByGenre(genre);
        return teatrList != null && !teatrList.isEmpty()
                ? new ResponseEntity<>(teatrList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /**
     * Способ обработки put-запросов на обновление данных актера
     *
     */
    @PutMapping("/teatrs/{id}")
    public ResponseEntity<?> updatePlace(@PathVariable(name = "id") Long id, @RequestBody Teatr teatrUpdate) {
        return teatrService.findById(id).map(teatr -> {
            teatr.setName(teatrUpdate.getName());
            teatr.setGenre(teatrUpdate.getGenre());
            teatr.setAuthor(teatrUpdate.getAuthor());
            teatr.setCost(teatrUpdate.getCost());
            teatrService.update(teatr);
            return new ResponseEntity<>(teatr, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());

    }
    /**
     * Метод обработки delete-запросов на удаление мероприятий из таблицы teatrs
     *
     */
    @DeleteMapping(value = "/teatrs/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long teatrId) {
        return teatrRepo.findById(teatrId)
                .map(teatr -> {
                    teatrRepo.delete(teatr);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Person not found with id" + teatrId));
    }
}
