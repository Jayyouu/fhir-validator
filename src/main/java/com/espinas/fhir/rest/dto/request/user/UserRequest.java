package com.espinas.fhir.rest.dto.request.user;

import com.espinas.fhir.domain.user.collection.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UserRequest {
    @NotNull
    private String userId;
    @NotBlank
    private String userName;
    @NotNull
    private Long userAge;
    @NotBlank
    private String userGender;

    @Builder
    public UserRequest(String userId, String userName, Long userAge, String userGender) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userGender = userGender;
    }

    public static User from(UserRequest userRequest) {
        return User.builder()
                .userId(userRequest.getUserId())
                .userName(userRequest.getUserName())
                .userAge(userRequest.getUserAge())
                .userGender(userRequest.getUserGender())
                .build();
    }
}
