package com.dev.backend.dto.job;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public class JobDTOs {

    @Data
    public static class Create {
        private String title;
        private String companyName;
        private String location;
        private String employmentType;
        private String experienceLevel;
        private String salaryRange;
        private String jobDescription;
        private String requirements;
        private String applyLink;
        private String source;
        private LocalDate datePosted;
        private String status;
        private Double aiScore;
        private List<String> tags;
        private Boolean remoteOption;
        private Long companyId;
    }

    @Data
    public static class Update {
        private String location;
        private String employmentType;
        private String experienceLevel;
        private String salaryRange;
        private String jobDescription;
        private String requirements;
        private String status;
        private Boolean remoteOption;
    }

    @Data
    public static class Response {
        private Long id;
        private String title;
        private String companyName;
        private String location;
        private String employmentType;
        private String experienceLevel;
        private String salaryRange;
        private String jobDescription;
        private String requirements;
        private String applyLink;
        private String source;
        private LocalDate datePosted;
        private String status;
        private Double aiScore;
        private List<String> tags;
        private Boolean remoteOption;
        private Long companyId;
    }
}
