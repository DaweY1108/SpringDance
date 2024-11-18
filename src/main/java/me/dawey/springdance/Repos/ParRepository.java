package me.dawey.springdance.Repos;

import me.dawey.springdance.Models.Par;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParRepository extends JpaRepository<Par, Integer> {
}