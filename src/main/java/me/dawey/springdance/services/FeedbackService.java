package me.dawey.springdance.services;

import me.dawey.springdance.models.Feedback;
import me.dawey.springdance.repos.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired private FeedbackRepository feedbackRepository;

    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    public Feedback save(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback findById(int id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        feedbackRepository.deleteById(id);
    }
}