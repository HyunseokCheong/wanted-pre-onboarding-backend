package com.hyunseokcheong.wantedpreonboardingbackend.web.member;

import com.hyunseokcheong.wantedpreonboardingbackend.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    
    private final MemberService memberService;
    
    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody MemberRequest request) {
        return memberService.signup(request);
    }
}
