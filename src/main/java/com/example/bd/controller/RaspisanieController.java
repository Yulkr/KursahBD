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
import java.util.Set;
@RestController
public class RaspisanieController {
    @Autowired
    private RaspisanieRepo raspisanieRepo;
    @Autowired
    private TeatrRepo teatrRepo;

    @PostMapping("teatrs/{teatrId}/raspisanies/")
    public void create(@PathVariable long teatrId,
                       @RequestBody Raspisanie raspisanie) {

        Teatr teatr = teatrRepo.findByUserIdAndId(teatrId);

        if (teatr != null) {
            Set<Teatr> teatsOfRaspisanie = raspisanie.getTeatr();
            if (teatsOfRaspisanie == null) {
                teatsOfRaspisanie = new HashSet<>();
            }
            teatsOfRaspisanie.add(teatr);
            raspisanie = raspisanieRepo.save(raspisanie);
            teatr.getRaspisanies().add(raspisanie);
        } else {
            ResponseEntity.notFound().build();
        }
    }
    @GetMapping("teatrs/{teatrId}/raspisanies/{categoryId}")
    public ResponseEntity<Raspisanie> read(@PathVariable long teatrId,
                                         @PathVariable long raspisanieId) {
        Raspisanie raspisanie = raspisanieRepo.findById(raspisanieId).orElse(null);

        if (teatrRepo.existsByUserIdAndId(teatrId) && raspisanie != null) {
            return new ResponseEntity<>(raspisanie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("teatrs/{teatrId}/raspisanies/{categoryId}")
    public ResponseEntity<Raspisanie> update(@PathVariable long teatrId,
                                           @PathVariable long raspisanieId,
                                           @RequestBody Raspisanie upRaspisanie) {
        Raspisanie raspisanie = raspisanieRepo.findById(raspisanieId).orElse(null);
        if (raspisanie != null && teatrRepo.existsByUserIdAndId(teatrId)) {
            upRaspisanie.setId(raspisanieId);
            return new ResponseEntity<>(raspisanieRepo.save(upRaspisanie), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
