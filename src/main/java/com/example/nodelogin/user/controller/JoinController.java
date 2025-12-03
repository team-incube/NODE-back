package com.example.nodelogin.user.controller;

import com.example.nodelogin.user.dto.JoinDto;
import com.example.nodelogin.user.service.JoinService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @PostMapping("/join")
    public String join(@RequestBody JoinDto joinDto) {
        joinService.joinProcess(joinDto);
        return "ok";
    }
}
