package com.sbapi.controller;

import com.sbapi.model.User;
import com.sbapi.repo.UserRepository;
import com.sbapi.requests.RegistrationRequest;
import com.sbapi.response.ApiResponse;
import com.sbapi.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/api/auth")
public class RegisterController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationRequest registrationRequest) {
        if(userRepository.existsByEmail(registrationRequest.getEmail())) {
            return new ResponseEntity<>(new ApiResponse(false, "email already exist!"),
                    HttpStatus.BAD_REQUEST);
        } else
        {
            // Creating a user
            User user = new User(registrationRequest.getFullName(),
                    registrationRequest.getEmail(), registrationRequest.getUsername(), registrationRequest.getPassword());
            user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            user.setEmail(registrationRequest.getEmail());
            user.setFullName(registrationRequest.getFullName());
            user.setUsername(registrationRequest.getUsername());

            User result = userRepository.save(user);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentContextPath().path("/api/users/{fullName}")
                    .buildAndExpand(result.getFullName()).toUri();

            return ResponseEntity.created(location).body(new ApiResponse(true, "You have sucessfully registered"));
        }

    }
}