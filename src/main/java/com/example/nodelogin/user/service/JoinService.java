package com.example.nodelogin.user.service;
import com.example.nodelogin.user.dto.JoinDto;
import com.example.nodelogin.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.nodelogin.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinService(JoinDto joinDto) {
        UserEntity userEntity = new UserEntity();
        UserEntity.setUsername(joinDto.getUsername());
        userEntity.setPassword(bCryptPasswordEncoder(joinDto.getPassword()));

        if(userRepository.findByUsername(joinDto.getUsername())) {
            return;
        }
        userRepository.save(userEntity);
    }
}