package com.example.nodelogin.user.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.nodelogin.user.entity.UserEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JoinDto {
    private UserEntity.Role role;
    private UserEntity.Picture picture;
    private String username;
    private String password;
    private String email;
    private String gender;
    private Integer grade;
    private Integer classnumber;
    private String specialty;
}