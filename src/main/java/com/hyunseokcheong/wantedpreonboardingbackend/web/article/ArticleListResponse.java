package com.hyunseokcheong.wantedpreonboardingbackend.web.article;

import lombok.Builder;

import java.util.List;

@Builder
public record ArticleListResponse(Integer count, List<ArticleResponse> articles) {
}
