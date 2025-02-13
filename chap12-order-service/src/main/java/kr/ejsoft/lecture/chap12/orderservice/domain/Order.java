package kr.ejsoft.lecture.chap12.orderservice.domain;

import org.springframework.data.annotation.*;
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

        @CreatedBy
        String createdBy,

        @LastModifiedBy
        String lastModifiedBy,

        @Version
        int version
) {
    public static Order of(
            String isbn, String name, Double price, Integer quantity, OrderStatus status
    ) {
        return new Order(null, isbn, name, price, quantity, status, null, null, null, null, 0);
    }
}
