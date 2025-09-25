package com.example.nodelogin.user.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String username;
    private String password;
    private String gender;
    private String grade;
    private String classnumber;
    private String specialty;
    private String email;
}
