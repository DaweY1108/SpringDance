package me.dawey.springdance.Repos;

import me.dawey.springdance.Models.Tanc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TancRepository extends JpaRepository<Tanc, Integer> {
}