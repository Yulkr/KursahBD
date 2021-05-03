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

@RestController
public class TeatrController {
    @Autowired
    private TeatrRepo teatrRepo;
    @Autowired
    private RaspisanieRepo raspisanieRepo;

    private final TeatrService teatrService;

    @Autowired
    public TeatrController(TeatrService teatrService){
        this.teatrService = teatrService;
    }

/* этот пост рабочий
    @PostMapping(value = "/teatrs")
    public Teatr create(@RequestBody Teatr teatr) {
        return teatrRepo.save(teatr);
    }

 */
/* это рабочии 2 метода
    @GetMapping(value = "/teatrs")
    public ResponseEntity<List<Teatr>> read() {
        List<Teatr> teatr = teatrRepo.findAll();
        return !teatr.isEmpty()
                ? new ResponseEntity<>(teatr, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/teatrs/{id}")

    public ResponseEntity<Teatr> read(@PathVariable(name = "id") Long id) {
        Teatr teatr = teatrRepo.findById(id).orElse(null);

        return teatr != null
                ? new ResponseEntity<>(teatr, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

 */

    @PostMapping("/teatrs")
    public ResponseEntity<?> create(@RequestBody Teatr teatr){
        teatrService.create(teatr);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/teatrs")
    public ResponseEntity<List<Teatr>> findAll(){
        final List<Teatr> teatrList = teatrService.findAll();
        return teatrList != null && !teatrList.isEmpty()
                ? new ResponseEntity<>(teatrList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/teatrs/{id}")
    public ResponseEntity<Optional<Teatr>> findById(@PathVariable(name = "id") Long id){
        final Optional<Teatr> teatr = teatrService.findById(id);
        return teatr.isPresent()
                ? new ResponseEntity<>(teatr, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/teatrs/genre_{genre}")
    public ResponseEntity<List<Teatr>> findByGenre(@PathVariable(name = "genre") String genre){
        final List<Teatr> teatrList = teatrService.findByGenre(genre);
        return teatrList != null && !teatrList.isEmpty()
                ? new ResponseEntity<>(teatrList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
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
/* рабочий пут
    @PutMapping(value = "/teatrs/{id}")
    public Teatr update(@PathVariable(name = "id") Long teatrId, @RequestBody Teatr teatrReq) {
        return teatrRepo.findById(teatrId).map(
                teatr -> {
                    teatr = teatrReq;
                    return teatrRepo.save(teatr);
                }
        ).orElseThrow(() -> new ResourceNotFoundException("Person not found with id" + teatrId));
    }

 */

    @DeleteMapping(value = "/teatrs/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long teatrId) {
        return teatrRepo.findById(teatrId)
                .map(teatr -> {
                    teatrRepo.delete(teatr);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Person not found with id" + teatrId));
    }

/*
    @PostMapping("/teatrs")
    public void create(@RequestBody Teatr teatr) {
        teatrRepo.save(teatr);
        ResponseEntity.ok().build();
    }
    @PutMapping("/teatrs/{id}")
    public ResponseEntity<Teatr> update(@PathVariable long id, @RequestBody Teatr upTeatr) {
        Teatr user = teatrRepo.findById(id).orElse(null);
        if (user != null) {
            upTeatr.setId(id);
            teatrRepo.save(upTeatr);
            return new ResponseEntity<>(upTeatr, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/teatrs/{id}")
    public void delete(@PathVariable long id) {
        Teatr teatr = teatrRepo.findById(id).orElse(null);
        if (teatr != null) {
            teatrRepo.delete(teatr);
            ResponseEntity.ok().build();
        } else {
            ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/teatrs/{id}")
    public ResponseEntity<Teatr> read(@PathVariable long id) {
        Teatr teatr = teatrRepo.findById(id).orElse(null);
        return teatr != null
                ? new ResponseEntity<>(teatr, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

 */




}
