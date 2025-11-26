package org.example.nodematch.entity;

import jakarta.persistence.*;
import lombok.AccessLevel; // Lombok AccessLevel 임포트 추가
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString; // ToString 어노테이션 추가

// 1. @Setter 대신 필요한 메서드만 사용 (불변성/제어권 확보)
// 2. @AllArgsConstructor 대신 @Builder 사용 권장
@Entity
@Table(name = "infor") // 테이블 이름 명시
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 3. 기본 생성자를 PROTECTED로 설정
@ToString // 4. 로깅 및 디버깅을 위해 추가
public class Infor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 5. 기본적으로 Not Null 제약조건 추가 (nullable = false)
    @Column(length = 10, nullable = false)
    private String mbti;

    @Column(length = 50, nullable = false)
    private String major;

    @Column(length = 50)
    private String desiredMentor;

    // 대용량 텍스트 타입 지정 (DB 종류에 따라 TEXT 또는 CLOB에 매핑됨)
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

    // 6. Builder 패턴을 생성자로 대체 (가독성 및 불변성 확보)
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