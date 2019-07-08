package com.example.messenger.service;

import com.example.messenger.domain.Post;
import com.example.messenger.domain.User;
import com.example.messenger.domain.Views;
import com.example.messenger.dto.EventType;
import com.example.messenger.dto.ObjectType;
import com.example.messenger.repository.PostRepository;
import com.example.messenger.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Service
public class PostService {
    private final PostRepository postRepo;
    private final BiConsumer<EventType, Post> wsSender;

    @Autowired
    public PostService(PostRepository postRepo, WsSender wsSender) {
        this.postRepo = postRepo;
        this.wsSender = wsSender.getSender(ObjectType.POST, Views.FullComment.class);
    }

    public Post create(Post post, User author) {
        post.setAuthor(author);
        Post postFromDb = postRepo.save(post);

        wsSender.accept(EventType.CREATE, postFromDb);

        return postFromDb;
    }
}
