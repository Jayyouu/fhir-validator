package com.espinas.fhir.rest.controller.api.user;

import com.espinas.fhir.rest.controller.BaseController;
import com.espinas.fhir.rest.dto.request.user.UserRequest;
import com.espinas.fhir.rest.dto.response.Response;
import com.espinas.fhir.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Response> addUser(@Valid @RequestBody UserRequest userRequest) {
        ResponseEntity<Response> response = response(userService.addUser(userRequest));
        return response;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Response> getUser(@PathVariable String userId) {
        ResponseEntity<Response> response = response(userService.getUser(userId));
        return response;
    }

    @PutMapping
    public ResponseEntity<Response> updateUser(@Valid @RequestBody UserRequest userRequest) {
        ResponseEntity<Response> response = response(userService.updateUser(userRequest));
        return response;
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Response> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        ResponseEntity<Response> response = response("Delete Success");
        return response;
    }
}
