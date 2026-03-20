package com.example.phungnhattan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "educations")
@Getter
@Setter
@NoArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long profileId;
    private String degree;
    private String institution;
    private String year;

    public Education(Long profileId, String degree, String institution, String year) {
        this.profileId = profileId;
        this.degree = degree;
        this.institution = institution;
        this.year = year;
    }
}
