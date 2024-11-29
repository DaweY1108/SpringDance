package me.dawey.springdance.controllers;

import me.dawey.springdance.models.Par;
import me.dawey.springdance.models.Tag;
import me.dawey.springdance.models.Tanc;
import me.dawey.springdance.services.ParService;
import me.dawey.springdance.services.TagService;
import me.dawey.springdance.services.TancService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class DancetableController {

    @Autowired
    private ParService parService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TancService tancService;

    @GetMapping("/dancetable")
    public String dancetable(Model model) {
        List<Par> pairs = parService.findAll();
        Collections.sort(pairs, (a, b) -> a.getId() - b.getId());
        List<Tag> tags = tagService.findAll();
        List<Tanc> tancs = tancService.findAll();
        List<Tag> ferfiTags = tags.stream().filter(tag -> tag.getFerfi() == 1).toList();
        List<Tag> noTags = tags.stream().filter(tag -> tag.getFerfi() == 0).toList();
        model.addAttribute("pairs", pairs);
        model.addAttribute("tags", tags);
        model.addAttribute("dances", tancs);
        model.addAttribute("ferfiTags", ferfiTags);
        model.addAttribute("noTags", noTags);
        return "dancetable";
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/pairs/add")
    public String addPair(
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

        parService.save(par);
        return "redirect:/dancetable";
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/pairs/edit")
    public String editPair(
            @RequestParam("id") int pairId,
            @RequestParam("tanc") int tancId,
            @RequestParam("ferfiId") int ferfiId,
            @RequestParam("noId") int noId) {

        Par existingPar = parService.findById(pairId);
        if (existingPar == null) {
            throw new RuntimeException("Pair not found");
        }
        Tanc tanc = tancService.findById(tancId).orElseThrow(() -> new RuntimeException("Tanc not found"));
        Tag ferfi = tagService.findById(ferfiId).orElseThrow(() -> new RuntimeException("Ferfi not found"));
        Tag no = tagService.findById(noId).orElseThrow(() -> new RuntimeException("No not found"));

        existingPar.setTanc(tanc);
        existingPar.setFerfi(ferfi);
        existingPar.setNo(no);

        parService.save(existingPar);
        return "redirect:/dancetable";
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/pairs/delete/{id}")
    public String deletePair(@PathVariable int id) {
        parService.delete(id);
        return "redirect:/dancetable";
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/dances/add")
    public String addDance(
            @RequestParam("nev") String nev,
            @RequestParam("datum") String datum) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = formatter.parse(datum);
        } catch (Exception e) {
            System.out.println(e);
        }
        Tanc tanc = new Tanc();
        tanc.setNev(nev);
        tanc.setDatum(date);
        tancService.save(tanc);
        return "redirect:/dancetable";
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/dances/edit")
    public String editDance(
            @RequestParam("id") int danceId,
            @RequestParam("nev") String nev,
            @RequestParam("datum") String datum) {

        Tanc existingTanc = tancService.findById(danceId).orElseThrow(() -> new RuntimeException("Tanc not found"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = formatter.parse(datum);
        } catch (Exception e) {
            System.out.println(e);
        }
        existingTanc.setNev(nev);
        existingTanc.setDatum(date);
        tancService.save(existingTanc);
        return "redirect:/dancetable";
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/dances/delete/{id}")
    public String deleteDance(@PathVariable int id) {
        List<Par> pairs = parService.findAll();
        for (Par pair : pairs) {
            if (pair.getTanc().getId() == id) {
                parService.delete(pair.getId());
            }
        }
        tancService.delete(id);
        return "redirect:/dancetable";
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/tags/add")
    public String addTag(
            @RequestParam("nev") String nev,
            @RequestParam("ferfi") boolean ferfi,
            @RequestParam("szulido") String szulido) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = formatter.parse(szulido);
        } catch (Exception e) {
            System.out.println(e);
        }

        double isFerfi = ferfi ? 1 : 0;

        Tag tag = new Tag();
        tag.setNev(nev);
        tag.setFerfi(isFerfi);
        tag.setSzulido(date);
        tagService.save(tag);

        return "redirect:/dancetable";
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/tags/edit")
    public String editTag(
            @RequestParam("id") int tagId,
            @RequestParam("nev") String nev,
            @RequestParam("ferfi") boolean ferfi,
            @RequestParam("szulido") String szulido) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = formatter.parse(szulido);
        } catch (Exception e) {
            System.out.println(e);
        }

        double isFerfi = ferfi ? 1 : 0;

        Tag existingTag = tagService.findById(tagId).orElseThrow(() -> new RuntimeException("Tag not found"));
        existingTag.setNev(nev);
        existingTag.setFerfi(isFerfi);
        existingTag.setSzulido(date);
        tagService.save(existingTag);

        return "redirect:/dancetable";
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/tags/delete/{id}")
    public String deleteTag(@PathVariable int id) {
        List<Par> pairs = parService.findAll();
        for (Par pair : pairs) {
            if (pair.getFerfi().getId() == id || pair.getNo().getId() == id) {
                parService.delete(pair.getId());
            }
        }
        tagService.delete(id);
        return "redirect:/dancetable";
    }
}