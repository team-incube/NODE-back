package com.example.nodelogin.user.service;

import com.example.nodelogin.user.dto.CustomUserDetails;
import com.example.nodelogin.user.dto.JoinDto;
import com.example.nodelogin.user.entity.UserEntity;
import com.example.nodelogin.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userData = userRepository.findByUsername(username);
        if (userData == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        return new CustomUserDetails(userData);
    }

    public void joinProcess(JoinDto joinDto) {
        if(userRepository.existsByUsername(joinDto.getUsername())){
            throw new RuntimeException("이미 존재하는 사용자입니다.");
        }

        UserEntity user = UserEntity.builder()
                .username(joinDto.getUsername())
                .password(passwordEncoder.encode(joinDto.getPassword()))
                .role(joinDto.getRole())
                .picture(joinDto.getPicture())
                .gender(joinDto.getGender())
                .grade(joinDto.getGrade())
                .classnumber(joinDto.getClassnumber())
                .specialty(joinDto.getSpecialty())
                .build();

        userRepository.save(user);
    }
}
