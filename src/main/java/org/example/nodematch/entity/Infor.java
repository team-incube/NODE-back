package org.example.nodematch.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Infor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mbti;

    private String major;

    private String desiredMentor;

    @Column(columnDefinition = "TEXT")
    private String reasonToJoinGSM;

    @Column(columnDefinition = "TEXT")
    private String futureGoals;

    @Column(columnDefinition = "TEXT")
    private String worriesBeforeSchool;

    @Column(columnDefinition = "TEXT")
    private String recentConcerns;

    @Column(columnDefinition = "TEXT")
    private String freeMessage;
}
