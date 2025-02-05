package kr.ejsoft.lecture.chap04.catalogservice.demo;

import kr.ejsoft.lecture.chap04.catalogservice.domain.Book;
import kr.ejsoft.lecture.chap04.catalogservice.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("testdata")
public class BookDataLoader {
    private final BookRepository bookRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        bookRepository.save(new Book("1234567891", "Northern Lights", "Lyra Silverstar", 9.90));
        bookRepository.save(new Book("1234567892", "Polar Journey", "Iorek Polarson", 12.90));
    }
}
