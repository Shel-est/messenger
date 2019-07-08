package com.example.messenger.service;

import com.example.messenger.domain.Public;
import com.example.messenger.domain.User;
import com.example.messenger.domain.Views;
import com.example.messenger.dto.EventType;
import com.example.messenger.dto.ObjectType;
import com.example.messenger.repository.PublicRepository;
import com.example.messenger.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.function.BiConsumer;

@Service
public class PublicService {
    private final PublicRepository publicRepo;
    private final BiConsumer<EventType, Public> wsSender;

    @Autowired
    public PublicService(PublicRepository publicRepo, WsSender wsSender) {
        this.publicRepo = publicRepo;
        this.wsSender = wsSender.getSender(ObjectType.PUBLIC, Views.FullPublic.class);
    }

    public Public create(Public publicGroup, User creator) {
        publicGroup.setCreationDate(LocalDateTime.now());
        publicGroup.setCreator(creator);
        Public publicGroupFromDb = publicRepo.save(publicGroup);

        wsSender.accept(EventType.CREATE, publicGroupFromDb);

        return publicGroupFromDb;
    }
}
