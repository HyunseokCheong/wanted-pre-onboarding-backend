package com.hyunseokcheong.wantedpreonboardingbackend.domain.article;

import com.hyunseokcheong.wantedpreonboardingbackend.domain.member.Member;
import com.hyunseokcheong.wantedpreonboardingbackend.util.BaseEntity;
import com.hyunseokcheong.wantedpreonboardingbackend.web.article.ArticleResponse;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "article")
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
    
    @Builder
    public Article(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }
    
    public ArticleResponse toResponse() {
        return ArticleResponse.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .memberId(this.member.getId())
                .memberEmail(this.member.getEmail())
                .build();
    }
}
