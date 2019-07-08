package com.example.messenger.controller;

import com.example.messenger.domain.Public;
import com.example.messenger.domain.Views;
import com.example.messenger.service.PublicService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("publicGroup")
public class PublicController {
    private final PublicService publicService;

    @Autowired
    public PublicController(PublicService publicService) {
        this.publicService = publicService;
    }

    @GetMapping("{id}")
    @JsonView(Views.FullPublic.class)
    public Public get(@PathVariable("id") Public group) {
        return group;
    }
}
