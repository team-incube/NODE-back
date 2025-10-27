package com.example.nodelogin.user.service;
import com.example.nodelogin.user.dto.RegisterDto;
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

    public void register(RegisterDto registerDto) {
        if (registerDto.getUsername() == null || registerDto.getUsername().isBlank()) {
            throw new IllegalArgumentException("아이디(Username)를 입력해야 합니다.");
        }

        String email = registerDto.getUsername() + "@gsm.hs.kr";

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }


        String rawPassword = registerDto.getPassword();

        if (rawPassword.length() < 8 || rawPassword.length() > 12) {
            throw new IllegalArgumentException("비밀번호는 8자 이상 12자 이하로 작성해야 합니다.");
        }

        if (!rawPassword.matches(".*[A-Za-z].*") || !rawPassword.matches(".*\\d.*")) {
            throw new IllegalArgumentException("비밀번호는 영문자와 숫자를 모두 포함해야 합니다.");
        }

        String password = passwordEncoder.encode(registerDto.getPassword());

        User user = User.builder()
                .email(email)
                .password(password)
                .gender(registerDto.getGender())
                .classnumber(registerDto.getClassnumber())
                .role(registerDto.getRole())
                .grade(registerDto.getGrade())
                .picture(registerDto.getPicture())
                .specialty(registerDto.getSpecialty())
                .build();

        userRepository.save(user);
    }
}