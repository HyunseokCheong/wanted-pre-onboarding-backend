package com.hyunseokcheong.wantedpreonboardingbackend.domain.member;

import com.hyunseokcheong.wantedpreonboardingbackend.web.member.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    
    public ResponseEntity<Object> signup(MemberRequest request) {
        String email = request.email();
        if (memberRepository.existsByEmail(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 가입된 E-mail 입니다.");
        }
        ResponseEntity<Object> response = validateRequest(request);
        if (response.getStatusCode() != HttpStatus.OK) {
            return response;
        }
        
        String password = passwordEncoder.encode(request.password());
        
        Member member = Member.builder()
                .email(email)
                .password(password)
                .build();
        
        memberRepository.save(member);
        return response;
    }
    
    private ResponseEntity<Object> validateRequest(MemberRequest request) {
        String email = request.email();
        
        if (!email.contains("@")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("@를 포함한 E-mail을 입력해주세요.");
        }
        if (request.password().length() < 8) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("비밀번호는 8자 이상 입력해주세요.");
        }
        return ResponseEntity.status(HttpStatus.OK).body("회원가입이 완료되었습니다.");
    }
}
