package com.example.phungnhattan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "skills")
@Getter
@Setter
@NoArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long profileId;
    private String category;
    private String name;
    private Integer sortOrder;

    public Skill(Long profileId, String category, String name, Integer sortOrder) {
        this.profileId = profileId;
        this.category = category;
        this.name = name;
        this.sortOrder = sortOrder;
    }
}
