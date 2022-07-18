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
        return response(userService.addUser(userRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getUser(@PathVariable String id) {
        return response(userService.getUser(id));
    }

    @PutMapping
    public ResponseEntity<Response> updateUser(@Valid @RequestBody UserRequest userRequest) {
        return response(userService.updateUser(userRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable String id) {
        return response(userService.deleteUser(id));
    }
}
