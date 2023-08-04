package com.hyunseokcheong.wantedpreonboardingbackend.domain.article;

import com.hyunseokcheong.wantedpreonboardingbackend.domain.member.Member;
import com.hyunseokcheong.wantedpreonboardingbackend.domain.member.MemberRepository;
import com.hyunseokcheong.wantedpreonboardingbackend.web.article.ArticleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    
    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    
    public ResponseEntity<Object> createArticle(Long memberId, ArticleRequest request) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("존재하지 않는 회원입니다.");
        }
        
        Article article = Article.builder()
                .title(request.title())
                .content(request.content())
                .member(member)
                .build();
        member.addArticle(article);
        articleRepository.save(article);
        
        return ResponseEntity.status(HttpStatus.CREATED).body("게시글이 등록되었습니다.");
    }
}
