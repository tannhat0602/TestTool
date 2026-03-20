package com.example.phungnhattan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String title;
    private String email;
    private String phone;
    private String address;
    private String github;

    @Column(columnDefinition = "TEXT")
    private String summary;

    public Profile(String fullName, String title, String email, String phone,
                   String address, String github, String summary) {
        this.fullName = fullName;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.github = github;
        this.summary = summary;
    }
}
