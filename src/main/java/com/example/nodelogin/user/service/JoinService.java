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

    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    public void joinProcess(JoinDto joinDto) {

        String username = joinDto.getUsername();
        String password = joinDto.getPassword();
        UserEntity.Role role = joinDto.getRole();
        String email = joinDto.getEmail();
        String specialty = joinDto.getSpecialty();
        String gender = joinDto.getGender();
        Integer grade = joinDto.getGrade();
        Integer classNumber = joinDto.getClassNumber();
        UserEntity.Picture picture = joinDto.getPicture();

        Boolean exists = userRepository.existsByUsername(username);

        if (exists) {
            return;
        }

        UserEntity data = new UserEntity();

        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole(role);
        data.setEmail(email);
        data.setGender(gender);
        data.setGrade(grade);
        data.setClassNumber(classNumber);
        data.setPicture(picture);
        data.setSpecialty(specialty);

        userRepository.save(data);

    }
}