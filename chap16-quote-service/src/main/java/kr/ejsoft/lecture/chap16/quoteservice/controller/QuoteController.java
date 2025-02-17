package kr.ejsoft.lecture.chap16.quoteservice.controller;

import kr.ejsoft.lecture.chap16.quoteservice.domain.Genre;
import kr.ejsoft.lecture.chap16.quoteservice.domain.Quote;
import kr.ejsoft.lecture.chap16.quoteservice.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class QuoteController {
    private final QuoteService quoteService;

    @GetMapping("/quotes")
    public Flux<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }

    @GetMapping("/quotes/random")
    public Mono<Quote> getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @GetMapping("/quotes/random/{genre}")
    public Mono<Quote> getRandomQuoteByGenre(@PathVariable Genre genre) {
        return quoteService.getRandomQuoteByGenre(genre);
    }
}
