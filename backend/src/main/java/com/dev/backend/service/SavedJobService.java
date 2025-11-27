package com.dev.backend.service;

import com.dev.backend.model.SavedJob;
import com.dev.backend.model.User;
import com.dev.backend.repository.SavedJobRepository;
import com.dev.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedJobService {

    private final SavedJobRepository savedJobRepository;
    private final UserRepository userRepository;

    public SavedJobService(SavedJobRepository savedJobRepository, UserRepository userRepository) {
        this.savedJobRepository = savedJobRepository;
        this.userRepository = userRepository;
    }

    public SavedJob saveJob(SavedJob savedJob) {
        SavedJob saved =  savedJobRepository.save(savedJob);
//        updateUserCount(saved.getUser(), null, saved.getStatus());
        return saved;
    }

    public List<SavedJob> getSavedJobsByUser(User user) {
        return savedJobRepository.findByUser(user);
    }

    public void deleteSavedJob(Long id) {
        if (!savedJobRepository.existsById(id)) {
            throw new IllegalArgumentException("Saved job not found with ID: " + id);
        }
        savedJobRepository.deleteById(id);
    }

    public List<SavedJob> getAllSavedJobs() {
        return savedJobRepository.findAll();
    }

//    private void updateUserCount(User user, SavedJob.SavedJobStatus oldStatus, SavedJob.SavedJobStatus newStatus){
//        if(oldStatus == SavedJob.SavedJobStatus.APPLIED){
//            user.setAppliedJobsCount(user.getAppliedJobsCount()-1);
//        } else if(oldStatus == SavedJob.SavedJobStatus.SAVED){
//            user.setSavedJobsCount(user.getSavedJobsCount()-1);
//        }
//    }

}
