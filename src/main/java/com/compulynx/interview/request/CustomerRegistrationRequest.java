package com.compulynx.interview.request;

import lombok.Data;

@Data
public class CustomerRegistrationRequest {
    private String name;
    private String email;
    private String customerId;
    private String pin;

}
