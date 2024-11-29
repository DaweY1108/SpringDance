package me.dawey.springdance.services;

import me.dawey.springdance.models.Tanc;
import me.dawey.springdance.repos.TancRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TancService {

    @Autowired
    private TancRepository tancRepository;

    public List<Tanc> findAll() {
        return tancRepository.findAll();
    }

    public Optional<Tanc> findById(int id) {
        return tancRepository.findById(id);
    }

    public Tanc save(Tanc tanc) {
        return tancRepository.save(tanc);
    }

    public void delete(int id) {
        tancRepository.deleteById(id);
    }
}