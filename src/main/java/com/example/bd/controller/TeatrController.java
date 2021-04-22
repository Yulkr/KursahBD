package com.example.bd.controller;

import com.example.bd.model.Teatr;
import com.example.bd.repo.ActorRepo;
import com.example.bd.repo.RaspisanieRepo;
import com.example.bd.repo.TeatrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeatrController {
    @Autowired
    private TeatrRepo teatrRepo;
    @Autowired
    private RaspisanieRepo raspisanieRepo;

    @PostMapping(value = "/teatrs")
    public Teatr create(@RequestBody Teatr teatr) {
        return teatrRepo.save(teatr);
    }

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

    @PutMapping(value = "/teatrs/{id}")
    public Teatr update(@PathVariable(name = "id") Long teatrId, @RequestBody Teatr teatrReq) {
        return teatrRepo.findById(teatrId).map(
                teatr -> {
                    teatr = teatrReq;
                    return teatrRepo.save(teatr);
                }
        ).orElseThrow(() -> new ResourceNotFoundException("Person not found with id" + teatrId));
    }

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
