package com.example.bd.repo;

import com.example.bd.model.Teatr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeatrRepo extends JpaRepository<Teatr, Long> {
    //Teatr findByUserIdAndId(long teatrId);

    //boolean existsByUserIdAndId(long teatrId);
    List<Teatr> findByGenre(String genre);
}
