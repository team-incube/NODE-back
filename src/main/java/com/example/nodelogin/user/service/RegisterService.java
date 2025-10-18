package com.example.nodelogin.user.service;
import com.example.nodelogin.user.dto.Register1Dto;
import com.example.nodelogin.user.dto.Register2Dto;
import com.example.nodelogin.user.dto.Register3Dto;
import com.example.nodelogin.user.dto.Register4Dto;
import com.example.nodelogin.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.nodelogin.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register2(Register2Dto register2Dto) {
        if (register2Dto.getUsername() == null || register2Dto.getUsername().isBlank()) {
            throw new IllegalArgumentException("아이디(Username)를 입력해야 합니다.");
        }

        String email = register2Dto.getUsername() + "@gsm.hs.kr";

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }


        String rawPassword = register2Dto.getPassword();

        if (rawPassword.length() < 8 || rawPassword.length() > 12) {
            throw new IllegalArgumentException("비밀번호는 8자 이상 12자 이하로 작성해야 합니다.");
        }

        if (!rawPassword.matches(".*[A-Za-z].*") || !rawPassword.matches(".*\\d.*")) {
            throw new IllegalArgumentException("비밀번호는 영문자와 숫자를 모두 포함해야 합니다.");
        }

        String password = passwordEncoder.encode(register2Dto.getPassword());

        User user = User.builder()
                .email(email)
                .password(password)
                .gender(register2Dto.getGender())
                .classnumber(register2Dto.getClassnumber())
                .role(register2Dto.getRole())
                .build();
    }

    public void register1(Register1Dto register1Dto) {
        User user = User.builder()
                .role(register1Dto.getRole())
                .build();
    }

    public void register3(Register3Dto register3Dto) {
        User user = User.builder()
                .specialty(register3Dto.getSpecialty())
                .build();
    }

    public void register4(Register4Dto register4Dto, Register2Dto register2Dto, Register1Dto register1Dto, Register3Dto register3Dto) {
        User user = User.builder()
                .email(register2Dto.getUsername() + "@gsm.hs.kr")
                .password(passwordEncoder.encode(register2Dto.getPassword()))
                .gender(register2Dto.getGender())
                .classnumber(register2Dto.getClassnumber())
                .role(register2Dto.getRole())
                .picture(register4Dto.getPicture())
                .build();
        userRepository.save(user);
    }
}