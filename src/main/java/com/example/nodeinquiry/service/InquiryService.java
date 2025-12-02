package com.example.nodeinquiry.service;

import com.example.nodeinquiry.dto.PostDto;
import com.example.nodeinquiry.entity.Inquiry;
import com.example.nodeinquiry.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryService {
    @Autowired
    private InquiryRepository inquiryRepository;

    public Inquiry saveInquiry(PostDto postDto) {
        Inquiry inquiry = postDto.toEntity();
        return inquiryRepository.save(inquiry);
    }
}