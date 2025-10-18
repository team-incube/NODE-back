package com.example.nodelogin.user.controller;
import com.example.nodelogin.security.JwtUtil;
import com.example.nodelogin.user.dto.*;
import com.example.nodelogin.user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<String> register1(@RequestBody Register1Dto register1Dto, HttpSession session) {
        return ResponseEntity.ok("역할 선택 완료! 다음 단계로 넘어가 주세요");
    }

    @PostMapping("/step2")
    public ResponseEntity<String> register2(@RequestBody Register2Dto register2Dto,  HttpSession session) {
        registerService.register2(register2Dto);
        return ResponseEntity.ok("개인 정보 입력 완료! 다음 단계로 넘어가 주세요");
    }

    @PostMapping("step3")
    public ResponseEntity<String> register3(@RequestBody Register3Dto register3Dto,  HttpSession session) {
        registerService.register3(register3Dto);
        return ResponseEntity.ok("전공 선택 완료! 다음 단계로 넘어가 주세요");
    }

    @PostMapping("/step4")
    public ResponseEntity<String> register4(@RequestBody Register4Dto register4Dto,  HttpSession session) {
        registerService.register4(register4Dto);
        return ResponseEntity.ok("프로필 선택 완료! 회원가입이 완료 되었습니다!");
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
