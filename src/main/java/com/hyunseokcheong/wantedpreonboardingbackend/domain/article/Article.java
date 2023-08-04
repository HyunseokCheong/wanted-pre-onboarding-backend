package com.hyunseokcheong.wantedpreonboardingbackend.domain.article;

import com.hyunseokcheong.wantedpreonboardingbackend.domain.member.Member;
import com.hyunseokcheong.wantedpreonboardingbackend.util.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "article")
@Builder
public class Article extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;
    
    private String title;
    
    private String content;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
