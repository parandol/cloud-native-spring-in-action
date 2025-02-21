package kr.ejsoft.lecture.chap13.edgeservice.configure;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.security.Principal;

@Configuration
public class RateLimiterConfigure {
    @Bean
    public KeyResolver keyResolver() {
//        return exchange -> Mono.just("anonymous");
        return exchange -> exchange.getPrincipal()
                .map(Principal::getName)
                .defaultIfEmpty("anonymous");
    }
}
