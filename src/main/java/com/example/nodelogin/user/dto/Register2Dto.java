package com.example.nodelogin.user.dto;
import lombok.*;

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
}