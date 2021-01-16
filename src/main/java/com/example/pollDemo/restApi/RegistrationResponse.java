package com.example.pollDemo.restApi;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationResponse {

    private Boolean result;
    private String message;
}
