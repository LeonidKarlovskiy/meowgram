package com.example.entity;




import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private Long id;
    private String name;
    private String username;
    private String lastname;
    private String email;
    private String bio;
    private String password;

    private Set<ERrole> eRrole = new HashSet<>();
    private List<Post> posts = new ArrayList<>();
    private LocalDateTime createdData;


    @PrePersist
    protected void onCreate(){
        this.createdData = LocalDateTime.now();
    }



}
