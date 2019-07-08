package com.example.messenger.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = { "id", "name" })
public class Public implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.Id.class)
    private Long id;
    @JsonView(Views.IdName.class)
    private String name;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(Views.FullPublic.class)
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonView(Views.FullPublic.class)
    private User creator;

    @OneToMany( orphanRemoval = true, cascade = {CascadeType.ALL})
    @JsonView(Views.FullPublic.class)
    private List<Post> posts;

    @OneToMany( cascade = {CascadeType.ALL})
    @JsonView(Views.FullPublic.class)
    private List<User> subscribers;
}
