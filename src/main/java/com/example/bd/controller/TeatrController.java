package com.example.bd.controller;

import com.example.bd.model.Teatr;
import com.example.bd.repo.ActorRepo;
import com.example.bd.repo.RaspisanieRepo;
import com.example.bd.repo.TeatrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class TeatrController {
    @Autowired
    private TeatrRepo teatrRepo;
    @Autowired
    private RaspisanieRepo raspisanieRepo;

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


}
