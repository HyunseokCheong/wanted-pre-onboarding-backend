package com.hyunseokcheong.wantedpreonboardingbackend.web.article;

import lombok.Builder;

@Builder
public record ArticleResponse(Long id, String title, String content, Long memberId, String memberEmail) {
}
