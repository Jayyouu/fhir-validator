package com.espinas.fhir.domain.user.collection;

import com.espinas.fhir.domain.common.BaseEntity;
import com.espinas.fhir.rest.dto.request.user.UserRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    private String id;
    private String name;
    private Long age;
    private String gender;

    @Builder
    public User(String id, String name, Long age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void update(UserRequest userRequest) {
        this.id = userRequest.getId();
        this.name = userRequest.getName();
        this.age = userRequest.getAge();
        this.gender = userRequest.getGender();
    }
}
