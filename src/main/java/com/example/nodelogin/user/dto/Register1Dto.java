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

public class Register1Dto {
    private User.Role role;
}
