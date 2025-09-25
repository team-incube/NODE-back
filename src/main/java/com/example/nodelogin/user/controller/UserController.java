package com.example.nodelogin.user.controller;
import com.example.nodelogin.security.JwtUtil;
import com.example.nodelogin.user.dto.LoginDto;
import com.example.nodelogin.user.dto.RegisterDto;
import com.example.nodelogin.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import com.example.nodelogin.user.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.nodelogin.user.service.RegisterService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final RegisterService registerService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if(!registerDto.getEmail().endsWith("@gsm.hs.kr")) {
            throw new IllegalArgumentException("해당 도메인만 가입 가능합니다.");
        }

        registerService.register(registerDto);
        return ResponseEntity.ok("회원가입 성공!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자"));
        if(!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }

        return ResponseEntity.ok(jwtUtil.generateToken(user.getEmail()));
    }
}
