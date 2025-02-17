package kr.ejsoft.lecture.chap16.quotefunction.service;

import kr.ejsoft.lecture.chap16.quotefunction.domain.Genre;
import kr.ejsoft.lecture.chap16.quotefunction.domain.Quote;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {
    private static final Random random = new Random();
    private static final List<Quote> quotes = List.of(
            new Quote("Content A", "Author 1", Genre.ADVENTURE),
            new Quote("Content B", "Author 2", Genre.FANTASY),
            new Quote("Content C", "Author 3", Genre.ADVENTURE),
            new Quote("Content D", "Author 4", Genre.FANTASY),
            new Quote("Content E", "Author 5", Genre.FANTASY),
            new Quote("Content F", "Author 6", Genre.ADVENTURE),
            new Quote("Content G", "Author 7", Genre.ADVENTURE),
            new Quote("Content H", "Author 8", Genre.SCIENCE_FICTION),
            new Quote("Content I", "Author 9", Genre.ADVENTURE),
            new Quote("Content J", "Author 10", Genre.SCIENCE_FICTION)
    );

    public Flux<Quote> getAllQuotes() {
        return Flux.fromIterable(quotes);
    }

    public Mono<Quote> getRandomQuote() {
        return Mono.just(quotes.get(random.nextInt(quotes.size() -1)));
    }

    public Mono<Quote> getRandomQuoteByGenre(Genre genre) {
        var quotesForGenre = quotes.stream().filter(q -> q.genre().equals(genre)).toList();
        return Mono.just(quotesForGenre.get(random.nextInt(quotesForGenre.size() -1)));
    }
}
