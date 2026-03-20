package com.example.phungnhattan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "languages")
@Getter
@Setter
@NoArgsConstructor
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long profileId;
    private String name;
    private String level;

    public Language(Long profileId, String name, String level) {
        this.profileId = profileId;
        this.name = name;
        this.level = level;
    }
}
