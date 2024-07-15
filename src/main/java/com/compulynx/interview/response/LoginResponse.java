package com.compulynx.interview.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String jwtToken;
    private String username;

}

