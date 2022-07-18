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
    private String id;
    @NotBlank
    private String name;
    @NotNull
    private Long age;
    @NotBlank
    private String gender;

    @Builder
    public UserRequest(String id, String name, Long age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static User to(UserRequest userRequest) {
        return User.builder()
                .id(userRequest.getId())
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .gender(userRequest.getGender())
                .build();
    }
}
