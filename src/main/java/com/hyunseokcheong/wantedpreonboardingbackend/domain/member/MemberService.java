package com.hyunseokcheong.wantedpreonboardingbackend.domain.member;

import com.hyunseokcheong.wantedpreonboardingbackend.util.TokenProvider;
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
    private final TokenProvider tokenProvider;
    
    public ResponseEntity<Object> signup(MemberRequest request) {
        String email = request.email();
        if (memberRepository.existsByEmail(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 가입된 E-mail 입니다.");
        }
        if (!email.contains("@")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("@를 포함한 E-mail을 입력해주세요.");
        }
        
        String password = request.password();
        if (password.length() < 8) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("비밀번호는 8자 이상 입력해주세요.");
        }
        
        String encodePassword = passwordEncoder.encode(request.password());
        memberRepository.save(Member.builder()
                .email(email)
                .password(encodePassword)
                .build());
        
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입이 완료되었습니다.");
    }
    
    public ResponseEntity<Object> login(MemberRequest request) {
        String email = request.email();
        if (!email.contains("@")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("@를 포함한 E-mail을 입력해주세요.");
        }
        
        String password = request.password();
        if (password.length() < 8) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("비밀번호는 8자 이상 입력해주세요.");
        }
        
        Member member = memberRepository.findByEmail(email).orElse(null);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("가입되지 않은 E-mail 입니다.");
        }
        
        if (!passwordEncoder.matches(password, member.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("비밀번호가 일치하지 않습니다.");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(tokenProvider.generateTokenDto(member));
    }
}
