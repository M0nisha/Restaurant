package org.example.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginRequest {
    @NotNull
    private String emailId;
    @NotNull
    private String password;
}
