package com.example.nodelogin.user.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminController {

    @PostMapping("/admin")
    public String adminP() {
        return "admin Controller";
    }
}