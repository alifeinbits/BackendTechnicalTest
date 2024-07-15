package com.compulynx.interview.controller;

import com.compulynx.interview.request.LoginRequest;
import com.compulynx.interview.response.LoginResponse;
import com.compulynx.interview.service.CustomUserDetailsService;
import com.compulynx.interview.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {


    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailsService userDetailsService;

    private final JwtUtil jwtUtil;

    public LoginController(AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getCustomerId(), loginRequest.getPin())
            );
        } catch (Exception e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginRequest.getCustomerId());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new LoginResponse(jwt,userDetails.getUsername()));
    }
}
