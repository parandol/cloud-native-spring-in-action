package kr.ejsoft.lecture.chap10.orderservice.domain;

//public class Book {
//    String isbn;
//    String title;
//    String author;
//    Double price;
//}

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.Instant;

public record Book(
        String isbn,
        String title,
        String author,
        Double price,
        String publisher
){
        public static Book of(String isbn, String title, String author, Double price, String publisher) {
                return new Book(isbn, title, author, price, publisher);
        }
        public static Book of(String isbn, String title, String author, Double price) {
                return Book.of(isbn, title, author, price, null);
        }
}
