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

        public void register (RegisterDto request) {
            String email = request.getUsername() + "@gsm.hs.kr";
            String password = passwordEncoder.encode(request.getPassword());

            User user = User.builder()
                    .email(email)
                    .password(passwordEncoder.encode(request.getPassword()))
                    .gender(request.getGender())
                    .classnumber(request.getClassnumber())
                    .specialty(request.getSpecialty())
                    .build();

            userRepository.save(user);
        }
}