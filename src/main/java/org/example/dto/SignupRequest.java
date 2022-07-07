package org.example.dto;
import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class SignupRequest
{  @Email
    private String emailId;
    @NotNull
    private String password;
    @NotNull
    private  String name;
}
