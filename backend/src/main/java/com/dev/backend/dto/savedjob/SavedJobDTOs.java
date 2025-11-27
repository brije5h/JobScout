package com.dev.backend.dto.savedjob;

import lombok.Data;
import java.time.LocalDateTime;

public class SavedJobDTOs {

    @Data
    public static class Create {
        private Long userId;
        private Long jobId;
        private String status;
    }

    @Data
    public static class Update {
        private String status;
    }

    @Data
    public static class Response {
        private Long id;
        private Long userId;
        private Long jobId;
        private String status;
        private LocalDateTime savedAt;
        private LocalDateTime updatedAt;
    }
}
