package com.example.nodeinquiry.dto;

import com.example.nodeinquiry.entity.Inquiry;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String writer;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Inquiry toEntity() {
        Inquiry inquiry = new Inquiry();
        inquiry.setTitle(this.title);
        inquiry.setContent(this.content);
        inquiry.setWriter(this.writer);
        return inquiry;
    }
}
