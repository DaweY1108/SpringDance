package me.dawey.springdance.repos;

import me.dawey.springdance.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}