package kr.ejsoft.lecture.chap03.catalogservice.domain;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String isbn) {
        super("The book with ISBN " + isbn + " was not found.");
    }
}
