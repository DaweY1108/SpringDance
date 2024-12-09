package me.dawey.springdance.controllers;

import me.dawey.springdance.models.Par;
import me.dawey.springdance.models.Tag;
import me.dawey.springdance.models.Tanc;
import me.dawey.springdance.services.ParService;
import me.dawey.springdance.services.TagService;
import me.dawey.springdance.services.TancService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private ParService parService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TancService tancService;

    // ---------- Par Endpoints ----------

    @GetMapping("/par")
    public List<Par> getAllPairs() {
        return parService.findAll();
    }

    @GetMapping("/par/{id}")
    public ResponseEntity<Par> getPairById(@PathVariable int id) {
        Par pair = parService.findById(id);
        return pair != null ? ResponseEntity.ok(pair) : ResponseEntity.notFound().build();
    }

    @PostMapping("/par")
    public ResponseEntity<Par> addPair(
            @RequestParam("tanc") int tancId,
            @RequestParam("ferfiId") int ferfiId,
            @RequestParam("noId") int noId) {

        Tanc tanc = tancService.findById(tancId).orElseThrow(() -> new RuntimeException("Tanc not found"));
        Tag ferfi = tagService.findById(ferfiId).orElseThrow(() -> new RuntimeException("Ferfi not found"));
        Tag no = tagService.findById(noId).orElseThrow(() -> new RuntimeException("No not found"));

        Par par = new Par();
        par.setTanc(tanc);
        par.setFerfi(ferfi);
        par.setNo(no);

        return ResponseEntity.ok(parService.save(par));
    }

    @PutMapping("/par/{id}")
    public ResponseEntity<Par> editPair(
            @PathVariable int id,
            @RequestParam("tanc") int tancId,
            @RequestParam("ferfiId") int ferfiId,
            @RequestParam("noId") int noId) {

        Par existingPar = parService.findById(id);
        if (existingPar == null) {
            return ResponseEntity.notFound().build();
        }
        Tanc tanc = tancService.findById(tancId).orElseThrow(() -> new RuntimeException("Tanc not found"));
        Tag ferfi = tagService.findById(ferfiId).orElseThrow(() -> new RuntimeException("Ferfi not found"));
        Tag no = tagService.findById(noId).orElseThrow(() -> new RuntimeException("No not found"));

        existingPar.setTanc(tanc);
        existingPar.setFerfi(ferfi);
        existingPar.setNo(no);

        return ResponseEntity.ok(parService.save(existingPar));
    }

    @DeleteMapping("/par/{id}")
    public ResponseEntity<Void> deletePair(@PathVariable int id) {
        parService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ---------- Tanc Endpoints ----------

    @GetMapping("/tanc")
    public List<Tanc> getAllDances() {
        return tancService.findAll();
    }

    @PostMapping("/tanc")
    public ResponseEntity<Tanc> addDance(
            @RequestParam("nev") String nev,
            @RequestParam("datum") String datum) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = formatter.parse(datum);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        Tanc tanc = new Tanc();
        tanc.setNev(nev);
        tanc.setDatum(date);
        return ResponseEntity.ok(tancService.save(tanc));
    }

    @PutMapping("/tanc/{id}")
    public ResponseEntity<Tanc> editDance(
            @PathVariable int id,
            @RequestParam("nev") String nev,
            @RequestParam("datum") String datum) {

        Tanc existingTanc = tancService.findById(id).orElseThrow(() -> new RuntimeException("Tanc not found"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = formatter.parse(datum);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        existingTanc.setNev(nev);
        existingTanc.setDatum(date);
        return ResponseEntity.ok(tancService.save(existingTanc));
    }

    @DeleteMapping("/tanc/{id}")
    public ResponseEntity<Void> deleteDance(@PathVariable int id) {
        tancService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ---------- Tag Endpoints ----------

    @GetMapping("/tag")
    public List<Tag> getAllTags() {
        return tagService.findAll();
    }

    @PostMapping("/tag")
    public ResponseEntity<Tag> addTag(
            @RequestParam("nev") String nev,
            @RequestParam("ferfi") boolean ferfi,
            @RequestParam("szulido") String szulido) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = formatter.parse(szulido);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        Tag tag = new Tag();
        tag.setNev(nev);
        tag.setFerfi(ferfi ? 1 : 0);
        tag.setSzulido(date);

        return ResponseEntity.ok(tagService.save(tag));
    }

    @PutMapping("/tag/{id}")
    public ResponseEntity<Tag> editTag(
            @PathVariable int id,
            @RequestParam("nev") String nev,
            @RequestParam("ferfi") boolean ferfi,
            @RequestParam("szulido") String szulido) {

        Tag existingTag = tagService.findById(id).orElseThrow(() -> new RuntimeException("Tag not found"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = formatter.parse(szulido);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        existingTag.setNev(nev);
        existingTag.setFerfi(ferfi ? 1 : 0);
        existingTag.setSzulido(date);

        return ResponseEntity.ok(tagService.save(existingTag));
    }

    @DeleteMapping("/tag/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable int id) {
        tagService.delete(id);
        return ResponseEntity.noContent().build();
    }
}