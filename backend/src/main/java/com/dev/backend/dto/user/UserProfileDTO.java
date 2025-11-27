package com.dev.backend.dto.user;

import com.dev.backend.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserProfileDTO {
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private User.Role role;
    private LocalDateTime createdAt;
    private String preferredLocation;
    private String skills;
    private String resumeLink;

    private int appliedJobsCount;
    private int savedJobsCount;

}