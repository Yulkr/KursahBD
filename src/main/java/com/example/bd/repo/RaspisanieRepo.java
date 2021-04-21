package com.example.bd.repo;

import com.example.bd.model.Raspisanie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaspisanieRepo extends JpaRepository<Raspisanie, Long> {
    Raspisanie findByTeatrIdAndId(long teatrId, long raspisanieId);
    //boolean existsByUserIdAndId(long userId, long id);

    //boolean existsByTeatrIdAndId(long teatrId, long raspisanieId);
}
