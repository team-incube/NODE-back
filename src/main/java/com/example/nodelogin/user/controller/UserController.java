package com.example.nodelogin.user.controller;
import com.example.nodelogin.security.JwtUtil;
import com.example.nodelogin.user.dto.LoginDto;
import com.example.nodelogin.user.dto.Register1Dto;
import com.example.nodelogin.user.dto.Register2Dto;
import com.example.nodelogin.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import com.example.nodelogin.user.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.nodelogin.user.service.RegisterService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final RegisterService registerService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping("/step1")
    public ResponseEntity<String> register1(@RequestBody Register1Dto register1Dto) {
        return ResponseEntity.ok("역할 선택 완료!");
    }

    @PostMapping("/step2")
    public ResponseEntity<String> register1(@RequestBody Register2Dto register2Dto) {
        registerService.register2(register2Dto);
        return ResponseEntity.ok("회원가입 성공!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        String email = loginDto.getUsername() + "@gsm.hs.kr";

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자"));
        if(!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }

        return ResponseEntity.ok("로그인 완료!");
    }
}
