package com.example.pollDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CheckEmailOrPhoneRequest {

    @NotEmpty
    private String value;

}
