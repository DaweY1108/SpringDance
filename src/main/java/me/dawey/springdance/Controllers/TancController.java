package me.dawey.springdance.Controllers;

import me.dawey.springdance.Models.Tanc;
import me.dawey.springdance.Services.TancService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tanc")
public class TancController {

    @Autowired
    private TancService tancService;

    @GetMapping
    public List<Tanc> getAllTancs() {
        return tancService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Tanc> getTancById(@PathVariable int id) {
        return tancService.findById(id);
    }

    @PostMapping("/create")
    public Tanc createTanc(@RequestBody Tanc tanc) {
        return tancService.save(tanc);
    }

    @PutMapping("/{id}")
    public Tanc updateTanc(@PathVariable int id, @RequestBody Tanc tancDetails) {
        Tanc tanc = tancService.findById(id).orElseThrow(() -> new RuntimeException("Tanc not found"));
        tanc.setDatum(tancDetails.getDatum());
        tanc.setNev(tancDetails.getNev());
        return tancService.save(tanc);
    }

    @DeleteMapping("/{id}")
    public void deleteTanc(@PathVariable int id) {
        tancService.deleteById(id);
    }
}