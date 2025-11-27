package com.dev.backend.service;

import com.dev.backend.dto.user.UserProfileDTO;
import com.dev.backend.model.User;
import com.dev.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    private UserProfileDTO convertToDTO(User user){
        UserProfileDTO dto = new UserProfileDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setPreferredLocation(user.getPreferredLocation());
        dto.setSkills(user.getSkills());
        dto.setResumeLink(user.getResumeLink());

        dto.setAppliedJobsCount(user.getAppliedJobsCount());
        dto.setSavedJobsCount(user.getSavedJobsCount());

        return dto;
    }

    //Create User
    public User createUser(User user){
        if(userRepository.existsByUsername(user.getUsername())){
            throw new IllegalArgumentException("Username already exists");
        }
        return userRepository.save(user);
    }

    //Delete User
    public String deleteUser(String username){
        Optional<User> existingUser = userRepository.findByUsername(username);
        if(existingUser.isPresent()){
            userRepository.delete(existingUser.get());
            return existingUser.get().getUsername();
        } else {
            throw new IllegalArgumentException("User not found with username");
        }
    }

    //Edit User
    public User editUser(Long id, User updatedUser){
        return userRepository.findById(id).map(user -> {
            user.setEmail(updatedUser.getEmail());
            user.setFullName(updatedUser.getFullName());
            user.setSkills((updatedUser.getSkills()));
            user.setRole(updatedUser.getRole());
            return userRepository.save(user);
        }).orElseThrow(()->new IllegalArgumentException("User not found with ID: "+id));
    }

    @Transactional
    public UserProfileDTO getUserDetails(String username){
        User user =  userRepository.findByUsername(username).orElseThrow(
                ()-> new IllegalArgumentException("User not found wih username "+username)
        );
        return convertToDTO(user);
    }

    @Transactional
    public UserProfileDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User not found with id " + id)
        );
        return convertToDTO(user);
    }

    @Transactional
    public List<UserProfileDTO> getAllUsers(){
        return userRepository.findAll().stream().map(this::convertToDTO).toList();
    }

}
