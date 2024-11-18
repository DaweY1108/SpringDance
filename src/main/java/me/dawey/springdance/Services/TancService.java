package me.dawey.springdance.Services;

import me.dawey.springdance.Models.Tanc;
import me.dawey.springdance.Repos.TancRepository;
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

    public void deleteById(int id) {
        tancRepository.deleteById(id);
    }
}