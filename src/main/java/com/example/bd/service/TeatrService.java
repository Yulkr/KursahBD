package com.example.bd.service;

import com.example.bd.model.Teatr;
import com.example.bd.repo.TeatrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeatrService {

    @Autowired
    private TeatrRepo teatrRepo;

    public void create(Teatr teatr){
        teatrRepo.save(teatr);
    }

    public void update(Teatr teatr){
        teatrRepo.save(teatr);
    }
    public List<Teatr> findAll(){
        return teatrRepo.findAll();
    }

    public Optional<Teatr> findById(Long id){
        return teatrRepo.findById(id);
    }

    public List<Teatr> findByGenre(String genre){
        return teatrRepo.findByGenre(genre);
    }


}


