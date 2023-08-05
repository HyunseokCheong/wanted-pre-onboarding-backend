package com.hyunseokcheong.wantedpreonboardingbackend.web.article;

import com.hyunseokcheong.wantedpreonboardingbackend.domain.article.ArticleService;
import com.hyunseokcheong.wantedpreonboardingbackend.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
public class ArticleController {
    
    private final ArticleService articleService;
    
    @PostMapping
    public ResponseEntity<Object> createArticle(@RequestBody ArticleRequest request) {
        return articleService.createArticle(SecurityUtil.getCurrentMemberId(), request);
    }
    
    @GetMapping
    public ResponseEntity<Object> findAllArticles(Pageable pageable) {
        return articleService.findAllArticles(pageable);
    }
    
    @GetMapping("/{articleId}")
    public ResponseEntity<Object> findArticleById(@PathVariable Long articleId) {
        return articleService.findById(articleId);
    }
    
    @PutMapping("/{articleId}")
    public ResponseEntity<Object> updateArticle(@PathVariable Long articleId, @RequestBody ArticleRequest request) {
        return articleService.updateArticle(SecurityUtil.getCurrentMemberId(), articleId, request);
    }
    
    @DeleteMapping("/{articleId}")
    public ResponseEntity<Object> deleteArticle(@PathVariable Long articleId) {
        return articleService.deleteArticle(SecurityUtil.getCurrentMemberId(), articleId);
    }
}
