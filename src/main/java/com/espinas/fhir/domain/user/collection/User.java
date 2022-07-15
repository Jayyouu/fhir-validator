package com.espinas.fhir.domain.user.collection;

import com.espinas.fhir.domain.common.BaseEntity;
import com.espinas.fhir.rest.dto.request.user.UserRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "user")
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    private String userId;
    private String userName;
    private Long userAge;
    private String userGender;

    @Builder
    public User(String userId, String userName, Long userAge, String userGender) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userGender = userGender;
    }

    public void updateUser(UserRequest userRequest) {
        this.userId = userRequest.getUserId();
        this.userName = userRequest.getUserName();
        this.userAge = userRequest.getUserAge();
        this.userGender = userRequest.getUserGender();
    }
}
