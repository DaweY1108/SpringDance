package me.dawey.springdance.repos;

import me.dawey.springdance.models.Par;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParRepository extends JpaRepository<Par, Integer> {
}