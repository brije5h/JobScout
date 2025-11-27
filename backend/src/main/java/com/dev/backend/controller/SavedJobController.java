package com.dev.backend.controller;

import com.dev.backend.model.SavedJob;
import com.dev.backend.model.User;
import com.dev.backend.service.SavedJobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saved-jobs")
public class SavedJobController {

    private final SavedJobService savedJobService;

    public SavedJobController(SavedJobService savedJobService) {
        this.savedJobService = savedJobService;
    }

    @PostMapping
    public ResponseEntity<SavedJob> saveJob(@RequestBody SavedJob savedJob) {
        return ResponseEntity.ok(savedJobService.saveJob(savedJob));
    }

    @GetMapping("/getAllSavedJobs")
    public ResponseEntity<List<SavedJob>> getAllSavedJobs() {
        return ResponseEntity.ok(savedJobService.getAllSavedJobs());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSavedJob(@PathVariable Long id) {
        savedJobService.deleteSavedJob(id);
        return ResponseEntity.ok("Saved job deleted successfully");
    }
}
