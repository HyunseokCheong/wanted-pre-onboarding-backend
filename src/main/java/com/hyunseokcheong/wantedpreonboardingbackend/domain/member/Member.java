package com.hyunseokcheong.wantedpreonboardingbackend.domain.member;

import com.hyunseokcheong.wantedpreonboardingbackend.domain.article.Article;
import com.hyunseokcheong.wantedpreonboardingbackend.util.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
@Builder
public class Member extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    
    private String email;
    
    private String password;
    
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Article> articleList = new ArrayList<>();
    
    @Enumerated(EnumType.STRING)
    private Authority authority;
    
    public enum Authority {
        ROLE_USER, ROLE_ADMIN
    }
    
    public void addArticle(Article article) {
        articleList.add(article);
    }
}
