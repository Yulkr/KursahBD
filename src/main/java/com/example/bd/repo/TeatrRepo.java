package com.example.bd.repo;

import com.example.bd.model.Teatr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeatrRepo extends JpaRepository<Teatr, Long> {
    //Teatr findByUserIdAndId(long teatrId);

    //boolean existsByUserIdAndId(long teatrId);
}
