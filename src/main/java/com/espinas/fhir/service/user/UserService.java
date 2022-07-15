package com.espinas.fhir.service.user;

import com.espinas.fhir.domain.user.collection.User;
import com.espinas.fhir.domain.user.repository.UserRepository;
import com.espinas.fhir.rest.dto.request.user.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addUser(UserRequest userRequest) {
        User user = UserRequest.from(userRequest);
        return userRepository.save(user);
    }

    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());
        return user;
    }

    public User updateUser(UserRequest userRequest) {
        User user = userRepository.findById(userRequest.getUserId()).orElseThrow(() -> new RuntimeException());
        user.updateUser(userRequest);
        userRepository.save(user);
        return user;
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
