package me.dawey.springdance.repos;

import me.dawey.springdance.models.Tanc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TancRepository extends JpaRepository<Tanc, Integer> {
}