package com.dev.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String industry;

    private String location;

    private String website;

    private String careerWebsite;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer employeeCount;

    private Double rating;
}
