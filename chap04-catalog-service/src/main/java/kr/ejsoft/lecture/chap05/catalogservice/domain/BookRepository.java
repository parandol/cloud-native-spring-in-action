package kr.ejsoft.lecture.chap05.catalogservice.domain;

import java.util.Optional;

public interface BookRepository {
    Iterable<Book> findAll();
    Optional<Book> findByIsbn(String isbn);
    Book save(Book book);
    boolean existsByIsbn(String isbn);
    void deleteByIsbn(String isbn);
}
