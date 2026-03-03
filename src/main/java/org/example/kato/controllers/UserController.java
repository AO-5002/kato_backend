package org.example.kato.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.kato.dtos.user.CreateUserDto;
import org.springframework.security.core.Authentication;
import org.example.kato.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin(
        origins = "http://localhost:5173",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
)
public class UserController {

    private final UserService userService;

    @GetMapping
    public String sayHi() {
        return "Hello World!";
    }

    @PostMapping
    private ResponseEntity<Void> createUser(@RequestBody @Valid CreateUserDto newUser, Authentication auth) {
        String userAuth = auth.getName();

        userService.createUser(userAuth, newUser);
        return ResponseEntity.status(201).build();
    }
}
