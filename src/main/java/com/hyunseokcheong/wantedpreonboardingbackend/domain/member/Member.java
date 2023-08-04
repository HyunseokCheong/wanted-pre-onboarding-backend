package com.hyunseokcheong.wantedpreonboardingbackend.domain.member;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Authority authority = Authority.ROLE_USER;
    
    public enum Authority {
        ROLE_USER, ROLE_ADMIN
    }
    
    @Builder
    public Member(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
