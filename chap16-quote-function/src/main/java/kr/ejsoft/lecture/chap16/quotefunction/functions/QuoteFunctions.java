package kr.ejsoft.lecture.chap16.quotefunction.functions;

import kr.ejsoft.lecture.chap16.quotefunction.domain.Genre;
import kr.ejsoft.lecture.chap16.quotefunction.domain.Quote;
import kr.ejsoft.lecture.chap16.quotefunction.service.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@Configuration
public class QuoteFunctions {
    @Bean
    Supplier<Flux<Quote>> allQuotes(QuoteService quoteService) {
        return () -> {
            log.info("Getting all quotes");
//            return Flux.fromIterable(quoteService.getAllQuotes()).delaySequence(Duration.ofSeconds(1));
            return quoteService.getAllQuotes().delaySequence(Duration.ofSeconds(1));
        };
    }

    @Bean
    Supplier<Mono<Quote>> randomQuote(QuoteService quoteService) {
        return () -> {
            log.info("Getting random quote");
            return quoteService.getRandomQuote();
        };
    }

    @Bean
    Function<Mono<Genre>, Mono<Quote>> genreQuote(QuoteService quoteService) {
        return mono -> mono.flatMap(genre -> {
            log.info("Getting quote for type {}", genre);
            return quoteService.getRandomQuoteByGenre(genre);
        });
    }

    @Bean
    Consumer<Quote> logQuote() {
        return quote -> log.info("Quote: '{}' by {}", quote.content(), quote.author());
    }
}
