package com.example.bd.repo;

import com.example.bd.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepo extends JpaRepository<Actor, Long> {
}
