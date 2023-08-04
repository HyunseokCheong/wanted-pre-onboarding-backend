package com.hyunseokcheong.wantedpreonboardingbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HealthController {
    
    @GetMapping("/health")
    public String health() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return "현재 서버시간은 " + localDateTime + "입니다. \n";
    }
}
