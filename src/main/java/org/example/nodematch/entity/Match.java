package org.example.nodematch.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Builder;


@Entity
@Table(name = "infor")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Infor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 10, nullable = false)
    private String mbti;

    @Column(length = 50, nullable = false)
    private String major;

    @Column(length = 50)
    private String desiredMentor;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String reasonToJoinGSM;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String futureGoals;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String worriesBeforeSchool;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String recentConcerns;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String freeMessage;


    @Builder
    public Infor(String mbti, String major, String desiredMentor,
                 String reasonToJoinGSM, String futureGoals,
                 String worriesBeforeSchool, String recentConcerns,
                 String freeMessage) {
        this.mbti = mbti;
        this.major = major;
        this.desiredMentor = desiredMentor;
        this.reasonToJoinGSM = reasonToJoinGSM;
        this.futureGoals = futureGoals;
        this.worriesBeforeSchool = worriesBeforeSchool;
        this.recentConcerns = recentConcerns;
        this.freeMessage = freeMessage;
    }
}