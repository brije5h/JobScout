package com.dev.backend.repository;

import com.dev.backend.model.SavedJob;
import com.dev.backend.model.User;
//import com.dev.backend.projection.SavedJobProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedJobRepository extends JpaRepository<SavedJob, Long> {
    List<SavedJob> findByUser(User user);
//    List<SavedJobProjection> findByUser_IdStatus(Long userId, SavedJob.SavedJobStatus status);
//    Long countByUserIdAndStatus(Long userId, SavedJob.SavedJobStatus status);

}
