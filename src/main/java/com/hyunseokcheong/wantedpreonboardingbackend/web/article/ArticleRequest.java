package com.hyunseokcheong.wantedpreonboardingbackend.web.article;

import lombok.Builder;

@Builder
public record ArticleRequest(String title, String content) {
}
