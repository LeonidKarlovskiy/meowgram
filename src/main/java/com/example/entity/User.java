package com.example.entity;


import com.example.entity.enums.ERrole;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;


@Data
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, updatable = false)
    private String username;
    @Column(nullable = false)
    private String lastname;
    @Column(unique = true)
    private String email;
    @Column(length = 200)
    private String bio;
    @Column(length = 2000)
    private String password;

    @ElementCollection(targetClass = ERrole.class)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn("user_id"))
    private Set<ERrole> eRrole = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(updatable = false)
    private LocalDateTime createdData;




    @PrePersist
    protected void onCreate() {
        this.createdData = LocalDateTime.now();
    }


}
