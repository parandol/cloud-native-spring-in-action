package kr.ejsoft.lecture.chap13.catalogservice.persistence;

import kr.ejsoft.lecture.chap13.catalogservice.domain.Book;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

//@Repository
//public class InMemoryBookRepository implements BookRepository {
public class InMemoryBookRepository {
    private static final Map<String, Book> books = new ConcurrentHashMap<>();

//    @Override
    public Iterable<Book> findAll() {
        return books.values();
    }

//    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return existsByIsbn(isbn) ? Optional.of(books.get(isbn))
                : Optional.empty();
    }

//    @Override
    public Book save(Book book) {
        books.put(book.isbn(), book);
        return book;
    }

//    @Override
    public boolean existsByIsbn(String isbn) {
        return books.get(isbn) != null;
    }

//    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }
}
