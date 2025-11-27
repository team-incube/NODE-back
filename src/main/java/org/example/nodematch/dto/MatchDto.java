package org.example.nodematch.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class MatchingDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MatchingRequestDto {

        @NotBlank
        private String applicantName;
        private String mbti;
        private String major;
        private String desiredMentor;
        private String reasonToJoinGSM;
        private String futureGoals;
        private String worriesBeforeSchool;
        private String recentConcerns;
        private String freeMessage;
    }
}
