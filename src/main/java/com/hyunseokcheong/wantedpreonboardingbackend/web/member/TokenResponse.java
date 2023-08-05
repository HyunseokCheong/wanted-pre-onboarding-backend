package com.hyunseokcheong.wantedpreonboardingbackend.web.member;

import lombok.Builder;

@Builder
public record TokenResponse(String accessToken, String refreshToken, Long accessTokenExpiresIn) {
}
