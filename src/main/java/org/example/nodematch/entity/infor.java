package org.example.nodematch.entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class infor {

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

}
