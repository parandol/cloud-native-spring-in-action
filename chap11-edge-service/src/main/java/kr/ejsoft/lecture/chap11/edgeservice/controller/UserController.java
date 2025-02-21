package kr.ejsoft.lecture.chap11.edgeservice.controller;

import kr.ejsoft.lecture.chap11.edgeservice.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {
//    @GetMapping("user")
//    public Mono<User> getUser() {
//        return ReactiveSecurityContextHolder.getContext()
//                .map(SecurityContext::getAuthentication)
//                .map(authentication -> (OidcUser) authentication.getPrincipal())
//                .map(oidcUser -> new User(
//                        oidcUser.getPreferredUsername(),
//                        oidcUser.getGivenName(),
//                        oidcUser.getFamilyName(),
//                        List.of("employee", "customer")
//                ));
//    }

    @GetMapping("user")
    public Mono<User> getUser(@AuthenticationPrincipal OidcUser oidcUser) {
        var user = new User(
                oidcUser.getPreferredUsername(),
                oidcUser.getGivenName(),
                oidcUser.getFamilyName(),
                List.of("employee", "customer")
        );
        return Mono.just(user);
    }
}
