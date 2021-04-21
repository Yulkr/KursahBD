package com.example.bd.controller;

import com.example.bd.model.Actor;
import com.example.bd.repo.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActorController {
    @Autowired
    private ActorRepo actorRepo;


    @PostMapping("/actors")
    public void create(@PathVariable long id, @RequestBody Actor actor) {

    }









}
