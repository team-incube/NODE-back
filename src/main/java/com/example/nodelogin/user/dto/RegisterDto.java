package com.example.nodelogin.user.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.nodelogin.user.entity.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RegisterDto {
    private User.Role role;
    private User.Picture picture;
    private String username;
    private String password;
    private String gender;
    private Integer grade;
    private Integer classnumber;
    private String specialty;
}