package com.example.nodelogin.user.dto;
import lombok.*;
import com.example.nodelogin.user.entity.User.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Register2Dto {
    private String username;
    private String password;
    private String gender;
    private Integer grade;
    private Integer classnumber;
    private Role role;
}