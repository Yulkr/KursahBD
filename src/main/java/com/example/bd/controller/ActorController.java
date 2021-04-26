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

@RestController
public class ActorController {
    @Autowired
    private ActorRepo actorRepo;
/*
    @PostMapping("/actors")
    //public void create(@PathVariable long id, @RequestBody Actor actor) {
    public void create(@RequestBody Actor actor) {
        actorRepo.save(actor);
        ResponseEntity.ok().build();
    }

 */


    @PostMapping(value = "/actors")
    public Actor create(@RequestBody Actor actor) {
        return actorRepo.save(actor);
    }

    @GetMapping(value = "/actors")
    public ResponseEntity<List<Actor>> read() {
        List<Actor> actor = actorRepo.findAll();
        return !actor.isEmpty()
                ? new ResponseEntity<>(actor, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/actors/{id}")
    public ResponseEntity<Actor> read(@PathVariable(name = "id") Long id) {
        Actor actor = actorRepo.findById(id).orElse(null);

        return actor != null
                ? new ResponseEntity<>(actor, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/actors/{id}")
    public Actor update(@PathVariable(name = "id") Long actorId, @RequestBody Actor actorReq) {
        return actorRepo.findById(actorId).map(
                actor -> {
                    actor = actorReq;
                    return actorRepo.save(actor);
                }
        ).orElseThrow(() -> new ResourceNotFoundException("Person not found with id" + actorId));
    }

    @DeleteMapping(value = "/actors/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long actorId) {
        return actorRepo.findById(actorId)
                .map(actor -> {
                    actorRepo.delete(actor);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Person not found with id" + actorId));
    }









}
