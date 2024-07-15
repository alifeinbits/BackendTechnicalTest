package com.compulynx.interview.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String customerId;
    private String pin;

}
