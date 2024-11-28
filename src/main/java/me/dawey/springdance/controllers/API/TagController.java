package me.dawey.springdance.controllers.API;

import me.dawey.springdance.models.Tag;
import me.dawey.springdance.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Tag> getTagById(@PathVariable int id) {
        return tagService.findById(id);
    }

    @PostMapping("/create")
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @PutMapping("/{id}")
    public Tag updateTag(@PathVariable int id, @RequestBody Tag tagDetails) {
        Tag tag = tagService.findById(id).orElseThrow(() -> new RuntimeException("Tag not found"));
        tag.setNev(tagDetails.getNev());
        tag.setFerfi(tagDetails.getFerfi());
        tag.setSzulido(tagDetails.getSzulido());
        return tagService.save(tag);
    }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable int id) {
        tagService.deleteById(id);
    }
}