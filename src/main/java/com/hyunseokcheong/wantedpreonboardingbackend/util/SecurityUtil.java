package com.hyunseokcheong.wantedpreonboardingbackend.util;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@AllArgsConstructor
public class SecurityUtil {
    
    public static Long getCurrentMemberId() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (!hasCurrentMemberId(authentication)) {
            return null;
        }
        
        return Long.parseLong(authentication.getName());
    }
    
    public static boolean hasCurrentMemberId(Authentication authentication) {
        return authentication != null && authentication.getName() != null && !authentication.getName().equals("anonymousUser");
    }
}
