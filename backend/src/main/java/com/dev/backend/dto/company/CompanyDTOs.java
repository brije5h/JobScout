package com.dev.backend.dto.company;

import lombok.Data;

public class CompanyDTOs {

    @Data
    public static class Create {
        private String name;
        private String industry;
        private String location;
        private String website;
        private String careerWebsite;
        private String description;
        private Integer employeeCount;
        private Double rating;
    }

    @Data
    public static class Update {
        private String name;
        private String industry;
        private String location;
        private String website;
        private String careerWebsite;
        private String description;
        private Integer employeeCount;
        private Double rating;
    }

    @Data
    public static class Response {
        private Long id;
        private String name;
        private String industry;
        private String location;
        private String website;
        private String careerWebsite;
        private String description;
        private Integer employeeCount;
        private Double rating;
    }
}
