package com.example.phungnhattan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long profileId;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String techStack;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "project_bullets", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "bullet", columnDefinition = "TEXT")
    @OrderColumn(name = "bullet_order")
    private List<String> bullets = new ArrayList<>();

    private Integer sortOrder;

    public Project(Long profileId, String name, String techStack, Integer sortOrder) {
        this.profileId = profileId;
        this.name = name;
        this.techStack = techStack;
        this.sortOrder = sortOrder;
    }
}
