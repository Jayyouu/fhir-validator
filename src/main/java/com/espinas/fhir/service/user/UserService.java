package com.espinas.fhir.service.user;

import com.espinas.fhir.domain.user.collection.User;
import com.espinas.fhir.domain.user.repository.UserRepository;
import com.espinas.fhir.rest.dto.request.user.UserRequest;
import com.espinas.fhir.rest.dto.response.user.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse addUser(UserRequest userRequest) {
        User user = UserRequest.to(userRequest);
        userRepository.save(user);
        UserResponse userResponse = UserResponse.from(user);
        return userResponse;
    }

    public UserResponse getUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        UserResponse userResponse = UserResponse.from(user);
        return userResponse;
    }

    public UserResponse updateUser(UserRequest userRequest) {
        User user = userRepository.findById(userRequest.getId()).orElseThrow(() -> new RuntimeException());
        user.update(userRequest);
        userRepository.save(user);
        UserResponse userResponse = UserResponse.from(user);
        return userResponse;
    }

    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return "Delete Success";
    }
}
