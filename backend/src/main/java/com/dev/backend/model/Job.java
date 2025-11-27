package com.dev.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String companyName;

    private String location;
    private String employmentType; // Full-time / Part-time / Contract
    private String experienceLevel; //Fresher, Mid, Senior

    private String salaryRange; //"10-15 LPA"

    @Column(columnDefinition = "TEXT")
    private String jobDescription;

    @Column(columnDefinition = "TEXT")
    private String requirements;

    private String applyLink;

    private String source; //"Linkedin","Naukri", etc.

    private LocalDate datePosted;

    @Enumerated(EnumType.STRING)
    private JobStatus status; //Active, Expired, Closed

    private Double aiScore;

    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> tags;

    private  Boolean remoteOption;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
