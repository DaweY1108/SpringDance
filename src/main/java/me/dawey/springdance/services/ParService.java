package me.dawey.springdance.services;

import me.dawey.springdance.models.Par;
import me.dawey.springdance.repos.ParRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParService {
    @Autowired
    private ParRepository parRepository;

    public List<Par> findAll() {
        return parRepository.findAll();
    }

    public Par save(Par par) {
        return parRepository.save(par);
    }

    public Par findById(int id) {
        return parRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        parRepository.deleteById(id);
    }

    // Other CRUD methods
}