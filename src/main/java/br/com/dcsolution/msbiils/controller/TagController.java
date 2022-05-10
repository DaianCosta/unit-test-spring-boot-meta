package br.com.dcsolution.msbiils.controller;

import br.com.dcsolution.msbiils.dto.TagDto;
import br.com.dcsolution.msbiils.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tag")
@RestController
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDto> get(@PathVariable("id") final Integer id) {
        return new ResponseEntity<>(tagService.findById(id), HttpStatus.OK);
    }
}
