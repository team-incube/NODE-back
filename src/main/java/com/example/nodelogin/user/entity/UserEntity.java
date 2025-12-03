package com.example.nodelogin.user.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loginId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private Integer grade;

    @Column(nullable = false)
    private Integer classNumber;

    @Column(nullable = false)
    private String specialty;

    @Column(nullable = false)
    private int profile;

        @Enumerated(EnumType.STRING)
        private Role role;
        public enum Role {
            ADMIN,
            USER
        }

        @Enumerated(EnumType.STRING)
        private UserType userType;
        public enum UserType {
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
