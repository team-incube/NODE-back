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

    public void register(RegisterDto request) {
        if (request.getUsername() == null || request.getUsername().isBlank()) {
            throw new IllegalArgumentException("아이디(Username)를 입력해야 합니다.");
        }

        String email = request.getUsername() + "@gsm.hs.kr";

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        String password = passwordEncoder.encode(request.getPassword());

        User user = User.builder()
                .email(email)
                .password(password)
                .gender(request.getGender())
                .classnumber(request.getClassnumber())
                .specialty(request.getSpecialty())
                .build();

        userRepository.save(user);
    }

}