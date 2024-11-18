package me.dawey.springdance.Repos;


import me.dawey.springdance.Models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}