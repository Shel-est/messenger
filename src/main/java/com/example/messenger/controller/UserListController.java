package com.example.messenger.controller;

import com.example.messenger.domain.User;
import com.example.messenger.domain.Views;
import com.example.messenger.service.ProfileService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserListController {
    private final ProfileService profileService;

    @Autowired
    public UserListController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @GetMapping("list")
    @JsonView(Views.FullProfile.class)
    public List<User> list() {
        return profileService.getUserList();
    }
}
