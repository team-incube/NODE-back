package com.example.nodelogin.user.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loginId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String gender;
    private String username;
    private Integer grade;
    private int classnumber;
    private String specialty;
    private int profile;

        @Enumerated(EnumType.STRING)
        private Role role;
        public enum Role {
            MENTOR,
            MENTEE
        }

        @Enumerated(EnumType.STRING)
        private Picture picture;
        public enum Picture {
            PICTURE1,
            PICTURE2,
            PICTURE3,
            PICTURE4
        }
}
