package com.espinas.fhir.rest.dto.response.user;

import com.espinas.fhir.domain.user.collection.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponse {
    private String id;
    private String name;
    private Long age;
    private String gender;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public UserResponse(String id, String name, Long age, String gender, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .gender(user.getGender())
                .createdDate(user.getCreatedDate())
                .modifiedDate(user.getLastModifiedDate())
                .build();
    }
}
