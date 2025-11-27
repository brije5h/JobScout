package com.dev.backend.service;

import com.dev.backend.model.Job;
import com.dev.backend.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job updateJob(Long id, Job updatedJob) {
        return jobRepository.findById(id).map(job -> {
            job.setTitle(updatedJob.getTitle());
            job.setCompanyName(updatedJob.getCompanyName());
            job.setLocation(updatedJob.getLocation());
            job.setEmploymentType(updatedJob.getEmploymentType());
            job.setExperienceLevel(updatedJob.getExperienceLevel());
            job.setSalaryRange(updatedJob.getSalaryRange());
            job.setJobDescription(updatedJob.getJobDescription());
            job.setRequirements(updatedJob.getRequirements());
            job.setApplyLink(updatedJob.getApplyLink());
            job.setSource(updatedJob.getSource());
            job.setStatus(updatedJob.getStatus());
            job.setTags(updatedJob.getTags());
            job.setRemoteOption(updatedJob.getRemoteOption());
            job.setCompany(updatedJob.getCompany());
            return jobRepository.save(job);
        }).orElseThrow(() -> new IllegalArgumentException("Job not found with ID: " + id));
    }

    public void deleteJob(Long id) {
        if (!jobRepository.existsById(id)) {
            throw new IllegalArgumentException("Job not found with ID: " + id);
        }
        jobRepository.deleteById(id);
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Job not found with ID: " + id));
    }

    public List<Job> getJobsByCompanyName(String companyName) {
        return jobRepository.findByCompanyName(companyName);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}
