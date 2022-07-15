package com.espinas.fhir.rest.dto.response.user;

import com.espinas.fhir.domain.user.collection.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponse {
    private String userId;
    private String userName;
    private Long userAge;
    private String userGender;

    @Builder
    public UserResponse(String userId, String userName, Long userAge, String userGender) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userGender = userGender;
    }

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userAge(user.getUserAge())
                .userGender(user.getUserGender())
                .build();
    }
}
