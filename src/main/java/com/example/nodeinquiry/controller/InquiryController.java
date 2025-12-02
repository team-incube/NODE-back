package com.example.nodeinquiry.controller;

import com.example.nodeinquiry.dto.PostDto;
import com.example.nodeinquiry.entity.Inquiry;
import com.example.nodeinquiry.repository.InquiryRepository;
import com.example.nodeinquiry.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inquiry")
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @PostMapping("/write")
    public Inquiry post(@RequestBody PostDto postDto) {
        return inquiryService.saveInquiry(postDto);
    }
}
