package com.thuexcursion.crud.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.thuexcursion.crud.payload.JwtResponse;
import com.thuexcursion.crud.payload.LoginRequest;
import com.thuexcursion.crud.repository.UserRepository;
import com.thuexcursion.crud.security.jwt.JwtUtils;
import com.thuexcursion.crud.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


/**
 * This class handles signup/login requests
 * This controller provides APIs for register and login actions.
 * /api/auth/signin:
 * 1. authenticates username and password
 * 2. update SecurityContext using Authentication object
 * 3. generate JWT
 * 4. get UserDetails from Authentication object
 * 5. response contains JWT and UserDetails data
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUser_number(),
                userDetails.getName_first(),
                userDetails.getName_last(),
                userDetails.getAddress(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }
}
