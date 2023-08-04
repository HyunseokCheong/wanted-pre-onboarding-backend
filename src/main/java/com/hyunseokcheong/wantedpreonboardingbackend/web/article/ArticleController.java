package com.hyunseokcheong.wantedpreonboardingbackend.web.article;

import com.hyunseokcheong.wantedpreonboardingbackend.domain.article.ArticleService;
import com.hyunseokcheong.wantedpreonboardingbackend.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
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
}
