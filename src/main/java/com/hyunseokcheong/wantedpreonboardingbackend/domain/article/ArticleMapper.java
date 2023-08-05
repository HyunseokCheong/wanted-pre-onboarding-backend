package com.hyunseokcheong.wantedpreonboardingbackend.domain.article;

import com.hyunseokcheong.wantedpreonboardingbackend.web.article.ArticleResponse;

public class ArticleMapper {
    public static ArticleResponse toResponse(Article article) {
        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .memberId(article.getMember().getId())
                .memberEmail(article.getMember().getEmail())
                .build();
    }
}
