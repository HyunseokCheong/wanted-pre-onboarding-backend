package com.hyunseokcheong.wantedpreonboardingbackend.domain.article;

import com.hyunseokcheong.wantedpreonboardingbackend.domain.member.Member;
import com.hyunseokcheong.wantedpreonboardingbackend.domain.member.MemberRepository;
import com.hyunseokcheong.wantedpreonboardingbackend.web.article.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    
    public ResponseEntity<Object> findAllArticles(Pageable pageable) {
        List<ArticleResponse> list = articleRepository.findAll(pageable)
                .stream()
                .map(ArticleMapper::toResponse)
                .toList();
        ArticleListResponse response = ArticleListResponse.builder()
                .count(list.size())
                .articles(list)
                .build();
        
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    public ResponseEntity<Object> findById(Long articleId) {
        Article article = articleRepository.findById(articleId).orElse(null);
        if (article == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("존재하지 않는 게시글입니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ArticleMapper.toResponse(article));
    }
    
    public ResponseEntity<Object> updateArticle(Long memberId, Long articleId, ArticleRequest request) {
        Article article = articleRepository.findById(articleId).orElse(null);
        if (article == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("존재하지 않는 게시글입니다.");
        }
        if (!Objects.equals(memberId, article.getMember().getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("작성자만 수정할 수 있습니다.");
        }
        
        article.update(request.title(), request.content());
        articleRepository.save(article);
        return ResponseEntity.status(HttpStatus.OK).body("게시글이 수정되었습니다.");
    }
    
    public ResponseEntity<Object> deleteArticle(Long memberId, Long articleId) {
        Article article = articleRepository.findById(articleId).orElse(null);
        if (article == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("존재하지 않는 게시글입니다.");
        }
        if (!Objects.equals(memberId, article.getMember().getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("작성자만 수정할 수 있습니다.");
        }
        
        articleRepository.delete(article);
        return ResponseEntity.status(HttpStatus.OK).body("게시글이 삭제되었습니다.");
    }
}
