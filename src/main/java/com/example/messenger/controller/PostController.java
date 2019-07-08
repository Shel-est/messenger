package com.example.messenger.controller;

import com.example.messenger.domain.Post;
import com.example.messenger.domain.User;
import com.example.messenger.domain.Views;
import com.example.messenger.service.PostService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @JsonView(Views.FullPost.class)
    public Post create(
            @RequestBody Post post,
            @AuthenticationPrincipal User author
    ) {
        return postService.create(post, author);
    }
}
