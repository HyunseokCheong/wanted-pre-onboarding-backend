package com.hyunseokcheong.wantedpreonboardingbackend.domain.member;

import com.hyunseokcheong.wantedpreonboardingbackend.domain.article.Article;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    
    private String email;
    
    private String password;
    
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Article> articleList = new ArrayList<>();
    
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
    
    public void addArticle(Article article) {
        articleList.add(article);
    }
}
