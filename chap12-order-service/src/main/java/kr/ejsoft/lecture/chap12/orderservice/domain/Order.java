package kr.ejsoft.lecture.chap12.orderservice.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("orders")
public record Order(
        @Id
        Long id,

        String bookIsbn,
        String bookName,
        Double bookPrice,
        Integer quantity,
        OrderStatus status,

        @CreatedDate
        Instant createdAt,

        @LastModifiedDate
        Instant lastModifiedAt,

        @Version
        int version
) {
    public static Order of(
            String isbn, String name, Double price, Integer quantity, OrderStatus status
    ) {
        return new Order(null, isbn, name, price, quantity, status, null, null, 0);
    }
}
