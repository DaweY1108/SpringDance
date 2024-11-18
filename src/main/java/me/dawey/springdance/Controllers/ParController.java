package me.dawey.springdance.Controllers;
import me.dawey.springdance.Models.Par;
import me.dawey.springdance.Services.ParService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/par")
public class ParController {
    @Autowired
    private ParService parService;

    @GetMapping
    public List<Par> getAll() {
        return parService.findAll();
    }

    @PostMapping("/create")
    public Par create(@RequestBody Par par) {
        return parService.save(par);
    }

    @GetMapping("/{id}")
    public Par get(@PathVariable Long id) {

        Par p = parService.findById(id);

        return p;
    }

    // Other CRUD methods

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        parService.delete(id);
    }



}